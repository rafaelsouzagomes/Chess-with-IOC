package com.game.chess.services.impls.piece.king;

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
class KingMovimentServiceTest {
	
	KingMovimentService service;
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
		assertEquals(EnumNameNotaionSquare.C4,EnumNameNotaionSquare.get(results.get(0)[0], results.get(0)[1]));
		assertEquals(EnumNameNotaionSquare.D4,EnumNameNotaionSquare.get(results.get(1)[0], results.get(1)[1]));
		assertEquals(EnumNameNotaionSquare.D5,EnumNameNotaionSquare.get(results.get(2)[0], results.get(2)[1]));
		assertEquals(EnumNameNotaionSquare.B6,EnumNameNotaionSquare.get(results.get(3)[0], results.get(3)[1]));
		assertEquals(EnumNameNotaionSquare.C6,EnumNameNotaionSquare.get(results.get(4)[0], results.get(4)[1]));
		assertEquals(EnumNameNotaionSquare.B5,EnumNameNotaionSquare.get(results.get(5)[0], results.get(5)[1]));
		assertEquals(EnumNameNotaionSquare.B4,EnumNameNotaionSquare.get(results.get(6)[0], results.get(6)[1]));
		assertEquals(EnumNameNotaionSquare.D6,EnumNameNotaionSquare.get(results.get(7)[0], results.get(7)[1]));
	}
	
	@Autowired
	public void setService(KingMovimentService service) {
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
