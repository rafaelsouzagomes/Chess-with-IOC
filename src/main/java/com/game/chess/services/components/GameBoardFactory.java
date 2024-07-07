package com.game.chess.services.components;

import com.game.chess.services.components.squareboard.SquareBoard;

public interface GameBoardFactory {

	SquareBoard[][] build();

}
