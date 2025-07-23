package com.example.managerteams.util;

import com.example.managerteams.model.dto.PlayerDto;
import com.example.managerteams.model.entity.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class Converts {
    private Converts() {}

    private static final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public static PlayerDto mapPlayerFromDto(String player) {
        return mapper.readValue(player, PlayerDto.class);
    }
}
