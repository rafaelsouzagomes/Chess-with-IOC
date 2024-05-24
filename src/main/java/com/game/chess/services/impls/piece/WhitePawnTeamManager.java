package com.game.chess.services.impls.piece;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.game.chess.enums.EnumTeam;

@Service
@Qualifier("whitePawnTeamManager")
public class WhitePawnTeamManager implements IPawnTeamManager {

	@Override
	public boolean canMoveTwoSquares(int index_x) {
		return index_x==6;
	}


	@Override
	public EnumTeam getTeam() {
		return EnumTeam.WHITE;
	}

	@Override
	public int getCaptureMovimentInIndex_Y_ToRight(int index_y) {
		return index_y+1;
	}


	@Override
	public int getCaptureMovimentInIndex_y_ToLeft(int index_y) {
		return index_y-1;
	}


	@Override
	public int getCaptureMovimentInIndex_X(int index_x) {
		return index_x-1;
	}


	@Override
	public int getDoubleMovimentoInIndex_X(int index_x) {
		return index_x-2;
	}


	@Override
	public int getSimpleMovimentInIndex_X(int index_x) {
		return index_x-1;
	}

}
