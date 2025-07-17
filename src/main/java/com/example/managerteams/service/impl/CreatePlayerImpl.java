package com.example.managerteams.service.impl;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.repository.NationalTeamRepository;
import com.example.managerteams.repository.PlayerRepository;
import com.example.managerteams.service.CreatePlayer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreatePlayerImpl implements CreatePlayer {

    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;
    private final NationalTeamRepository nationalTeamRepository;
    private final Mapper mapper;
}
