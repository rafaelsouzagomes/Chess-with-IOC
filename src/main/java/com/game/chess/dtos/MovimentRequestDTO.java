package com.game.chess.dtos;

import org.springframework.lang.NonNull;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.piece.Piece;
import com.game.chess.enums.EnumNameNotaionSquare;

public class MovimentRequestDTO {

	@NonNull
	private Long idBoard;
	
	@NonNull
	private String pieceToMove;
	
	@NonNull
	private String team;
	
	@NonNull
	private String currentPosition;

	public Long getIdBoard() {
		return idBoard;
	}

	public void setIdBoard(Long idBoard) {
		this.idBoard = idBoard;
	}

	public String getPieceToMove() {
		return pieceToMove;
	}

	public void setPieceToMove(String pieceToMove) {
		this.pieceToMove = pieceToMove;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	


	
}
