package com.game.chess.components;

import com.game.chess.components.chessSquare.SquareBoard;

public interface Board {

	SquareBoard[][] getBoard();

	void createNewGame();

}
