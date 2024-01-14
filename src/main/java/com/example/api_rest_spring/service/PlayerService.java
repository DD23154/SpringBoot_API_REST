package com.example.api_rest_spring.service;

import com.example.api_rest_spring.domain.Player;

import java.util.List;

public interface PlayerService {

    public List<Player> findAllPlayers();

    public Player findPlayer(Long id);

    public Player createPlayer(Player player);

    public void deletePlayer(Long id);

    public Player updatePlayer(Player player);
}
