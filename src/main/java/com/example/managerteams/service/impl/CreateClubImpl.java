package com.example.managerteams.service.impl;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.service.CreateClub;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
public class CreateClubImpl implements CreateClub {

    private  ClubRepository clubRepository;

    public CreateClubImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
//    private final Mapper mapper;
}
