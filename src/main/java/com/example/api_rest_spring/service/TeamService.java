package com.example.api_rest_spring.service;

import com.example.api_rest_spring.domain.Team;

import java.util.List;

public interface TeamService {

    public List<Team> findAllTeams();

    public Team findTeam(Long id);

    public Team createTeam(Team team);

    public void deleteTeam(Long id);

    public Team updateTeam(Team team);
}
