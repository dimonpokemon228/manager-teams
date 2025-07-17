package com.example.managerteams.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record PlayerDto(
        @NotNull
        String clubName,

        @NotNull
        Integer age,

        @NotNull
        @NotEmpty
        String firstName,

        @NotNull
        @NotEmpty
        String lastName,

        @NotNull
        Integer number,

        @NotNull
        Integer goals,

        @NotNull
        Integer assist,

        @NotNull
        @NotEmpty
        String position,

        @NotNull
        String nationalTeamName,

        Boolean isActive
) {

}
