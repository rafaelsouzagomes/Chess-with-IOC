package com.game.chess.services.impls.piece.rook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.IBoard8x8Factory;
import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.configs.CustomTestConfig;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;
import com.game.chess.services.pieces.IMovimentOptions;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(CustomTestConfig.class)
class RookMovimentServiceTest {

	@Autowired
	RookMovimentService rookMovimentService;
	
	@Autowired
	IMovimentOptions iMovimentOptions;
	
	@Autowired
	ChessBoard chess;
	
	@Autowired
	IBoard8x8Factory boardFactory;
	
    @BeforeEach
    void setUp() {
    	chess.createNewGame();
    	iMovimentOptions.setChessBoard(chess);
    }
    
    @Test
	void rook_moviment_v15_initboard() {
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.C5;
		int[] results = rookMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
//		assertEquals(results.length, 8);
//		assertEquals(EnumNameNotaionSquare.C7,EnumNameNotaionSquare.get(results[0], results[1]));
//		assertEquals(EnumNameNotaionSquare.C2,EnumNameNotaionSquare.get(results[2], results[3]));
//		assertEquals(EnumNameNotaionSquare.H5,EnumNameNotaionSquare.get(results[4], results[5]));
//		assertEquals(EnumNameNotaionSquare.A5,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}
	
	@Test
	void rook_moviment_v2_initboard() {
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.A8 ;
		int[] results = rookMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 8);
		assertEquals(EnumNameNotaionSquare.A8,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.A7,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.B8,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.A8,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}
	
	@Test
	void rook_moviment_v3_inittboard() {
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.A8 ;
		int[] results = rookMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 8);
		assertEquals(EnumNameNotaionSquare.A8,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.A7,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.B8,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.A8,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}
	
	
	@Test
	void test_com_classes_v1_customizateBoard() {
		
		chess.showBoard();
		boardFactory.addAllSquare_empty();
		boardFactory.addSquare(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.D5);
		
		SquareBoard[][] squareBoards = boardFactory.build();
		chess.addChessSquareBoard(squareBoards);
		chess.showBoard();
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.D5;
		int[] results = rookMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 8);
		assertEquals(EnumNameNotaionSquare.D8,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.D1,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.H5,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.A5,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}
	
	@Test
	void test_com_classes_v2_customizateBoard() {
		
		chess.showBoard();
		boardFactory.addAllSquare_empty();
		boardFactory.addSquare(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.H1);
		
		SquareBoard[][] squareBoards = boardFactory.build();
		chess.addChessSquareBoard(squareBoards);
		chess.showBoard();
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.H1;
		int[] results = rookMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 8);
		assertEquals(EnumNameNotaionSquare.H8,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.H1,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.H1,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.A1,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}

	
	@Test
	void test_com_classes_v3_customizateBoard() {
		
		chess.showBoard();
		boardFactory.addAllSquare_empty();
		
		boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.G2);
		boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.C2);
		boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.E7);
		
		SquareBoard[][] squareBoards = boardFactory.build();
		chess.addChessSquareBoard(squareBoards);
		chess.showBoard();
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.E2;
		int[] results = rookMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 8);
		assertEquals(EnumNameNotaionSquare.E7,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.E1,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.G2,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.C2,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}
	
	@Test
	void test_com_classes_v4_customizateBoard() {
		
		chess.showBoard();
		boardFactory.addAllSquare_empty();
		
		boardFactory.addSquare(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.H1);
		
		SquareBoard[][] squareBoards = boardFactory.build();
		chess.addChessSquareBoard(squareBoards);
		chess.showBoard();
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.H1;
		int[] results = rookMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 8);
		assertEquals(EnumNameNotaionSquare.H8,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.H1,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.H1,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.A1,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}
	
	
	@Test
	void test_com_classes_v5_customizateBoard() {
		
		chess.showBoard();
		boardFactory.addAllSquare_empty();
		
		boardFactory.addSquare(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.H8);
		
		SquareBoard[][] squareBoards = boardFactory.build();
		chess.addChessSquareBoard(squareBoards);
		chess.showBoard();
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.H8;
		int[] results = rookMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 8);
		assertEquals(EnumNameNotaionSquare.H8,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.H1,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.H8,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.A8,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}
	
	@Test
	void test_com_classes_v6_customizateBoard() {
		
		chess.showBoard();
		boardFactory.addAllSquare_empty();
		
		boardFactory.addSquare(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.A8);
		
		SquareBoard[][] squareBoards = boardFactory.build();
		chess.addChessSquareBoard(squareBoards);
		chess.showBoard();
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.A8;
		int[] results = rookMovimentService.addMoviments(null,square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 8);
		assertEquals(EnumNameNotaionSquare.A8,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.A1,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.H8,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.A8,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}
}
