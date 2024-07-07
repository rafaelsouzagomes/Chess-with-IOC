package com.game.chess.services.pieces.pawn;

import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.enums.EnumTypePiece;

public interface ITeamManagerFactory {

	ITeamManager getTeamManager(EnumTypePiece piece,EnumTeam team);

}
