package com.game.chess.services.impls.piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.game.chess.components.IBoard;
import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.components.chessSquare.SquareBoardFactory;
import com.game.chess.components.piece.Piece;
import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.services.pieces.ICheckMateChecker;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MovimentOptions implements IMovimentOptions {
	
	private IBoard chessBoard;
	private ITeamManager teamManager;
	private SquareBoardFactory factory;
	
	private List<SquareBoard> movesAvailable;
	private ICheckMateChecker checkMateChecker;
	
	private SquareBoard[][] squareBoard;
	private EnumNameNotaionSquare currentPosition;
	private int index_x = -1;
	private int index_y = -1;
	
	public void setCurrentPosition(EnumNameNotaionSquare currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	@PostConstruct
	public void iniMoviments() {
		movesAvailable = new ArrayList<>();
	}
	
	@Override
	public MovimentOptionsAvailableDTO getMovimentsOptions() {
		MovimentOptionsAvailableDTO dto = new MovimentOptionsAvailableDTO();
		dto.setChessSquaresAvailable(movesAvailable);
		return dto;
	}

	@Override
	public void addMove( int index_x_to_move, int index_y_to_Move) {
		this.index_x = index_x_to_move;
		this.index_y = index_y_to_Move;
		
		addMove();
	}
	
	@Override
	public void addCaptureMove( int index_x_to_move, int index_y_to_Move) {
		this.index_x = index_x_to_move;
		this.index_y = index_y_to_Move;

		addCaptureMove();
	}
	
	@Override
	public void addAnyMoveType( int index_x_to_move, int index_y_to_Move) {
		addMove(index_x_to_move, index_y_to_Move);
		addCaptureMove(index_x_to_move, index_y_to_Move);
		
	}

	private void addMove() {
		if (isExists() && isEmpty() && isNotCheckMateResult()) 
			movesAvailable.add(squareBoard[index_x][index_y]);
	}
	
	private boolean isNotCheckMateResult() {
		
		List<SquareBoard> movesPrevious = new ArrayList<>(movesAvailable);
		
		SquareBoard[][] squareCopy = SerializationUtils.clone(squareBoard);
		
		SquareBoard square = squareCopy[currentPosition.getIndex_x()][ currentPosition.getIndex_y()];
		Piece removedPiece = square.removePiece();
				
		SquareBoard newSquare = squareCopy[index_x][index_y];
		newSquare.setPiece(removedPiece);
		
		boolean isAvailable = checkMateChecker.isAvailable(squareCopy);
		
		movesAvailable = new ArrayList<>(movesPrevious);
		return isAvailable;
	}

	private void addCaptureMove() {
		if (isExists() && !isEmpty()  && isNotCheckMateResult()) {
			SquareBoard squareToMove = squareBoard[index_x][index_y];
			Piece piece = squareToMove.getPiece();
			if (piece.getTeam() != teamManager.getTeam())
				movesAvailable.add(squareToMove);
		}
	}
	
	private boolean isEmpty() {
		return isEmpty(index_x, index_y );
	}
	
	@Override
	public void clear() {
		movesAvailable = new ArrayList<>();
	}

	@Override
	public boolean isEmpty(int x, int y) {
		SquareBoard squareToMove = squareBoard[x][y];
		return squareToMove.isEmpty();
	}

	private boolean isExists() {
		return isExists(index_x,index_y );
	}

	@Override
	public boolean isExists(int x, int y) {
		EnumNameNotaionSquare notationSquareToMove = EnumNameNotaionSquare.get(x,y);
		return Objects.nonNull(notationSquareToMove);
	}
	
	@Override
	@Autowired
	public void setChessBoard(IBoard chessBoard) {
		this.chessBoard = chessBoard;
		squareBoard = chessBoard.getBoard();
	}
	@Override	
	@Autowired
	public void setTeamManager(@Lazy  ITeamManager teamManager) {
		this.teamManager = teamManager;
	}

	@Autowired
	public void setCheckMateChecker(ICheckMateChecker checkMateChecker) {
		this.checkMateChecker = checkMateChecker;
	}


}
