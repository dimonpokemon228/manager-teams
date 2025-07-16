package com.example.managerteams.service;

import com.example.managerteams.model.dto.CreatePlayerDto;
import com.example.managerteams.model.dto.TransferPlayerDto;
import com.example.managerteams.model.dto.UpdatePlayerDto;
import com.example.managerteams.model.entity.Player;

import java.util.List;

public interface ManagerService {
     void deleteAllPlayersAndClubs();

     List<CreatePlayerDto> findAllPlayers();

     Player updatePlayer(UpdatePlayerDto updatePlayerDto);

     TransferPlayerDto transferPlayer(TransferPlayerDto transferPlayerDto);

     List<TransferPlayerDto> getPlayerTransferHistory(Long playerId);
}