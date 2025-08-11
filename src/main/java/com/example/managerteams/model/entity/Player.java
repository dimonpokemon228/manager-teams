package com.example.managerteams.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@ToString
@RequiredArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "player")
@AllArgsConstructor
public final class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "club_name")
    private String clubName;

    @Column(name = "club_id")
    private long clubId;

    private int number;

    private int goals;

    private int assist;

    private int age;

    private String position;

    @Column(name = "national_team_id")
    private Long nationalTeamId;

    @Column(name = "is_Active")
    private boolean isActive;

}
