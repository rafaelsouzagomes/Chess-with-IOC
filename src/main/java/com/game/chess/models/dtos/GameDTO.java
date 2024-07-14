package com.game.chess.models.dtos;

import java.util.List;
import java.util.Map;

import com.game.chess.models.enums.EnumResultGame;
import com.game.chess.services.components.squareboard.SquareBoard;

public class GameDTO {

	private Long idGame;
	
	private EnumResultGame EnumResultGame;
	
	private Map<String, List<SquareBoard>> adversaryPiecesWithMovimentsAvailable;
	
	private Long idPlayer;
	
	private String teamPlayer;

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

	public Map<String, List<SquareBoard>> getAdversaryPiecesWithMovimentsAvailable() {
		return adversaryPiecesWithMovimentsAvailable;
	}

	public void setAdversaryPiecesWithMovimentsAvailable(
			Map<String, List<SquareBoard>> adversaryPiecesWithMovimentsAvailable) {
		this.adversaryPiecesWithMovimentsAvailable = adversaryPiecesWithMovimentsAvailable;
	}

	public String getTeamPlayer() {
		return teamPlayer;
	}

	public void setTeamPlayer(String teamPlayer) {
		this.teamPlayer = teamPlayer;
	}
}
