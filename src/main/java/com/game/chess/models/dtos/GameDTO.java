package com.game.chess.models.dtos;

import java.util.List;

import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.models.enums.EnumResultGame;

public class GameDTO {

	private Long idGame;
	
	private EnumResultGame EnumResultGame;
	
	private List<EnumNameNotaionSquare> adversaryPiecesAvailableToMove; 
	
	private Long idPlayer;

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
	
	public void setEnumResultGame(EnumResultGame enumResultGame) {
		EnumResultGame = enumResultGame;
	}
	
	public EnumResultGame getEnumResultGame() {
		return EnumResultGame;
	}
	
	
}
