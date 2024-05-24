package com.game.chess.services.impls.piece;

import com.game.chess.enums.EnumTeam;

public interface PawnTeamManagerFactory {

	IPawnTeamManager getPawnTeamManager(EnumTeam team);

}
