package com.game.chess.components.piece;

import org.springframework.stereotype.Service;

import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

@Service
public class PieceFactory {

	public Piece build(EnumTypePiece typePiece, EnumTeam team) {
		Piece p = new Piece();
		p.setTeam(team);
		p.setType(typePiece);
		return p;
	}

}
