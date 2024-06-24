package com.game.chess.components.chessSquare;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.game.chess.components.piece.Piece;
import com.game.chess.enums.EnumNameNotaionSquare;

public class SquareBoard {

	private Piece piece;

	private EnumNameNotaionSquare nameNotationSquare;
	
	@Override
	public boolean equals(Object obj) {
		SquareBoard squareToCompare = (SquareBoard) obj;
		
		return this.nameNotationSquare == squareToCompare.getNameNotationSquare() &&
				this.piece.equals(squareToCompare.getPiece());
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public void setNameNotationSquare(EnumNameNotaionSquare nameNotationSquare) {
		this.nameNotationSquare = nameNotationSquare;
	}
	
	public boolean isEmpty() {
		return Objects.isNull(piece);
	}
	
	public EnumNameNotaionSquare getNameNotationSquare() {
		return nameNotationSquare;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public Piece removePiece() {
		Piece pieceToRemove = piece;
		piece = null;
		return pieceToRemove;
	}

}
