package com.example.managerteams.service.impl;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.model.dto.*;
import com.example.managerteams.model.entity.Club;
import com.example.managerteams.model.entity.NationalTeam;
import com.example.managerteams.model.entity.Player;
import com.example.managerteams.model.entity.TransferHistory;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.repository.NationalTeamRepository;
import com.example.managerteams.repository.PlayerRepository;
import com.example.managerteams.repository.TransferHistoryRepository;
import com.example.managerteams.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final Mapper mapper;

    private final PlayerRepository playerRepository;

    private final ClubRepository clubRepository;

    private final TransferHistoryRepository transferHistoryRepository;

    private final NationalTeamRepository nationalTeamRepository;

    private final Logger logger = LogManager.getLogger(ManagerServiceImpl.class);

    @Override
    public void deleteAllPlayersAndClubs() {
        playerRepository.deleteAll();
        clubRepository.deleteAll();
    }

    @Override
    public List<PlayerDto> findAllPlayers() {
        var players = playerRepository.findAll();
        logger.info("Find all players: {}", players);
        return players.stream()
                .map(player -> mapper.mapCreatePlayerDto(player, clubRepository.findClubById(player.getClubId()), nationalTeamRepository.findNationalTeamById(player.getNationalTeamId())))
                .toList();
    }

    @Override
    public Player updatePlayer(UpdatePlayerDto updatePlayerDto) {
        var player = playerRepository.findPlayerById(updatePlayerDto.playerId());
        return playerRepository.save(mapper.mapPlayerFromUpdateDto(updatePlayerDto, player));
    }

    @Override
    public TransferPlayerDto transferPlayer(TransferPlayerDto transferPlayerDto) {
        var player = playerRepository.findPlayerById(transferPlayerDto.playerId());
        var lastClub = clubRepository.findClubByClubName(transferPlayerDto.lastClubName());
        var newClub = clubRepository.findClubByClubName(transferPlayerDto.newClubName());

        player.setClubId(newClub.getId());
        playerRepository.save(player);
        lastClub.setCountPlayers(lastClub.getCountPlayers() - 1);
        newClub.setCountPlayers(newClub.getCountPlayers() + 1);

        clubRepository.save(lastClub);
        clubRepository.save(newClub);

        transferHistoryRepository.save(TransferHistory.builder()
                .playerId(player.getId())
                .playerLastName(player.getLastName())
                .lastClubName(lastClub.getClubName())
                .newClubName(newClub.getClubName())
                .price(transferPlayerDto.transferPrice())
                .build());

        return transferPlayerDto;
    }

    public List<TransferPlayerDto> getPlayerTransferHistory(Long playerId) {
        var transferHistories = transferHistoryRepository.findTransferHistoriesByPlayerId(playerId);
        return transferHistories.stream()
                .map(mapper::mapTransferPlayerDto)
                .toList();
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        return clubRepository.save(mapper.mapClubFromDto(clubDto));
    }

    @Override
    public NationalTeam saveNationalTeam(NationalTeamDto createNationalTeamDto) {
       return nationalTeamRepository.save(mapper.mapNationalTeamFromDto(createNationalTeamDto));
    }

    public Player findPlayerByClubId(Long clubId) {
        return playerRepository.findPlayerByClubId(clubId);
    }

    @Override
    public Player findPlayerByNationalTeamId(Long nationalTeamId) {
        return playerRepository.findPlayerByNationalTeamId(nationalTeamId);
    }

    @Override
    public Player createPlayer(PlayerDto playerDto) {
        var club = clubRepository.findClubByClubName(playerDto.clubName());
        var nation = nationalTeamRepository.findNationalTeamByNationalTeamName(playerDto.nationalTeamName());
        var player = mapper.mapPlayerFromDto(playerDto, club.getId(), nation.getId());
        club.setCountPlayers(club.getCountPlayers() + 1);
        nation.setCountPlayers(nation.getCountPlayers() + 1);
        nationalTeamRepository.save(nation);
        playerRepository.save(player);
        clubRepository.save(club);
        return player;
    }

    @Override
    public List <Player> findPlayersByPosition(String position) {
        return playerRepository.findAll();

    }

    @Override
    public List<Player> findTop3ByOrderByGoalsDesc() {
        return playerRepository.findTop3ByOrderByGoalsDesc();
    }

    @Override
    public List<Player> savePlayers(List<PlayerDto> players) {
        Map <String, Club> hashClubMap = new HashMap<>();
        Map <String, NationalTeam> hashNationalTeamMap = new HashMap<>();
        var nationalTeamsNames = players.stream()
                .map(PlayerDto::nationalTeamName )
                .distinct()
                .toList();
        var clubNames = players.stream()
                .map(PlayerDto::clubName)
                .distinct()
                .toList();
        var nationalTeamNames = nationalTeamsNames.stream().map(nationalTeamsName ->
                hashNationalTeamMap.put(nationalTeamsName, nationalTeamRepository.findNationalTeamByNationalTeamName(nationalTeamsName))).toList();
        var clubs =  clubNames.stream().map(clubName -> hashClubMap.put(clubName, clubRepository.findClubByClubName(clubName))).toList();
        return playerRepository.saveAll(players.stream()
                .map(player -> mapper.mapPlayerFromDto(player, clubRepository.findClubByClubName(player.clubName()).getId(),
                        nationalTeamRepository.findNationalTeamByNationalTeamName(player.nationalTeamName()).getId()))
                .toList());
    }

}
