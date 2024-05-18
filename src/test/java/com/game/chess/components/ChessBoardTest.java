package com.game.chess.components;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.components.chessSquare.SquareBoardFactory;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = "com.game.chess")
class ChessBoardTest {

    @Autowired
    private ChessBoard chessBoard;

    @Test
    public void testPostConstruct() {
    	chessBoard.createNewGame();
        assertNotNull(chessBoard.getBoard());
        assertEquals(8, chessBoard.getBoard().length);
        assertEquals(8, chessBoard.getBoard()[0].length);
        chessBoard.showBoard();
    }
}
