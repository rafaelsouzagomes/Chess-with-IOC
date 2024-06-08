package com.game.chess.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
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
    
    @Autowired
	private SquareBoardFactory squareBoardFactory;

    @Test
    public void testPostConstruct() {
    	chessBoard.createNewGame();
        SquareBoard[][] board = chessBoard.getBoard();
		assertNotNull(board);
        assertEquals(8, board.length);
        assertEquals(8, board[0].length);
        SquareBoard squareRook = squareBoardFactory.build(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.A8);
		assertEquals(squareRook, board[0][0]);
        
        
        chessBoard.showBoard();
    }
}
