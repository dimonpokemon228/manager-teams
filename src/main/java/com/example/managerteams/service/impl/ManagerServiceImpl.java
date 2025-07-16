package com.example.managerteams.service.impl;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.model.dto.CreatePlayerDto;
import com.example.managerteams.model.dto.UpdatePlayerDto;
import com.example.managerteams.model.entity.Player;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.repository.PlayerRepository;
import com.example.managerteams.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final Mapper mapper;

    private final PlayerRepository playerRepository;

    private final ClubRepository clubRepository;


    @Override
    public void deleteAllPlayersAndClubs() {
        playerRepository.deleteAll();
        clubRepository.deleteAll();
    }

    @Override
    public List<CreatePlayerDto> findAllPlayers() {
        var players =  playerRepository.findAll();
        return players.stream()
                .map(player -> mapper.mapCreatePlayerDto(player,  clubRepository.findClubById(player.getClubId())))
                .toList();
    }

    @Override
    public Player updatePlayer(UpdatePlayerDto updatePlayerDto) {
    var player = playerRepository.findPlayerById(updatePlayerDto.playerId());
        return playerRepository.save(mapper.mapPlayerFromUpdateDto(updatePlayerDto, player));
    }
}
