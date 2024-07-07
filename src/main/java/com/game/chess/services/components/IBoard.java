package com.game.chess.services.components;

import com.game.chess.services.components.squareboard.SquareBoard;

public interface IBoard {

	SquareBoard[][] getBoard();

	void createNewGame();

	void addChessSquareBoard(SquareBoard[][] especificChess);

	void showBoard();

	void setChessBoard(SquareBoard[][] chessBoard);

}
