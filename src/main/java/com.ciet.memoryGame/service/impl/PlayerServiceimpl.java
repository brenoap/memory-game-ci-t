package com.ciet.memoryGame.service.impl;

import com.ciet.memoryGame.converter.PlayerConverter;
import com.ciet.memoryGame.dto.PlayerDto;
import com.ciet.memoryGame.repository.PlayerRepository;
import com.ciet.memoryGame.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceimpl implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public PlayerDto getPlayerById(Integer playerId) {
        return PlayerConverter.entityToDto(playerRepository.getOne(playerId));
    }

    @Override
    public void savePlayer(PlayerDto playerDto) {
        playerRepository.save(PlayerConverter.dtoToEntity(playerDto));
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        return playerRepository.findAll().stream().map(PlayerConverter::entityToDto).collect(Collectors.toList());
    }
}
