package com.game.chess.components;

import com.game.chess.components.chessSquare.SquareBoard;

public interface IBoard {

	SquareBoard[][] getBoard();

	void createNewGame();

}
