package com.example.managerteams.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Testcontainers
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saveClub() throws Exception {
    String jsonRequest = "{\"clubName\":\"clubNameTest\",\"countPlayers\":5,\"year\":2006}";
    var response = mockMvc.perform(
            post("/save-club")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonRequest)
    ).andReturn();
    String resultJson =  response.getResponse().getContentAsString();
    assertEquals("{\"id\":1\"clubName\":\"clubNameTest\",\"countPlayers\":5,\"year\":2006}", resultJson);

    }
}
