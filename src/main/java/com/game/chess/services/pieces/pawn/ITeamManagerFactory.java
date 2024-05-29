package com.game.chess.services.pieces.pawn;

import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

public interface ITeamManagerFactory {

	ITeamManager getTeamManager(EnumTypePiece piece,EnumTeam team);

}
