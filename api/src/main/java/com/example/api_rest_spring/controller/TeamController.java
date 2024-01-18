package com.example.api_rest_spring.controller;

import com.example.api_rest_spring.domain.Team;
import com.example.api_rest_spring.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return this.teamService.findAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id) {
        return this.teamService.findTeam(id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return this.teamService.createTeam(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        this.teamService.deleteTeam(id);
    }

    @PutMapping("/{id}")
    Team updateTeam(@RequestBody Team team, @PathVariable Long id) {
        Team updatedTeam = this.teamService.findTeam(id);

        if(team != null) {
            updatedTeam.setName(team.getName());
            updatedTeam = this.teamService.updateTeam(updatedTeam);
        }

        return updatedTeam;
    }
}
