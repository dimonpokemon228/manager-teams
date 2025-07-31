package com.example.managerteams.controller;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.model.dto.ClubDto;
import com.example.managerteams.model.dto.TransferPlayerDto;
import com.example.managerteams.model.entity.Club;
import com.example.managerteams.model.entity.TransferHistory;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.repository.NationalTeamRepository;
import com.example.managerteams.repository.PlayerRepository;
import com.example.managerteams.service.impl.ManagerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ControllerTest {


    @Mock
    ManagerServiceImpl  managerService;
    @Mock
    PlayerRepository playerRepository;
    @Mock
    ClubRepository clubRepository;
    @Mock
    TransferHistory transferHistory;
    @Mock
    TransferPlayerDto transferPlayerDto;
    @Mock
    Mapper mapper;
    @InjectMocks
    Controller controller;

    @Test
    void saveClubTest() {
        ClubDto clubDto = new ClubDto("clubNameTest", 3, 2018);
        var club = mapper.mapClubFromDto(clubDto);
        when(managerService.saveClub(clubDto)).thenReturn(club);
        assertEquals(club, controller.saveClub(clubDto));
    }

}