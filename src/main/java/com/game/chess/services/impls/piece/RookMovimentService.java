package com.game.chess.services.impls.piece;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.NamePieces;
import com.game.chess.services.pieces.IMovimentPiece;

@Service
@Qualifier(NamePieces.ROOK)
public class RookMovimentService  implements IMovimentPiece{

	@Override
	public MovimentOptionsAvailableDTO findMovimentsAvailable(MovimentRequestDTO mov) {
		// TODO Auto-generated method stub
		return null;
	}

}
