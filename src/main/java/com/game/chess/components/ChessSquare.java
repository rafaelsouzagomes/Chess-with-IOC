package com.game.chess.components;

import com.game.chess.enums.EnumNameNotaionSquare;

public class ChessSquare {

	private Piece piece;
	
	private EnumNameNotaionSquare nameNotationSquare;
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public void setNameNotationSquare(EnumNameNotaionSquare nameNotationSquare) {
		this.nameNotationSquare = nameNotationSquare;
	}

}
