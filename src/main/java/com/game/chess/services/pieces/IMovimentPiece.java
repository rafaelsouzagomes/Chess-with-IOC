package com.game.chess.services.pieces;

import com.game.chess.dtos.MovimentOptionsAvailable;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumTeam;

public interface IMovimentPiece {

	MovimentOptionsAvailable findMovimentsAvailable(MovimentRequestDTO mov);

	
}
