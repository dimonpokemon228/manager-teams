package com.example.managerteams.repository;

import com.example.managerteams.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findPlayerByFirstName(String firstName);

    Player findPlayerById(Long playerId);

    Player findPlayerByClubId(Long clubId);

    Player findPlayerByNationalTeamId(Long nationalTeamId);

    List <Player> findTop3ByOrderByGoalsDesc();



}
