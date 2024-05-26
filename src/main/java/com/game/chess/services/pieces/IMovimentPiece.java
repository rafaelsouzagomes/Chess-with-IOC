package com.game.chess.services.pieces;

import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumTeam;

public interface IMovimentPiece {

	MovimentOptionsAvailableDTO findMovimentsAvailable(MovimentRequestDTO mov);

	
}
