package com.example.managerteams.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "national_team", uniqueConstraints = { @UniqueConstraint( columnNames = { "national_team_name"} ) } )
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NationalTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "national_team_name")
    String nationalTeamName;

    @Column(name = "count_players")
    Integer countPlayers;

}
