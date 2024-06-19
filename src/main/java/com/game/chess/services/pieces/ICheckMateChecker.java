package com.game.chess.services.pieces;

import com.game.chess.components.chessSquare.SquareBoard;

public interface ICheckMateChecker {

	boolean isAvailable(SquareBoard[][] squareBoard);

}
