package com.example.managerteams.mapper;

import com.example.managerteams.model.dto.CreateClubDto;
import com.example.managerteams.model.dto.CreatePlayerDto;
import com.example.managerteams.model.dto.UpdatePlayerDto;
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
                .age(createPlayerDto.age())
                .build();
    }
    public Club mapClubFromDto(CreateClubDto createClubDto){
        return Club.builder()
                .clubName(createClubDto.clubName())
                .year(createClubDto.year())
                .countPlayers(createClubDto.countPlayers()).
                build();
    }

    public CreatePlayerDto mapCreatePlayerDto(Player player, Club club){
        return CreatePlayerDto.builder()
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .goals(player.getGoals())
                .assist(player.getAssist())
                .number(player.getNumber())
                .clubName(club.getClubName())
                .age(player.getAge())
                .build();
    }
    public Player mapPlayerFromUpdateDto(UpdatePlayerDto updatePlayerDto, Player player){
        return Player.builder()
                .id(player.getId())
                .firstName(updatePlayerDto.firstName() == null ? player.getFirstName() : updatePlayerDto.firstName())
                .lastName(updatePlayerDto.lastName() == null ? player.getLastName() : updatePlayerDto.lastName())
                .age(updatePlayerDto.age() == null ? player.getAge() : updatePlayerDto.age() )
                .assist(updatePlayerDto.assist() == null ? player.getAssist() : updatePlayerDto.assist())
                .number(updatePlayerDto.number() == null ? player.getNumber() : updatePlayerDto.number())
                .goals(updatePlayerDto.goals() == null ? player.getGoals() : updatePlayerDto.goals())
                .isActive(updatePlayerDto.isActive() == null? player.isActive(): updatePlayerDto.isActive())
                .clubId(player.getClubId())
                .build();
    }
}
