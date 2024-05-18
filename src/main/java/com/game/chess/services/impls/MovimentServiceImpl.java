package com.game.chess.services.impls;

import org.springframework.stereotype.Service;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.chessSquare.ChessSquare;
import com.game.chess.components.piece.Piece;
import com.game.chess.dtos.MovimentOptionsAvailable;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.services.IMovimentService;

@Service
public class MovimentServiceImpl implements IMovimentService {

	@Override
	public MovimentOptionsAvailable getMovimentOptions(MovimentRequestDTO mov) {
		ChessBoard chessboard = mov.getChessboard();
		ChessSquare[][] chessSquares = chessboard.get();

		Piece pieceToMove = mov.getPieceToMove();
		EnumTeam team = pieceToMove.getTeam();
		
		EnumNameNotaionSquare currentPosition = EnumNameNotaionSquare.get(mov.getCurrentPosition());
		ChessSquare currentSquare = chessSquares[currentPosition.getIndex_x()][currentPosition.getIndex_y()];
		
		
		
		// se for o peao. calcular opções possiveis para movimentação
		return null;
	}

}
