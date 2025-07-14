package com.example.managerteams.service.impl;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.model.dto.CreatePlayerDto;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.repository.PlayerRepository;
import com.example.managerteams.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
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
}
