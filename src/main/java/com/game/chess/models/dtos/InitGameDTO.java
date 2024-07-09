package com.game.chess.models.dtos;

public class InitGameDTO {

	private Long idPlayer_A;
	
	private Long idPlayer_B;
	
	private Long idGame;
	
	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}
	
	public Long getIdGame() {
		return idGame;
	}

	public Long getIdPlayer_A() {
		return idPlayer_A;
	}

	public void setIdPlayer_A(Long idPlayer_A) {
		this.idPlayer_A = idPlayer_A;
	}

	public Long getIdPlayer_B() {
		return idPlayer_B;
	}

	public void setIdPlayer_B(Long idPlayer_B) {
		this.idPlayer_B = idPlayer_B;
	}
	
	
}
