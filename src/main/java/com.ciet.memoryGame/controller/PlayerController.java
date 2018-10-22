package com.ciet.memoryGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ciet.memoryGame.dto.PlayerDto;
import com.ciet.memoryGame.service.PlayerService;
import com.ciet.memoryGame.utils.Constants;

@RequestMapping("/player")
@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @RequestMapping(Constants.GET_PLAYER_BY_ID)
    public PlayerDto getPlayerById(@PathVariable Integer playerId) {
        return playerService.getPlayerById(playerId);
    }

    @RequestMapping(Constants.GET_ALL_PLAYERS)
    public List<PlayerDto> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @RequestMapping(value= Constants.SAVE_PLAYER, method= RequestMethod.POST)
    public void savePlayer(@RequestBody PlayerDto playerDto) {
        playerService.savePlayer(playerDto);
    }
}