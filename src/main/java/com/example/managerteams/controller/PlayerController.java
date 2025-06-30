package com.example.managerteams.controller;

import com.example.managerteams.model.entity.Player;
import com.example.managerteams.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/player")
@RestController
@RequiredArgsConstructor
public class PlayerController {
   @Autowired
    private PlayerRepository playerRepository;
    @GetMapping
    public String getString() {
        return "this is a Player";
    }
     @PostMapping("/save")
    public Player savePlayer(@RequestBody Player player){
        return playerRepository.save(player);
     }
     @DeleteMapping("/delete-all")
     public void deletePlayer(){
        playerRepository.deleteAll();
     }
}