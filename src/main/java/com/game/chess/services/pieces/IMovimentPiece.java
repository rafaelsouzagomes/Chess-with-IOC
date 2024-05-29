package com.game.chess.services.pieces;

import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.services.pieces.pawn.ITeamManager;

public interface IMovimentPiece {

	void addMovimentsAvailable(ITeamManager teamManager, EnumNameNotaionSquare currentPosition);

	
}
