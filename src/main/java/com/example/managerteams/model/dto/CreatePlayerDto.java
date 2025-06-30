package com.example.managerteams.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record CreatePlayerDto(
        @NotNull
        @NotEmpty
        String clubName,

        @NotNull
        @NotEmpty
        int countPlayers,
        int year,

        @NotNull
        @NotEmpty
        String firstName,

        @NotNull
        @NotEmpty
        String lastName,

        @NotNull
        @NotEmpty
        int number,

        @NotNull
        @NotEmpty
        int goals,

        @NotNull
        @NotEmpty
        int assist,

        boolean isActive) {

}
