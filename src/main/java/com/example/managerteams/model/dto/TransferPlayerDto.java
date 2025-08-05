package com.example.managerteams.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record TransferPlayerDto(
        @NotNull
        Long playerId,



        @NotNull
        @NotEmpty
        String lastClubName,

        @NotNull
        @NotEmpty
        String newClubName,

        @NotNull
        Long transferPrice
) {
}
