package com.example.managerteams.mapper;

import com.example.managerteams.model.dto.CreatePlayerDto;
import com.example.managerteams.model.entity.Club;
import com.example.managerteams.model.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Mapper {
    public Player mapPlayerFromDto(CreatePlayerDto createPlayerDto){
        return Player.builder()
                .firstName(createPlayerDto.firstName())
                .lastName(createPlayerDto.lastName())
                .number(createPlayerDto.number())
                .goals(createPlayerDto.goals())
                .assist(createPlayerDto.assist())
                .isActive(createPlayerDto.isActive()).build();
    }
    public Club mapClubFromDto(CreatePlayerDto createPlayerDto){
        return Club.builder()
                .clubName(createPlayerDto.clubName())
                .year(createPlayerDto.year())
                .countPlayers(createPlayerDto.countPlayers()).build();
    }

}
