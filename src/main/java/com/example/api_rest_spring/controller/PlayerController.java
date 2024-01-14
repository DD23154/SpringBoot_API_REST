package com.example.api_rest_spring.controller;

import com.example.api_rest_spring.domain.Player;
import com.example.api_rest_spring.dto.PlayerDTO;
import com.example.api_rest_spring.dto.TeamDTO;
import com.example.api_rest_spring.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<PlayerDTO> getAllPlayers() {
        List<Player> players =  this.playerService.findAllPlayers();
        return players.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PlayerDTO convertToDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setPlayerName(player.getName());

        if (player.getTeam() != null) {
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setId(player.getTeam().getId());
            teamDTO.setTeamName(player.getTeam().getName());
            playerDTO.setTeam(teamDTO);
        }
        return playerDTO;
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return playerService.findPlayer(id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return this.playerService.createPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        this.playerService.deletePlayer(id);
    }

    @PutMapping("/{id}")
    Player updatePlayer(@RequestBody Player player, @PathVariable Long id) {
        Player updatedPlayer = this.playerService.findPlayer(id);

        if(player != null) {
            updatedPlayer.setName(player.getName());
            updatedPlayer = this.playerService.updatePlayer(updatedPlayer);
        }
        return updatedPlayer;
    }
}
