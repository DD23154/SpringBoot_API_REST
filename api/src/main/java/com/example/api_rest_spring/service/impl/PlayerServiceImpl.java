package com.example.api_rest_spring.service.impl;

import com.example.api_rest_spring.dao.PlayerRepository;
import com.example.api_rest_spring.domain.Player;
import com.example.api_rest_spring.service.PlayerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    @Transactional
    public List<Player> findAllPlayers(){
        return this.playerRepository.findAll();
    }

    @Override
    @Transactional
    public Player findPlayer(Long id){
        return this.playerRepository.findById(id).orElse(null);
    }

    @Override
    public Player createPlayer(Player player){
        return this.playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Long id){
        this.playerRepository.deleteById(id);
    }

    @Override
    public Player updatePlayer(Player player){
        return this.playerRepository.save(player);
    }
}
