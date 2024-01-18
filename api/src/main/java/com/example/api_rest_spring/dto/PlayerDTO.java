package com.example.api_rest_spring.dto;

public class PlayerDTO {
    private Long id;
    private String playerName;
    private TeamDTO team;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public TeamDTO getTeam() { return team; }
    public void setTeam(TeamDTO team) { this.team = team; }
}
