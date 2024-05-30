package com.game.chess.services.pieces;

import com.game.chess.components.IBoard;
import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.services.pieces.pawn.ITeamManager;

public interface IMovimentOptions {

	void addMove(int index_x_to_move, int index_y_to_Move);

	void addCaptureMove(int index_x_to_move, int index_y_to_Move);

	MovimentOptionsAvailableDTO getMovimentsOptions();

	void setChessBoard(IBoard chessBoard);

	void setTeamManager(ITeamManager teamManager);

	boolean isEmpty(int x, int y);

	boolean isExists(int x, int y);

}
