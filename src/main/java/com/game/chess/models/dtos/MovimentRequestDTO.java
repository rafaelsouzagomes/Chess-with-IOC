package com.game.chess.models.dtos;

import org.springframework.lang.NonNull;

public class MovimentRequestDTO {
	
	@NonNull
	private String pieceToMove;
	
	@NonNull
	private String team;
	
	@NonNull
	private String currentPosition;
	
	@NonNull
	private Long idGame;
	
	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}
	
	public Long getIdGame() {
		return idGame;
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
