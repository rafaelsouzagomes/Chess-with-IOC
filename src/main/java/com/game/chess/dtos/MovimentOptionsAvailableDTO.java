package com.game.chess.dtos;

import java.util.List;

import com.game.chess.components.chessSquare.SquareBoard;

public class MovimentOptionsAvailableDTO {

	private List<SquareBoard> chessSquaresAvailable;
	
	public List<SquareBoard> getChessSquaresAvailable() {
		return chessSquaresAvailable;
	}

	public void setChessSquaresAvailable(List<SquareBoard> chessSquaresAvailable) {
		this.chessSquaresAvailable = chessSquaresAvailable;
	}
	
}
