package com.ciet.memoryGame.dto;

public class PlayerDto {
    Integer playerId;
    String playerName;
    Integer playerPoints;
    Integer playerPlays;

    public PlayerDto(Integer playerId, String playerName, Integer playerPoints, Integer playerPlays) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerPoints = playerPoints;
        this.playerPlays = playerPlays;
    }

    public PlayerDto() {}

    public Integer getPlayerId() { return playerId; }

    public void setPlayerId(Integer playerId) { this.playerId = playerId; }

    public String getPlayerName() { return playerName; }

    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public Integer getPlayerPoints() { return playerPoints; }

    public void setPlayerPoints(Integer playerPoints) { this.playerPoints = playerPoints; }

    public Integer getPlayerPlays() { return playerPlays; }

    public void setPlayerPlays(Integer playerPlays) { this.playerPlays = playerPlays; }

}