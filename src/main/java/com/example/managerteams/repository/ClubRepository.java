package com.example.managerteams.repository;

import com.example.managerteams.model.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Club findClubById(Long clubId);

    Club findClubByClubName(String clubName);

    boolean existsClubByClubName(String clubName);
}


