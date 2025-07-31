package com.example.managerteams.services;

import com.example.managerteams.model.dto.PlayerDto;
import com.example.managerteams.model.dto.TransferPlayerDto;
import com.example.managerteams.model.entity.Club;
import com.example.managerteams.model.entity.Player;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.repository.PlayerRepository;
import com.example.managerteams.repository.TransferHistoryRepository;
import com.example.managerteams.service.ManagerService;
import com.example.managerteams.service.impl.ManagerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ManagerServiceTest {

    @Mock
     ManagerServiceImpl managerService;
    @Mock
     PlayerRepository playerRepository;
    @Mock
     ClubRepository clubRepository;
    @Mock
     TransferHistoryRepository  transferHistoryRepository;
//    @Mock
//    Player player;


    @Test
    public void transferPlayerTest(){
       var trans = TransferPlayerDto.builder()
               .playerId(1L)
               .lastName("lastNameTest")
               .lastClubName("lustClubNameTest")
               .newClubName("newClubNameTest")
               .transferPrice(1000L)
               .build();
       var player = Player.builder()
               .id(1L)
               .lastName("lastNameTest")
               .clubId(1L)
               .build();
       var lastClub =  Club.builder()
               .countPlayers(5)
               .build();
       var newClub =  Club.builder()
               .countPlayers(2)
               .id(5L)
               .build();
       when(playerRepository.findPlayerById(1L)).thenReturn(player);
       when(clubRepository.findClubByClubName("lustClubNameTest")).thenReturn(lastClub);
       when(clubRepository.findClubByClubName("newClubNameTest")).thenReturn(newClub);
       when (managerService.transferPlayer(trans)).thenReturn(trans);
       player.setClubId(newClub.getId());
       lastClub.setCountPlayers(lastClub.getCountPlayers() - 1);
       newClub.setCountPlayers(newClub.getCountPlayers() + 1);
       when(playerRepository.save(player)).thenReturn(player);
       when(clubRepository.save(lastClub)).thenReturn(lastClub);
       when(clubRepository.save(newClub)).thenReturn(newClub);
       when(transferHistoryRepository.save(any())).thenReturn(any());
            managerService.transferPlayer(trans);
            assertEquals(newClub.getId(), player.getClubId());
            assertEquals(4, lastClub.getCountPlayers());
            assertEquals(3, newClub.getCountPlayers());

    }
}
