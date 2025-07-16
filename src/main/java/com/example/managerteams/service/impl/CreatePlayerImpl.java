package com.example.managerteams.service.impl;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.model.dto.CreatePlayerDto;
import com.example.managerteams.model.entity.Player;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.repository.PlayerRepository;
import com.example.managerteams.service.CreatePlayer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class CreatePlayerImpl implements CreatePlayer {

    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;
    private final Mapper mapper;

    @Override
    public Player createPlayer(CreatePlayerDto createPlayerDto) {
        var club = clubRepository.findClubByClubName(createPlayerDto.clubName());
        var player = mapper.mapPlayerFromDto(createPlayerDto, club.getId());
        club.setCountPlayers(club.getCountPlayers() + 1);
        playerRepository.save(player);
        clubRepository.save(club);
        return player;
    }
}
