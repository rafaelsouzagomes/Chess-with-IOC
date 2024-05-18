package com.game.chess.dtos;

import java.util.List;

import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.components.piece.Piece;

public class MovimentOptionsAvailable {

	private List<SquareBoard> chessSquaresAvailable;
	
	private Piece piece;

	public List<SquareBoard> getChessSquaresAvailable() {
		return chessSquaresAvailable;
	}

	public void setChessSquaresAvailable(List<SquareBoard> chessSquaresAvailable) {
		this.chessSquaresAvailable = chessSquaresAvailable;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}
