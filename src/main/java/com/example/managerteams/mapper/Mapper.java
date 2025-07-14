package com.example.managerteams.mapper;

import com.example.managerteams.model.dto.CreatePlayerDto;
import com.example.managerteams.model.entity.Club;
import com.example.managerteams.model.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Mapper {
    public Player mapPlayerFromDto(CreatePlayerDto createPlayerDto, Long clubId){
        return Player.builder()
                .firstName(createPlayerDto.firstName())
                .lastName(createPlayerDto.lastName())
                .number(createPlayerDto.number())
                .goals(createPlayerDto.goals())
                .assist(createPlayerDto.assist())
                .isActive(createPlayerDto.isActive())
                .clubId(clubId)
                .build();
    }
    public Club mapClubFromDto(CreatePlayerDto createPlayerDto){
        return Club.builder()
                .clubName(createPlayerDto.clubName())
                .year(createPlayerDto.year())
                .countPlayers(createPlayerDto.countPlayers()).build();
    }

    public CreatePlayerDto mapCreatePlayerDto(Player player, Club club){
        return CreatePlayerDto.builder()
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .goals(player.getGoals())
                .assist(player.getAssist())
                .number(player.getNumber())
                .year(club.getYear())
                .countPlayers(club.getCountPlayers())
                .clubName(club.getClubName())
                .build();
    }
}
