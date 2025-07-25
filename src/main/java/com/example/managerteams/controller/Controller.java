package com.example.managerteams.controller;

import com.example.managerteams.model.dto.*;
import com.example.managerteams.model.entity.Club;
import com.example.managerteams.model.entity.NationalTeam;
import com.example.managerteams.model.entity.Player;
import com.example.managerteams.service.CreateClub;
import com.example.managerteams.service.CreatePlayer;
import com.example.managerteams.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LogManager.getLogger(Controller.class);

    @PostMapping("/save-player")
    public Player saveClubAndPlayer(@RequestBody @Validated PlayerDto playerDto){
    return managerServiceImpl.createPlayer(playerDto);
    }

    @DeleteMapping("/delete-all-players-and-club")
    public void deleteAllPlayersAndClubs(){
        logger.info("Start to delete all players and clubs");
        managerServiceImpl.deleteAllPlayersAndClubs();
        logger.info("All players and clubs have been deleted");
    }

    @GetMapping("/find-all")
    public List<PlayerDto> findAll(){
        logger.info("Start to find all players and clubs");
        var players =  managerServiceImpl.findAllPlayers();
        logger.info("Complete to find all players and clubs: {}", players);
        return players;
    }

    @PostMapping("/update-player-info")
    public Player updatePlayerInfo(@RequestBody @Validated UpdatePlayerDto updatePlayerDto){
       return managerServiceImpl.updatePlayer(updatePlayerDto);
    }

    @PostMapping("/save-club")
    public Club saveClub(@RequestBody @Validated ClubDto clubDto){
        logger.info("Get club for save: {}", clubDto);
        var clubSave = managerServiceImpl.saveClub(clubDto);
        logger.info("Save club: {}", clubSave);
        return clubSave;
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
        return managerServiceImpl.findPlayersByPosition(position);
    }

    @GetMapping("/top-3-goleadors")
    public List <Player> findTop3ByOrderByGoalsDesc(){
        return managerServiceImpl.findTop3ByOrderByGoalsDesc();
    }

    @PostMapping("/save-players")
    public List <Player> savePlayers(@RequestBody @Validated List <PlayerDto> players){
        return managerServiceImpl.savePlayers(players);
    }
}
