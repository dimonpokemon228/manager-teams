package com.example.managerteams.service;

import com.example.managerteams.model.dto.CreatePlayerDto;
import com.example.managerteams.model.entity.Player;

public interface CreatePlayer {
    public CreatePlayerDto createPlayer(CreatePlayerDto createPlayerDto);
}
