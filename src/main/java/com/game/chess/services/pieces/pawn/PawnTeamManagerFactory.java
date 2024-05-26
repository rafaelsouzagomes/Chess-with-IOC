package com.game.chess.services.pieces.pawn;

import com.game.chess.enums.EnumTeam;

public interface PawnTeamManagerFactory {

	IPawnTeamManager getPawnTeamManager(EnumTeam team);

}
