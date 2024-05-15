package com.game.chess.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ChessSquare {

	@Autowired
	public ChessSquare(String string) {
		this.piece = string;
	}

	private String piece = " "; 
	
	public String getPiece() {
		return piece;
	}
}
