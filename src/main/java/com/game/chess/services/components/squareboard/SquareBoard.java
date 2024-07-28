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
	
	public static SquareBoard[][] copySquareList(SquareBoard[][] squareBoard) {
		SquareBoard[][] squareCopy = new SquareBoard[8][8] ;
		for(int line=0; line <= 7; line++) {
			for(int column=0; column<=7; column++) {
				SquareBoard copy = squareBoard[line][column].copy();
				squareCopy[line][column] = copy;
			}
		}
		return squareCopy;
	}
	
	public SquareBoard copy() {
		 SquareBoard newSquare  = new SquareBoard();
		 newSquare.setNameNotationSquare(nameNotationSquare);
		 newSquare.setPiece(this.piece != null ? this.piece.copy() : null);
	     return newSquare;
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
