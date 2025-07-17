package com.example.managerteams.repository;

import com.example.managerteams.model.entity.NationalTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalTeamRepository extends JpaRepository<NationalTeam,Long> {
    NationalTeam findNationalTeamByNationalTeamName (String nationalTeamName);

    NationalTeam findNationalTeamById(Long nationalTeamId);
}
