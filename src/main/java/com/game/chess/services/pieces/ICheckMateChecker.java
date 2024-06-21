package com.game.chess.services.pieces;

import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.services.pieces.pawn.ITeamManager;

public interface ICheckMateChecker {

	boolean isAvailable(SquareBoard[][] squareBoard);

	void setTeamManager(ITeamManager teamManager);

}
