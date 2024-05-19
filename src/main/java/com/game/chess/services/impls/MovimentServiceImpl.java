package com.game.chess.services.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.components.Board8x8Factory;
import com.game.chess.components.ChessBoard;
import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.components.piece.Piece;
import com.game.chess.dtos.MovimentOptionsAvailable;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.services.IMovimentService;

@Service
public class MovimentServiceImpl implements IMovimentService {
	
	ChessBoard chessboard;
	
	@Autowired
	public void setChessboard(ChessBoard chessboard) {
		this.chessboard = chessboard;
	}

	@Override
	public MovimentOptionsAvailable getMovimentOptions(MovimentRequestDTO mov) {
		chessboard.createNewGame();
		SquareBoard[][] chessSquares = chessboard.getBoard();

		Piece pieceToMove = mov.getPieceToMove();
		EnumTeam team = pieceToMove.getTeam();
		
		EnumNameNotaionSquare currentPosition = EnumNameNotaionSquare.get(mov.getCurrentPosition());
		int index_x = currentPosition.getIndex_x();
		int index_y = currentPosition.getIndex_y();
		SquareBoard currentSquare = chessSquares[index_x][index_y];
		
		//check if is a pawn and call specific interface
		boolean canMoveTwoSquares = false;
		
		if(team.isBlack()){
			if(index_x==1) {
				canMoveTwoSquares = true;
			}
		}
		if(team.isWhite()) {
			if(index_x==6) {
				canMoveTwoSquares = true;
			}
		}
		
		// check squares available to move
		if(team.isBlack()) {
			List<SquareBoard> moveAvailable = new ArrayList<>();
			int newLineToMove = index_x+1;
			if(newLineToMove<Board8x8Factory.LINES) {
				 SquareBoard squareToMove = chessSquares[newLineToMove][index_y];
				 if(squareToMove.isEmpty()) {
					 moveAvailable.add(squareToMove);
				 }
			}
		if(canMoveTwoSquares) {
			 newLineToMove = index_x+2;
			if(newLineToMove<Board8x8Factory.LINES) {
				 SquareBoard squareToMove = chessSquares[newLineToMove][index_y];
				 if(squareToMove.isEmpty()) {
					 moveAvailable.add(squareToMove);
				 }
			}
		}
		
		
		}
		// move to capture
		SquareBoard oneMove = chessSquares[index_x][index_y];
		
		
		// se for o peao. calcular opções possiveis para movimentação
		return null;
	}

}
