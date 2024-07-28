package com.game.chess.services.impls.piece.queen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.chess.configs.CustomTestConfig;
import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.enums.EnumTypePiece;
import com.game.chess.services.components.Board8x8Factory;
import com.game.chess.services.components.ChessBoard;
import com.game.chess.services.pieces.IMovimentOptions;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(CustomTestConfig.class)
class QueenMovimentServiceTest {
	
	QueenMovimentService movimentService;
	ChessBoard chess;
	Board8x8Factory boardFactory;
	IMovimentOptions iMovimentOptions;
	
    @BeforeEach
    void setUp() {
    	chess.createNewGame();
    	iMovimentOptions.dontCheckCheckMate();
    }
	
	@Test
	void test() {
		EnumNameNotaionSquare square = EnumNameNotaionSquare.C5;
		int[] results = movimentService.addMoviments(square);
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 16);
		
		
		assertEquals(EnumNameNotaionSquare.A7,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.E7,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.A3,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.F2,EnumNameNotaionSquare.get(results[6], results[7]));
		assertEquals(EnumNameNotaionSquare.C7,EnumNameNotaionSquare.get(results[8], results[9]));
		assertEquals(EnumNameNotaionSquare.C2,EnumNameNotaionSquare.get(results[10], results[11]));
		assertEquals(EnumNameNotaionSquare.H5,EnumNameNotaionSquare.get(results[12], results[13]));
		assertEquals(EnumNameNotaionSquare.A5,EnumNameNotaionSquare.get(results[14], results[15]));
	}
	
	@Test
	void test_1() {
		chess.showBoard();
		boardFactory.addAllSquare_empty();
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.A1;
		int[] results = movimentService.addMoviments(square);
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 16);
		
		
		assertEquals(EnumNameNotaionSquare.A1,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.H8,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.A1,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.A1,EnumNameNotaionSquare.get(results[6], results[7]));
		assertEquals(EnumNameNotaionSquare.A8,EnumNameNotaionSquare.get(results[8], results[9]));
		assertEquals(EnumNameNotaionSquare.A1,EnumNameNotaionSquare.get(results[10], results[11]));
		assertEquals(EnumNameNotaionSquare.H1,EnumNameNotaionSquare.get(results[12], results[13]));
		assertEquals(EnumNameNotaionSquare.A1,EnumNameNotaionSquare.get(results[14], results[15]));
	}
	
	@Test
	void test_2() {
		chess.showBoard();
		boardFactory.addAllSquare_empty();
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.E3;
		int[] results = movimentService.addMoviments(square);
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 16);
		
		
		assertEquals(EnumNameNotaionSquare.A7,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.H6,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.C1,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.G1,EnumNameNotaionSquare.get(results[6], results[7]));
		assertEquals(EnumNameNotaionSquare.E8,EnumNameNotaionSquare.get(results[8], results[9]));
		assertEquals(EnumNameNotaionSquare.E1,EnumNameNotaionSquare.get(results[10], results[11]));
		assertEquals(EnumNameNotaionSquare.H3,EnumNameNotaionSquare.get(results[12], results[13]));
		assertEquals(EnumNameNotaionSquare.A3,EnumNameNotaionSquare.get(results[14], results[15]));
	}
	
	@Test
	void test_3() {
		chess.showBoard();
		boardFactory.addAllSquare_empty();
		boardFactory.addSquare(EnumTypePiece.BISHOP, EnumTeam.BLACK, EnumNameNotaionSquare.C3);
		boardFactory.addSquare(EnumTypePiece.BISHOP, EnumTeam.BLACK, EnumNameNotaionSquare.C5);
		boardFactory.addSquare(EnumTypePiece.BISHOP, EnumTeam.BLACK, EnumNameNotaionSquare.B3);
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.C4;
		int[] results = movimentService.addMoviments(square);
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 16);
		
		
		assertEquals(EnumNameNotaionSquare.A6,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.G8,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.B3,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.F1,EnumNameNotaionSquare.get(results[6], results[7]));
		assertEquals(EnumNameNotaionSquare.C5,EnumNameNotaionSquare.get(results[8], results[9]));
		assertEquals(EnumNameNotaionSquare.C3,EnumNameNotaionSquare.get(results[10], results[11]));
		assertEquals(EnumNameNotaionSquare.H4,EnumNameNotaionSquare.get(results[12], results[13]));
		assertEquals(EnumNameNotaionSquare.A4,EnumNameNotaionSquare.get(results[14], results[15]));
	}

	@Autowired
	public void setMovimentService(QueenMovimentService movimentService) {
		this.movimentService = movimentService;
	}
	@Autowired
	public void setChess(ChessBoard chess) {
		this.chess = chess;
	}
	@Autowired
	public void setBoardFactory(Board8x8Factory boardFactory) {
		this.boardFactory = boardFactory;
	}
	
	@Autowired
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
	}
}
