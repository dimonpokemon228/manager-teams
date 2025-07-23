package com.example.managerteams.service;

import com.example.managerteams.model.dto.*;
import com.example.managerteams.model.entity.Club;
import com.example.managerteams.model.entity.NationalTeam;
import com.example.managerteams.model.entity.Player;

import java.util.List;

public interface ManagerService {
     void deleteAllPlayersAndClubs();

     List<PlayerDto> findAllPlayers();

     Player updatePlayer(UpdatePlayerDto updatePlayerDto);

     TransferPlayerDto transferPlayer(TransferPlayerDto transferPlayerDto);

     List<TransferPlayerDto> getPlayerTransferHistory(Long playerId);

     Club saveClub(ClubDto clubDto);

     NationalTeam saveNationalTeam(NationalTeamDto createNationalTeamDto);

     Player findPlayerByClubId(Long clubId);

     Player findPlayerByNationalTeamId(Long nationalTeamId);

     Player createPlayer(PlayerDto playerDto);

     List <Player> findPlayersByPosition(String position);

     List <Player> findTop3ByOrderByGoalsDesc();

     List <Player> savePlayers(List <PlayerDto> players);
}