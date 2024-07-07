package com.game.chess.services.impls.piece;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.game.chess.models.enums.EnumTeam;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Qualifier("whiteTeamManager")
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WhiteTeamManager implements ITeamManager{

	@Override
	public EnumTeam getTeam() {
		return EnumTeam.WHITE;
	}

}
