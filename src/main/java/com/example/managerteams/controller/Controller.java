package com.example.managerteams.controller;

import com.example.managerteams.model.dto.CreatePlayerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class Controller {

    @PostMapping
    public CreatePlayerDto saveClubAndPlayer(@RequestBody CreatePlayerDto createplayerdto){

    return CreatePlayerDto.builder().build();
}
}
