package com.game.chess.services.pieces;

import com.game.chess.dtos.MovimentOptionsAvailableDTO;

public interface IMovimentOptions {

	void addMove(int index_x_to_move, int index_y_to_Move);

	void addCaptureMove(int index_x_to_move, int index_y_to_Move);

	MovimentOptionsAvailableDTO getMovimentsOptions();

}
