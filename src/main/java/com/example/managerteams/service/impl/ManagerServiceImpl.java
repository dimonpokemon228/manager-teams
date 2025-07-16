package com.example.managerteams.service.impl;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.model.dto.CreatePlayerDto;
import com.example.managerteams.model.dto.TransferPlayerDto;
import com.example.managerteams.model.dto.UpdatePlayerDto;
import com.example.managerteams.model.entity.Player;
import com.example.managerteams.model.entity.TransferHistory;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.repository.PlayerRepository;
import com.example.managerteams.repository.TransferHistoryRepository;
import com.example.managerteams.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final Mapper mapper;

    private final PlayerRepository playerRepository;

    private final ClubRepository clubRepository;

    private final TransferHistoryRepository transferHistoryRepository;

    @Override
    public void deleteAllPlayersAndClubs() {
        playerRepository.deleteAll();
        clubRepository.deleteAll();
    }

    @Override
    public List<CreatePlayerDto> findAllPlayers() {
        var players = playerRepository.findAll();
        return players.stream()
                .map(player -> mapper.mapCreatePlayerDto(player, clubRepository.findClubById(player.getClubId())))
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
}
