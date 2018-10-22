package com.ciet.memoryGame.service;

import java.util.List;

import com.ciet.memoryGame.dto.PlayerDto;

public interface PlayerService {
    PlayerDto getPlayerById(Integer playerId);
    void savePlayer(PlayerDto playerDto);
    List<PlayerDto> getAllPlayers();
}