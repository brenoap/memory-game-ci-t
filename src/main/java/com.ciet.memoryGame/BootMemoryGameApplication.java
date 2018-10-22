package com.ciet.memoryGame;

import com.ciet.memoryGame.entity.Player;
import com.ciet.memoryGame.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class BootMemoryGameApplication {
    @Autowired
    PlayerRepository playerRepository;

    public static void main(String [] args) {
        SpringApplication.run(BootMemoryGameApplication.class, args);
    }

    @PostConstruct
    public void setupDBWithData() {
        Player player = new Player("Ash Ketchum");
        player = playerRepository.save(player);
    }
}