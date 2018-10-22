package com.ciet.memoryGame.converter;

import java.util.stream.Collectors;

import com.ciet.memoryGame.dto.PlayerDto;
import com.ciet.memoryGame.entity.Player;

public class PlayerConverter {
    public static Player dtoToEntity(PlayerDto playerDto) {
        Player player = new Player(playerDto.getPlayerName());
        player.setPlayerId(playerDto.getPlayerId());

        return player;
    }

    public static PlayerDto entityToDto(Player player) {
        PlayerDto playerDto = new PlayerDto(player.getPlayerId(), player.getPlayerName(), player.getPlayerPoints(), player.getPlayerPlays());
        return playerDto;
    }
}
