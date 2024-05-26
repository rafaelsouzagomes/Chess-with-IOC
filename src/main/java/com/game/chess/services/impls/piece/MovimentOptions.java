package com.game.chess.services.impls.piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.game.chess.components.IBoard;
import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.components.piece.Piece;
import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class MovimentOptions implements IMovimentOptions {

	private List<SquareBoard> movesAvailable;
	
	private IBoard chessBoard;
	
	private ITeamManager teamManager;
	
	@Autowired
	public void setChessBoard(IBoard chessBoard) {
		this.chessBoard = chessBoard;
	}
	
	@Autowired
	public void setTeamManager(ITeamManager teamManager) {
		this.teamManager = teamManager;
	}
	
	@PostConstruct
	public void iniMoviments() {
		movesAvailable = new ArrayList<>();
	}

	@Override
	public void addMove( int index_x_to_move, int index_y_to_Move) {
		
		SquareBoard[][] chessSquares = chessBoard.getBoard();
		EnumNameNotaionSquare notationSquareToMove = EnumNameNotaionSquare.get(index_x_to_move, index_y_to_Move);
		
		if (Objects.nonNull(notationSquareToMove)) {
			SquareBoard squareToMove = chessSquares[index_x_to_move][index_y_to_Move];
			if (squareToMove.isEmpty())
				movesAvailable.add(squareToMove);
		}
	}

	@Override
	public void addCaptureMove( int index_x_to_move, int index_y_to_Move) {

		SquareBoard[][] chessSquares = chessBoard.getBoard();
		EnumNameNotaionSquare notationSquareToMove = EnumNameNotaionSquare.get(index_x_to_move, index_y_to_Move);
		
		if (Objects.nonNull(notationSquareToMove)) {
			SquareBoard squareToMove = chessSquares[index_x_to_move][index_y_to_Move];
			if (!squareToMove.isEmpty()) {
				Piece piece = squareToMove.getPiece();
				if (piece.getTeam() != teamManager.getTeam())
					movesAvailable.add(squareToMove);
			}
		}
	}
	@Override
	public MovimentOptionsAvailableDTO getMovimentsOptions() {
		MovimentOptionsAvailableDTO dto = new MovimentOptionsAvailableDTO();
		dto.setChessSquaresAvailable(movesAvailable);
		return dto;
	}
}
