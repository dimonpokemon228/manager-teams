package com.example.managerteams.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "club", uniqueConstraints = { @UniqueConstraint( columnNames = { "club_name"} ) } )
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "club_name")
    private String clubName;

    @Column(name = "count_players")
    private int countPlayers;

    private int year;
}
