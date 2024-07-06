package com.game.chess.services.impls.piece.knight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.chess.components.ChessBoard;
import com.game.chess.configs.CustomTestConfig;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.services.pieces.IMovimentOptions;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(CustomTestConfig.class)
class KnightMovimentServiceTest {

	KnightMovimentService service;
	IMovimentOptions iMovimentOptions;
	ChessBoard chess;
	
	@BeforeEach
    void setUp() {
    	chess.createNewGame();
    	iMovimentOptions.setChessBoard(chess);
    	service.setiMovimentOptions(iMovimentOptions);
    	iMovimentOptions.dontCheckCheckMate();
    }
	
	@Test
	void test() {
		EnumNameNotaionSquare square = EnumNameNotaionSquare.C5;
		List<int[]> results = service.addMoviments(square);
		
		for(int i=0; i < results.size(); i++) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results.get(i)[0], results.get(i)[1]);
			System.out.println(enumNotation.name());
		}
		assertEquals(results.size(), 8);
		assertEquals(EnumNameNotaionSquare.B3,EnumNameNotaionSquare.get(results.get(0)[0], results.get(0)[1]));
		assertEquals(EnumNameNotaionSquare.D3,EnumNameNotaionSquare.get(results.get(1)[0], results.get(1)[1]));
		assertEquals(EnumNameNotaionSquare.E6,EnumNameNotaionSquare.get(results.get(2)[0], results.get(2)[1]));
		assertEquals(EnumNameNotaionSquare.E4,EnumNameNotaionSquare.get(results.get(3)[0], results.get(3)[1]));
		assertEquals(EnumNameNotaionSquare.D7,EnumNameNotaionSquare.get(results.get(4)[0], results.get(4)[1]));
		assertEquals(EnumNameNotaionSquare.B7,EnumNameNotaionSquare.get(results.get(5)[0], results.get(5)[1]));
		assertEquals(EnumNameNotaionSquare.A6,EnumNameNotaionSquare.get(results.get(6)[0], results.get(6)[1]));
		assertEquals(EnumNameNotaionSquare.A4,EnumNameNotaionSquare.get(results.get(7)[0], results.get(7)[1]));
	}

	@Test
	void test_2() {
		EnumNameNotaionSquare square = EnumNameNotaionSquare.A8;
		List<int[]> results = service.addMoviments(square);
		
		for(int i=0; i < results.size(); i++) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results.get(i)[0], results.get(i)[1]);
			System.out.println(enumNotation.name());
		}
		assertEquals(results.size(), 2);
		assertEquals(EnumNameNotaionSquare.B6,EnumNameNotaionSquare.get(results.get(0)[0], results.get(0)[1]));
		assertEquals(EnumNameNotaionSquare.C7,EnumNameNotaionSquare.get(results.get(1)[0], results.get(1)[1]));
	}

	@Autowired
	public void setService(KnightMovimentService service) {
		this.service = service;
	}
	@Autowired
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
	}
	@Autowired
	public void setChess(ChessBoard chess) {
		this.chess = chess;
	}
	
	
}
