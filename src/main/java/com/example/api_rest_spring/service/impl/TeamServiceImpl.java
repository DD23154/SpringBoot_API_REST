package com.example.api_rest_spring.service.impl;

import com.example.api_rest_spring.dao.TeamRepository;
import com.example.api_rest_spring.domain.Team;
import com.example.api_rest_spring.service.TeamService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    @Transactional
    public List<Team> findAllTeams(){
        return this.teamRepository.findAll();
    }

    @Override
    @Transactional
    public Team findTeam(Long id){
        return this.teamRepository.findById(id).orElse(null);
    }

    @Override
    public Team createTeam(Team team){
        return this.teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Long id){
        this.teamRepository.deleteById(id);
    }

    @Override
    public Team updateTeam(Team team){
        return this.teamRepository.save(team);
    }
}
