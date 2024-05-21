package com.game.chess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.ChessBoardFactory;

@Configuration
public class TestConfig {

    @Bean
    @Primary
    @Scope("prototype")
    public ChessBoard testChessBoard() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.setChessBoardFactory(new ChessBoardFactory()); // Initialize with a factory
        return chessBoard;
    }
}