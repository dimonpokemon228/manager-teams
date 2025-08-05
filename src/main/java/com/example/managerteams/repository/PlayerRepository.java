package com.example.managerteams.repository;

import com.example.managerteams.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findPlayerByFirstName(String firstName);

    Player findPlayerById(Long playerId);

    Player findPlayerByClubId(Long clubId);

    Player findPlayerByNationalTeamId(Long nationalTeamId);

    List <Player> findTop3ByOrderByGoalsDesc();

}
