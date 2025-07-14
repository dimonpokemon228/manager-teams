package com.example.managerteams.controller;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.model.dto.CreatePlayerDto;
import com.example.managerteams.model.entity.Club;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.repository.PlayerRepository;
import com.example.managerteams.service.CreatePlayer;
import com.example.managerteams.service.ManagerService;
import com.example.managerteams.service.impl.CreatePlayerImpl;
import com.example.managerteams.service.impl.ManagerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class Controller {

    private final CreatePlayer createPlayerImpl;
    private final ManagerService managerServiceImpl;
    @PostMapping("/save")
    public CreatePlayerDto saveClubAndPlayer(@RequestBody @Validated CreatePlayerDto createPlayerDto){
    return createPlayerImpl.createPlayer(createPlayerDto);
    }


    @DeleteMapping("/delete-all-players-and-club")
    public void deleteAllPlayersAndClubs(){
        managerServiceImpl.deleteAllPlayersAndClubs();
    }

    @GetMapping("/find-all")
    public List<CreatePlayerDto> findAll(){
        return managerServiceImpl.findAllPlayers();
    }
}
