package com.ciet.memoryGame.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Player implements Serializable {

    private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer playerId;

    @Column
    private String playerName;

    @Column
    private Integer playerPoints;

    @Column
    private Integer playerPlays;

    public Player() {}

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerPoints = 0;
        this.playerPlays = 0;
    }

    public Integer getPlayerId() { return playerId; }

    public void setPlayerId(Integer playerId) { this.playerId = playerId; }

    public Integer getPlayerPoints() { return playerPoints; }

    public void setPlayerPoints(Integer playerPoints) { this.playerPoints = playerPoints; }

    public Integer getPlayerPlays() { return playerPlays; }

    public void setPlayerPlays(Integer playerPlays) { this.playerPlays = playerPlays; }

    public String getPlayerName() { return playerName; }

    public void setPlayerName(String playerName) { this.playerName = playerName; }
}