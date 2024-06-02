package com.game.chess.components;

import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

public interface IBoard8x8Factory {

	void addAllSquare_empty();

	void addSquare_empty(EnumNameNotaionSquare enumNameNotation);

	void addSquare(EnumTypePiece typePiece, EnumTeam team, EnumNameNotaionSquare enumNameNotation);

	SquareBoard[][] build();

}
