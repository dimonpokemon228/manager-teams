package com.example.managerteams.model.entity;

import jakarta.persistence.*;
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

    @Column(name = "club_id")
    private long clubId;

    private int number;

    private int goals;

    private int assist;

    @Column(name = "is_Active")
    private boolean isActive;


}
