package com.game.chess.configs;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.game.chess.services.impls.piece.pawn.WhitePawnTeamManager;
import com.game.chess.services.pieces.pawn.ITeamManager;

@TestConfiguration
public class CustomTestConfig {

    @Bean
    @Primary
    public ITeamManager testTeamManager() {
        return new WhitePawnTeamManager();
    }
}