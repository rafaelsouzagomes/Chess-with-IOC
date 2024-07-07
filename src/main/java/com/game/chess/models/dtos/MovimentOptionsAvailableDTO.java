package com.game.chess.models.dtos;

import java.util.List;

import com.game.chess.services.components.squareboard.SquareBoard;

public class MovimentOptionsAvailableDTO {

	private List<SquareBoard> chessSquaresAvailable;
	
	public List<SquareBoard> getChessSquaresAvailable() {
		return chessSquaresAvailable;
	}

	public void setChessSquaresAvailable(List<SquareBoard> chessSquaresAvailable) {
		this.chessSquaresAvailable = chessSquaresAvailable;
	}
	
}
