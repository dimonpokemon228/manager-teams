package com.example.managerteams.service;

import com.example.managerteams.model.dto.CreatePlayerDto;

import java.util.List;

public interface ManagerService {
     void deleteAllPlayersAndClubs();

     List<CreatePlayerDto> findAllPlayers();
    }