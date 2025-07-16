package com.example.managerteams.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record UpdatePlayerDto(

        @NotNull
        Long playerId,

        Integer age,

        String firstName,

        String lastName,

        Integer number,

        Integer goals,

        Integer assist,

        Boolean isActive) {

}
