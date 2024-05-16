package com.game.chess.components;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.game.chess.components.chessSquare.ChessSquareFactory;
import com.game.chess.components.piece.PieceFactory;

class ChessBoardTest {

	@Autowired
	ChessBoard cb;
	
	@Test
	void test() {
//		ChessBoard x = new ChessBoard();
//		
//		PieceFactory p = new PieceFactory();
//		ChessSquareFactory chessSquareFactory= new ChessSquareFactory();
//		chessSquareFactory.setPieceFactory(p);
//		
//		x.initCheBoardDefault();
//		x.setChessSquareFactory(chessSquareFactory);
		cb.showBoard();
	}

}
