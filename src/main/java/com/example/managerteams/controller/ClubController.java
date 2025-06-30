package com.example.managerteams.controller;

import com.example.managerteams.model.entity.Club;
import com.example.managerteams.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/club")
@RestController
public class ClubController {
@Autowired
    private ClubRepository clubRepository;
    @GetMapping
    public String getString(){
    return "this is a Club";
    }
@PostMapping("/save")
    public Club saveClub(@RequestBody Club club){
    return clubRepository.save(club);
}
@DeleteMapping("/delete-all")
    public void deleteClub(){
        clubRepository.deleteAll();
    }
@DeleteMapping("/delete-byId")
    public void deleteClubById(@RequestParam Long id){
        clubRepository.deleteById(id);
}
}
