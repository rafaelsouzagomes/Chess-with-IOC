package com.game.chess.components;

import org.springframework.stereotype.Component;

@Component
public class ChessBoard {

	
	public ChessSquare[][] getPatternInitGame() {
		ChessSquare[][] squares = new ChessSquare[1][1];
		squares[0][0] = new ChessSquare("Torre");
		
		return squares;
	}
}
