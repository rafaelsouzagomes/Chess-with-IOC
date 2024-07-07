package com.game.chess.services.components;

import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.enums.EnumTypePiece;
import com.game.chess.services.components.squareboard.SquareBoard;

public interface IBoard8x8Factory {

	void addAllSquare_empty();

	void addSquare_empty(EnumNameNotaionSquare enumNameNotation);

	void addSquare(EnumTypePiece typePiece, EnumTeam team, EnumNameNotaionSquare enumNameNotation);

	SquareBoard[][] build();

}
