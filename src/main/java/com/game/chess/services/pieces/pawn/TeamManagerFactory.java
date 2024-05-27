package com.game.chess.services.pieces.pawn;

import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

public interface TeamManagerFactory {

	ITeamManager getTeamManager(EnumTypePiece piece,EnumTeam team);

}
