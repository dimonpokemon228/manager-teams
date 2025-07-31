package com.example.managerteams.controller;

import com.example.managerteams.model.entity.Club;
import com.example.managerteams.repository.ClubRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ClubControllerTest {

    @Mock
    private ClubRepository clubRepository;
    @InjectMocks
    private ClubController clubController;

    @Test
    void findClubById() {
    var club = new Club();
    club.setId(1L);
    when(clubRepository.findById(club.getId())).thenReturn(Optional.of(club));
    assertEquals(club, clubController.findClubById(club.getId()));
    }
}
