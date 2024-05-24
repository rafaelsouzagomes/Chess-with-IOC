package com.game.chess.services.impls.piece;

import com.game.chess.enums.EnumTeam;

public interface IPawnTeamManager {

	boolean canMoveTwoSquares(int index_x);

	int getCaptureMovimentInIndex_Y_ToRight(int index_y);

	int getCaptureMovimentInIndex_y_ToLeft(int index_y);

	int getCaptureMovimentInIndex_X(int index_x);

	int getDoubleMovimentoInIndex_X(int index_x);

	int getSimpleMovimentInIndex_X(int index_x);
	
	EnumTeam getTeam();

}
