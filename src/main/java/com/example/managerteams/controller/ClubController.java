package com.example.managerteams.controller;

import com.example.managerteams.model.entity.Club;
import com.example.managerteams.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/club")
@RestController
@RequiredArgsConstructor
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
@GetMapping("/findAll")
    public List<Club> findAllClub() {
    return  clubRepository.findAll();
}
@GetMapping("/findById")
    public Club findClubById(@RequestParam Long id){
        return clubRepository.findById(id).get();
}

}
