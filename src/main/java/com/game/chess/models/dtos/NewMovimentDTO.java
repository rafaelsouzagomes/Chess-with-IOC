package com.game.chess.models.dtos;

import org.springframework.lang.NonNull;

public class NewMovimentDTO {

	@NonNull
	private String enumNameNotaionSquare_origin;
	
	@NonNull
	private String enumNameNotaionSquare_destination;
	
	@NonNull
	private Long idGame;
	
	@NonNull
	private Long idPlayer;

	public String getEnumNameNotaionSquare_origin() {
		return enumNameNotaionSquare_origin;
	}

	public void setEnumNameNotaionSquare_origin(String enumNameNotaionSquare_origin) {
		this.enumNameNotaionSquare_origin = enumNameNotaionSquare_origin;
	}

	public String getEnumNameNotaionSquare_destination() {
		return enumNameNotaionSquare_destination;
	}

	public void setEnumNameNotaionSquare_destination(String enumNameNotaionSquare_destination) {
		this.enumNameNotaionSquare_destination = enumNameNotaionSquare_destination;
	}

	public Long getIdGame() {
		return idGame;
	}

	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}

	public Long getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}
	


}
