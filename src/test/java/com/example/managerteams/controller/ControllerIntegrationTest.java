package com.example.managerteams.controller;

import com.example.managerteams.model.dto.ClubDto;
import com.example.managerteams.model.dto.PlayerDto;
import com.example.managerteams.model.dto.TransferPlayerDto;
import com.example.managerteams.model.entity.Club;
import com.example.managerteams.model.entity.NationalTeam;
import com.example.managerteams.model.entity.Player;
import com.example.managerteams.repository.ClubRepository;
import com.example.managerteams.repository.NationalTeamRepository;
import com.example.managerteams.repository.PlayerRepository;
import com.example.managerteams.repository.TransferHistoryRepository;
import com.example.managerteams.service.impl.ManagerServiceImpl;
import org.hibernate.dialect.aggregate.PostgreSQLAggregateSupport;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Testcontainers
public class ControllerIntegrationTest {

    @Container
    @ServiceConnection
    public static PostgreSQLContainer <?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15.3")
            .withInitScript("init.sql");

    @Autowired
    ManagerServiceImpl managerServiceImpl;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TransferHistoryRepository transferHistoryRepository;
    @Autowired
    NationalTeamRepository nationalTeamRepository;

    @BeforeAll
    static void beforeAll() {
        postgreSQLContainer.start();
    }

    @AfterAll
    static void afterAll() {
        postgreSQLContainer.stop();
    }


    @Test
    void saveClub() throws Exception {
ClubDto clubDto = new ClubDto("ATM", 23, 1900);
 managerServiceImpl.saveClub(clubDto);
 var club = clubRepository.findClubByClubName("ATM");
 assertEquals(club.getClubName(),"ATM");
    }

    @Test
    void transferPlayerTest() throws Exception{
        var player = Player.builder()
                .age(18)
                .assist(12)
                .goals(23)
                .clubName("ATM")
                .firstName("Dimon")
                .lastName("Pokemon")
                .isActive(true)
                .number(16)
                .position("Striker")
                .build();
        var lastClub = Club.builder()
                .clubName("ATM")
                .countPlayers(3)
                .year(1900)
                .build();
        var newClub = Club.builder()
                .clubName("BVB")
                .year(1988)
                .countPlayers(4)
                .build();

        var trans = TransferPlayerDto.builder()
                .playerId(1L)
                .lastClubName("ATM")
                .newClubName("BVB")
                .transferPrice(122222L)
                .build();

        playerRepository.save(player);
        clubRepository.save(lastClub);
        clubRepository.save(newClub);
        managerServiceImpl.transferPlayer(trans);
        assertEquals(playerRepository.findPlayerById(1L).getClubName(),"BVB" );
        assertEquals(clubRepository.findClubByClubName("ATM").getCountPlayers(),2 );
        assertEquals(clubRepository.findClubByClubName("BVB").getCountPlayers(),5 );
        assertEquals(transferHistoryRepository.findTransferHistoriesByPlayerId(1L).get(0).getPlayerId(),1  );

    }
    @Test
    void savePlayer() throws Exception{
        var player = PlayerDto.builder()
                .age(18)
                .assist(12)
                .goals(23)
                .clubName("ATM")
                .firstName("Dimon")
                .lastName("Pokemon")
                .isActive(true)
                .number(16)
                .nationalTeamName("Russia")
                .position("Striker")
                .build();
        var nation = NationalTeam.builder()
                .countPlayers(23)
                .nationalTeamName("Russia")
                .build();
        var club = Club.builder()
                .clubName("ATM")
                .countPlayers(3)
                .year(1900)
                .build();
        clubRepository.save(club);
        nationalTeamRepository.save(nation);
        managerServiceImpl.createPlayer(player);
        assertEquals(playerRepository.findPlayerByFirstName("Dimon").getFirstName(), "Dimon");
        assertEquals(clubRepository.findClubByClubName("ATM").getCountPlayers(), 4);
        assertEquals(nationalTeamRepository.findNationalTeamByNationalTeamName("Russia").getCountPlayers(), 24);
    }




}
