package com.game.chess.services.pieces;

import com.game.chess.models.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.services.components.IBoard;
import com.game.chess.services.components.squareboard.SquareBoard;
import com.game.chess.services.pieces.pawn.ITeamManager;

public interface IMovimentOptions {

	void addMove(int index_x_to_move, int index_y_to_Move);
	void addCaptureMove(int index_x_to_move, int index_y_to_Move);
	void addAnyMoveType(int index_x_to_move, int index_y_to_Move);
	MovimentOptionsAvailableDTO getMovimentsOptions();

	void setChessBoard(IBoard chessBoard);
	void setTeamManager(ITeamManager teamManager);
	void setSquareBoard(SquareBoard[][] squareBoard);
	void setCurrentPosition(EnumNameNotaionSquare currentPosition);

	boolean isEmpty(int x, int y);
	boolean isExists(int x, int y);
	void clear();
	void dontCheckCheckMate();
	boolean isNotCheckMateResult();



}
