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
import com.game.chess.configs.CustomTestConfig;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.services.pieces.IMovimentOptions;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(CustomTestConfig.class)
class RookMovimentServiceTest {

	@Autowired
	RookMovimentService rookMovimentService;
	
	@Autowired
//	@MockBean
	IMovimentOptions iMovimentOptions;
	
	@Autowired
	ChessBoard chess;
	
    @BeforeEach
    void setUp() {
    	chess.createNewGame();
    	iMovimentOptions.setChessBoard(chess);
//        doNothing().when(iMovimentOptions).addCaptureMove(anyInt(), anyInt());
//        doNothing().when(iMovimentOptions).addMove(anyInt(), anyInt());
    }
	
	@Test
	void test() {
		
		EnumNameNotaionSquare square = EnumNameNotaionSquare.C5;
		int[] results = rookMovimentService.searchMoviments("INIT",square.getIndex_x() , square.getIndex_y());
		
		for(int i=0; i < results.length; i+=2) {
			EnumNameNotaionSquare enumNotation = EnumNameNotaionSquare.get(results[i], results[i+1]);
			System.out.println(enumNotation.name() + " " + results[i] + ", "+ results[i+1]);
		}
		assertEquals(results.length, 8);
		assertEquals(EnumNameNotaionSquare.C7,EnumNameNotaionSquare.get(results[0], results[1]));
		assertEquals(EnumNameNotaionSquare.C2,EnumNameNotaionSquare.get(results[2], results[3]));
		assertEquals(EnumNameNotaionSquare.H5,EnumNameNotaionSquare.get(results[4], results[5]));
		assertEquals(EnumNameNotaionSquare.A5,EnumNameNotaionSquare.get(results[6], results[7]));
		
	}

}
