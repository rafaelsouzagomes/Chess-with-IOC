package com.game.chess.components.chessSquare;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.game.chess.components.piece.Piece;
import com.game.chess.enums.EnumNameNotaionSquare;

@Component
public class ChessSquare {

	private Piece piece;

	private EnumNameNotaionSquare nameNotationSquare;
	
	protected void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	protected void setNameNotationSquare(EnumNameNotaionSquare nameNotationSquare) {
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

}
