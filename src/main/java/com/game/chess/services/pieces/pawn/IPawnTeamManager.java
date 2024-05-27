package com.game.chess.services.pieces.pawn;

public interface IPawnTeamManager extends ITeamManager{

	boolean canMoveTwoSquares(int index_x);

	int getCaptureMovimentRight(int index_y);

	int getCaptureMovimentLeft(int index_y);

	int getCaptureMovimentAhead(int index_x);

	int getDoubleMovimentAhead(int index_x);

	int getSimpleMovimentAhead(int index_x);

}
