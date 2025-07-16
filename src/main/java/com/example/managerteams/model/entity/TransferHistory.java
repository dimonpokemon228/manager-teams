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
@Table(name = "transfer_history")
@AllArgsConstructor
public final class TransferHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    Long playerId;

    @NotNull
    @NotEmpty
    String playerLastName;

    @NotNull
    @NotEmpty
    String lastClubName;

    @NotNull
    @NotEmpty
    String newClubName;

    @NotNull
    Long price;
}
