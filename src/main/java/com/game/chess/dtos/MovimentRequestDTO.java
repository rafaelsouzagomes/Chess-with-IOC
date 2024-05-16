package com.game.chess.dtos;

import org.springframework.lang.NonNull;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.Piece;

public class MovimentRequestDTO {

	@NonNull
	private ChessBoard chessboard;
	
	@NonNull
	private Piece pieceToMove;

	public ChessBoard getChessboard() {
		return chessboard;
	}

	public void setChessboard(ChessBoard chessboard) {
		this.chessboard = chessboard;
	}

	public Piece getPieceToMove() {
		return pieceToMove;
	}

	public void setPieceToMove(Piece pieceToMove) {
		this.pieceToMove = pieceToMove;
	}
	
	
}
