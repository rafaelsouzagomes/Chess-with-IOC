package com.game.chess.services.impls.piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.game.chess.components.IBoard;
import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.components.piece.Piece;
import com.game.chess.dtos.MovimentOptionsAvailable;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.NamePieces;
import com.game.chess.services.pieces.IMovimentPiece;

@Service
@Qualifier(NamePieces.PAWN)
public class PawnMovimentService implements IMovimentPiece {
	
	private IBoard chessBoard;
	
	private IPawnTeamManager pawnTeamManager ;
	
	private PawnTeamManagerFactory pawnTeamManagerFactory;
	
	
	@Autowired
	public void setPawnTeamManagerFactory(PawnTeamManagerFactory pawnTeamManagerFactory) {
		this.pawnTeamManagerFactory = pawnTeamManagerFactory;
	}
	
	@Autowired
	public void setChessBoard(IBoard chessBoard) {
		this.chessBoard = chessBoard;
	}
	
	
//	@Autowired
//	@Qualifier("testChessBoard")
//	public void setChessBoard(IBoard chessBoard) {
//		this.chessBoard = chessBoard;
//	}

	@Override
	public MovimentOptionsAvailable findMovimentsAvailable(MovimentRequestDTO mov) {
		
		List<SquareBoard> moveAvailable = new ArrayList<>();
		EnumTeam team = EnumTeam.get(mov.getTeam());
		IPawnTeamManager pawnTeamManager = pawnTeamManagerFactory.getPawnTeamManager(team);

		SquareBoard[][] chessSquares = chessBoard.getBoard();

		EnumNameNotaionSquare currentPosition = EnumNameNotaionSquare.get(mov.getCurrentPosition());
		int index_x = currentPosition.getIndex_x();
		int index_y = currentPosition.getIndex_y();
		
		boolean canMoveTwoSquares = pawnTeamManager.canMoveTwoSquares(index_x);
		
		
		// check squares available to move
		if(team.isBlack()) {
			
			int index_x_to_move = index_x+1;
			int index_y_to_Move =index_y;
			addMove(chessSquares, moveAvailable, index_x_to_move, index_y_to_Move, team, false);
			
			if(canMoveTwoSquares) {
				 index_x_to_move = index_x+2;
				 index_y_to_Move =index_y;
				 addMove(chessSquares, moveAvailable, index_x_to_move, index_y_to_Move, team, false);
			}
			
			//capture moviments
			index_x_to_move = index_x+1;
			index_y_to_Move =index_y-1;
			addMove(chessSquares, moveAvailable, index_x_to_move, index_y_to_Move, team, true);
			
			index_x_to_move = index_x+1;
			index_y_to_Move =index_y+1;
			addMove(chessSquares, moveAvailable, index_x_to_move, index_y_to_Move, team, true);
		}
		
		if(team.isWhite()) {
			int index_x_to_move = index_x-1;
			int index_y_to_Move =index_y;
			addMove(chessSquares, moveAvailable, index_x_to_move, index_y_to_Move, team, false);
			
			if(canMoveTwoSquares) {
				 index_x_to_move = index_x-2;
				 index_y_to_Move =index_y;
				 addMove(chessSquares, moveAvailable, index_x_to_move, index_y_to_Move, team, false);
			}
			index_x_to_move = index_x-1;
			index_y_to_Move =index_y-1;
			addMove(chessSquares, moveAvailable, index_x_to_move, index_y_to_Move, team, true);
			
			index_x_to_move = index_x-1;
			index_y_to_Move =index_y+1;
			addMove(chessSquares, moveAvailable, index_x_to_move, index_y_to_Move, team, true);
		}
		
		MovimentOptionsAvailable ma = new MovimentOptionsAvailable();
		ma.setChessSquaresAvailable(moveAvailable);
		
		return ma;
	}

	private void addMove(SquareBoard[][] chessSquares, 
						 List<SquareBoard> moveAvailable, 
						 int index_x_to_move,
						 int index_y_to_Move,
						 EnumTeam team,
						 boolean isCaptureMoviment) {
		
		EnumNameNotaionSquare notationSquareToMove = EnumNameNotaionSquare.get(index_x_to_move, index_y_to_Move);
		if(Objects.nonNull(notationSquareToMove)) {
			 SquareBoard squareToMove = chessSquares[index_x_to_move][index_y_to_Move];
			 if(squareToMove.isEmpty() && !isCaptureMoviment) 
				 moveAvailable.add(squareToMove);
			 if(!squareToMove.isEmpty() && isCaptureMoviment) {
				 Piece piece = squareToMove.getPiece();
				 if(piece.getTeam()!=team) 
					 moveAvailable.add(squareToMove);
			 }
		}
	}
}
