package com.game.chess.services.impls.piece;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("whitePawnTeamManager")
public class WhitePawnTeamManager implements IPawnTeamManager {

	@Override
	public boolean canMoveTwoSquares(int index_x) {
		return index_x==6;
	}

}
