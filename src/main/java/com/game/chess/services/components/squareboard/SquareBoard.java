package com.game.chess.services.components.squareboard;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.services.components.piece.Piece;

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
	
	@JsonIgnore
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
