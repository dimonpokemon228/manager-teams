package com.example.managerteams.controller;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.model.dto.*;
import com.example.managerteams.model.entity.Club;
import com.example.managerteams.model.entity.NationalTeam;
import com.example.managerteams.model.entity.Player;
import com.example.managerteams.repository.PlayerRepository;
import com.example.managerteams.service.CreateClub;
import com.example.managerteams.service.CreatePlayer;
import com.example.managerteams.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class Controller {

    private final CreatePlayer createPlayerImpl;
    private final ManagerService managerServiceImpl;
    private final CreateClub createClubImpl;
    private final Mapper mapper;
    private final PlayerRepository playerRepository;

    @PostMapping("/save-player")
    public Player saveClubAndPlayer(@RequestBody @Validated PlayerDto playerDto){
    return managerServiceImpl.createPlayer(playerDto);
    }

    @DeleteMapping("/delete-all-players-and-club")
    public void deleteAllPlayersAndClubs(){
        managerServiceImpl.deleteAllPlayersAndClubs();
    }

    @GetMapping("/find-all")
    public List<PlayerDto> findAll(){
        return managerServiceImpl.findAllPlayers();
    }

    @PostMapping("/update-player-info")
    public Player updatePlayerInfo(@RequestBody @Validated UpdatePlayerDto updatePlayerDto){
       return managerServiceImpl.updatePlayer(updatePlayerDto);
    }

    @PostMapping("/save-club")
    public Club saveClub(@RequestBody @Validated ClubDto clubDto){
        return managerServiceImpl.saveClub(clubDto);
    }

    @PostMapping("/transfer-player")
    public TransferPlayerDto transferPlayer(@RequestBody @Validated TransferPlayerDto transferPlayerDto){
      return managerServiceImpl.transferPlayer(transferPlayerDto);
    }

    @GetMapping("/player-transfer-history/{playerId}")
    public List<TransferPlayerDto> getPlayerTransferHistory(@PathVariable("playerId") Long playerId){
        return managerServiceImpl.getPlayerTransferHistory(playerId);
    }

    @PostMapping("/save-national-team")
    public NationalTeam saveNationalTeam(@RequestBody @Validated NationalTeamDto createNationalTeamDto){
        return managerServiceImpl.saveNationalTeam(createNationalTeamDto);
    }

    @GetMapping("/find-player-by-club-id")
    public Player findPlayerByClubId(@RequestParam Long clubId){
        return managerServiceImpl.findPlayerByClubId(clubId);
    }

    @GetMapping("/find-player-by-national-team-id")
    public Player findPlayerByNationalTeamId(@RequestParam Long nationalTeamId){
        return managerServiceImpl.findPlayerByNationalTeamId(nationalTeamId);
    }

    @GetMapping("/find-players-by-position")
    public List <Player> findPlayersByPosition(@RequestParam String position){
        return playerRepository.findPlayersByPosition(position);
    }
}
