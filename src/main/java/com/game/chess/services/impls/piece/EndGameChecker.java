package com.game.chess.services.impls.piece;

import com.game.chess.models.dtos.GameDTO;
import com.game.chess.models.dtos.NewMovimentDTO;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.services.components.squareboard.SquareBoard;
import com.game.chess.services.pieces.pawn.ITeamManager;

public class EndGameChecker {

	
	private GameDTO checker(NewMovimentDTO mov, SquareBoard[][] squareBoard, EnumTeam pieceTeam) {
		// check if this current play creates a check wih isAvailableForTeamToCheck
		
		// check if the other player has options to move
		
		// if the other plater has no options to move and he is in check: so he loose
		// if the other player has no options to move but he is not in check, so it's a tie.
	}
}
