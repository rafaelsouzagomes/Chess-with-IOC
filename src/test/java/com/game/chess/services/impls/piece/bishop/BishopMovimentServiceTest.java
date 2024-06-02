package com.game.chess.services.impls.piece.bishop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.chess.components.Board8x8Factory;
import com.game.chess.components.ChessBoard;
import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.configs.CustomTestConfig;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;
import com.game.chess.services.pieces.IMovimentOptions;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(CustomTestConfig.class)
class BishopMovimentServiceTest {

	@Autowired
	BishopMovimentService bishopMovimentService;
	
	@Autowired
	IMovimentOptions iMovimentOptions;
	
	@Autowired
	ChessBoard chess;
	
	
	@Autowired
	Board8x8Factory boardFactory;
	
    @BeforeEach
    void setUp() {
    	chess.createNewGame();
    	iMovimentOptions.setChessBoard(chess);
    }
    
	@Test
	void test() {
		EnumNameNotaionSquare square = EnumNameNotaionSquare.C5;
		int[] results = bishopMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 8);
		assertEquals(EnumNameNotaionSquare.A7,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.E7,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.A3,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.F2,EnumNameNotaionSquare.get(results[6], results[7]));
	}
	
	
	@Test
	void test_com_classes_v2_customizateBoard() {
		
		chess.showBoard();
		boardFactory.addAllSquare_empty();
		boardFactory.addSquare(EnumTypePiece.BISHOP, EnumTeam.BLACK, EnumNameNotaionSquare.D5);
		
		SquareBoard[][] squareBoards = boardFactory.build();
		chess.addChessSquareBoard(squareBoards);
		chess.showBoard();
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.D5;
		int[] results = bishopMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 8);
		assertEquals(EnumNameNotaionSquare.A8,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.G8,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.A2,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.H1,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}
	
	
	@Test
	void test_com_classes_v3_customizateBoard() {
		
		chess.showBoard();
		boardFactory.addAllSquare_empty();
		boardFactory.addSquare(EnumTypePiece.BISHOP, EnumTeam.BLACK, EnumNameNotaionSquare.H1);
		
		SquareBoard[][] squareBoards = boardFactory.build();
		chess.addChessSquareBoard(squareBoards);
		chess.showBoard();
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.H1;
		int[] results = bishopMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		assertEquals(results.length, 8);
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(EnumNameNotaionSquare.A8,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.H1,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.H1,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.H1,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}

}
