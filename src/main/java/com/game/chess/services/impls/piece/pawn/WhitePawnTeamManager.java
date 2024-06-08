package com.game.chess.services.impls.piece.pawn;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.game.chess.enums.EnumTeam;
import com.game.chess.services.pieces.pawn.IPawnTeamManager;

@Service
@Qualifier("whitePawnTeamManager")
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
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
	public int getCaptureMovimentRight(int index_y) {
		return index_y+1;
	}


	@Override
	public int getCaptureMovimentLeft(int index_y) {
		return index_y-1;
	}


	@Override
	public int getCaptureMovimentAhead(int index_x) {
		return index_x-1;
	}


	@Override
	public int getDoubleMovimentAhead(int index_x) {
		return index_x-2;
	}


	@Override
	public int getSimpleMovimentAhead(int index_x) {
		return index_x-1;
	}

}
