package com.game.chess.services.components.piece;

import org.springframework.stereotype.Service;

import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.enums.EnumTypePiece;

@Service
public class PieceBuilder {

	public Piece build(EnumTypePiece typePiece, EnumTeam team) {
		Piece p = new Piece();
		p.setTeam(team);
		p.setType(typePiece);
		return p;
	}
}
