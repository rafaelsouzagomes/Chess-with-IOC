package com.game.chess.dtos;

import java.util.List;

import com.game.chess.components.chessSquare.ChessSquare;
import com.game.chess.components.piece.Piece;

public class MovimentOptions {

	private List<ChessSquare> chessSquaresAvailable;
	
	private Piece piece;

	public List<ChessSquare> getChessSquaresAvailable() {
		return chessSquaresAvailable;
	}

	public void setChessSquaresAvailable(List<ChessSquare> chessSquaresAvailable) {
		this.chessSquaresAvailable = chessSquaresAvailable;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}
