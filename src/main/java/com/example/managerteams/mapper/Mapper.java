package com.example.managerteams.mapper;

import com.example.managerteams.model.dto.*;
import com.example.managerteams.model.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Mapper {
    public Player mapPlayerFromDto(PlayerDto playerDto, Club club, NationalTeam nationalTeam) {
        return Player.builder()
                .firstName(playerDto.firstName())
                .lastName(playerDto.lastName())
                .number(playerDto.number())
                .goals(playerDto.goals())
                .assist(playerDto.assist())
                .isActive(playerDto.isActive())
                .clubId(club.getId())
                .age(playerDto.age())
                .position(playerDto.position())
                .nationalTeamId(nationalTeam.getId())
                .clubName(club.getClubName())
                .build();
    }

    public Club mapClubFromDto(ClubDto clubDto) {
        return Club.builder()
                .clubName(clubDto.clubName())
                .year(clubDto.year())
                .countPlayers(clubDto.countPlayers()).
                build();
    }

    public PlayerDto mapCreatePlayerDto(Player player, Club club, NationalTeam nationalTeam) {
        return PlayerDto.builder()
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .goals(player.getGoals())
                .assist(player.getAssist())
                .number(player.getNumber())
                .clubName(club.getClubName())
                .age(player.getAge())
                .position(player.getPosition())
                .nationalTeamName(nationalTeam.getNationalTeamName())
                .build();
    }

    public Player mapPlayerFromUpdateDto(UpdatePlayerDto updatePlayerDto, Player player) {
        return Player.builder()
                .id(player.getId())
                .firstName(updatePlayerDto.firstName() == null ? player.getFirstName() : updatePlayerDto.firstName())
                .lastName(updatePlayerDto.lastName() == null ? player.getLastName() : updatePlayerDto.lastName())
                .age(updatePlayerDto.age() == null ? player.getAge() : updatePlayerDto.age())
                .assist(updatePlayerDto.assist() == null ? player.getAssist() : updatePlayerDto.assist())
                .position(updatePlayerDto.position() == null ? player.getPosition() : updatePlayerDto.position())
                .number(updatePlayerDto.number() == null ? player.getNumber() : updatePlayerDto.number())
                .goals(updatePlayerDto.goals() == null ? player.getGoals() : updatePlayerDto.goals())
                .isActive(updatePlayerDto.isActive() == null ? player.isActive() : updatePlayerDto.isActive())
                .clubId(player.getClubId())
                .build();
    }

    public TransferPlayerDto mapTransferPlayerDto(TransferHistory transferHistory) {
        return TransferPlayerDto.builder()
                .playerId(transferHistory.getPlayerId())
                .lastClubName(transferHistory.getLastClubName())
                .newClubName(transferHistory.getNewClubName())
                .transferPrice(transferHistory.getPrice())
                .build();
    }

    public NationalTeamDto mapCreateNationalTeamDto(NationalTeam nationalTeam){
        return NationalTeamDto.builder()
                .nationalTeamName(nationalTeam.getNationalTeamName())
                .countPlayers(nationalTeam.getCountPlayers())
                .build();
    }
    public NationalTeam mapNationalTeamFromDto(NationalTeamDto createNationalTeamDto) {
        return NationalTeam.builder()
                .nationalTeamName(createNationalTeamDto.nationalTeamName())
                .countPlayers(createNationalTeamDto.countPlayers())
                .build();
    }
    public UserDto mapCreateUserDto (Users user){
       return UserDto.builder().name(user.getName())
                .role(user.getRole())
               .password(user.getPassword())
               .build();
    }
    public Users mapUserFromDto(UserDto userDto){
        return Users.builder()
                .name(userDto.name())
                .role(userDto.role())
                .password(userDto.password())
                .build();

    }
}
