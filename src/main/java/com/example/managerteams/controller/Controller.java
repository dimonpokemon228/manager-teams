package com.example.managerteams.controller;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.model.dto.CreatePlayerDto;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class Controller {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private Mapper mapper;
    @PostMapping
    public CreatePlayerDto saveClubAndPlayer(@RequestBody @Validated CreatePlayerDto createPlayerDto){
    var club = mapper.mapClubFromDto(createPlayerDto);
    var player = mapper.mapPlayerFromDto(createPlayerDto);
    clubRepository.save(club);
    playerRepository.save(player);
    return createPlayerDto;
}
}
