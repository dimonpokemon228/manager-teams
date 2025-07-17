package com.example.managerteams.service.impl;

import com.example.managerteams.mapper.Mapper;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.service.CreateClub;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CreateClubImpl implements CreateClub {

    private final ClubRepository clubRepository;
    private final Mapper mapper;
}
