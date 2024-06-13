package com.game.chess.services.impls.piece.knight;

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

	@Autowired
	KnightMovimentService service;
	
	@Autowired
	IMovimentOptions iMovimentOptions;
	
	@Autowired
	ChessBoard chess;
	
	  @BeforeEach
	    void setUp() {
	    	chess.createNewGame();
	    	iMovimentOptions.setChessBoard(chess);
	    	service.setiMovimentOptions(iMovimentOptions);
	    }
	
	@Test
	void test() {
		EnumNameNotaionSquare square = EnumNameNotaionSquare.C5;
		List<int[]> results = service.addMoviments(square);
		
		for(int i=0; i < results.size(); i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results.get(i)[0], results.get(i)[1]);
			System.out.println(enumNotation.name());
		}
//		assertEquals(results.length, 8);
//		assertEquals(EnumNameNotaionSquare.A7,EnumNameNotaionSquare.get(results[0], results[1]));
//		assertEquals(EnumNameNotaionSquare.E7,EnumNameNotaionSquare.get(results[2], results[3]));
//		assertEquals(EnumNameNotaionSquare.A3,EnumNameNotaionSquare.get(results[4], results[5]));
//		assertEquals(EnumNameNotaionSquare.F2,EnumNameNotaionSquare.get(results[6], results[7]));
	}

}
