package com.game.chess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.ChessBoardFactory;
import com.game.chess.enums.NamePieces;
import com.game.chess.services.impls.piece.PawnMovimentService;
import com.game.chess.services.pieces.IMovimentPiece;

@Configuration
@ComponentScan(basePackages = "com.game.chess")
public class TestConfig {

    @Bean
    @Primary
    @Scope("prototype")
    public ChessBoard testChessBoard(ChessBoardFactory chessBoardFactory) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.setChessBoardFactory(chessBoardFactory);
        return chessBoard;
    }
    
    @Bean(name = NamePieces.PAWN)
    @Primary
    public IMovimentPiece pawnMovimentService() {
        return new PawnMovimentService();
    }
}