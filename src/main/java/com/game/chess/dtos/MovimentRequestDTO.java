package com.game.chess.dtos;

import org.springframework.lang.NonNull;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.piece.Piece;
import com.game.chess.enums.EnumNameNotaionSquare;

public class MovimentRequestDTO {

	@NonNull
	private ChessBoard chessboard;
	
	@NonNull
	private Piece pieceToMove;
	
	@NonNull
	private String currentPosition;

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

	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	public String getCurrentPosition() {
		return currentPosition;
	}
	
}
