package com.game.chess.services.pieces;

import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.services.pieces.pawn.ITeamManager;

public interface IMovimentPiece {

	void addMovimentsOptionsAvailable(ITeamManager teamManager, EnumNameNotaionSquare currentPosition);

	
}
