package com.game.chess.services.impls.piece;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.game.chess.models.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.services.components.IBoard;
import com.game.chess.services.components.piece.Piece;
import com.game.chess.services.components.squareboard.SquareBoard;
import com.game.chess.services.pieces.ICheckMateChecker;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MovimentOptions implements IMovimentOptions {
	
	private ITeamManager teamManager;
	private ICheckMateChecker checkMateChecker;
	
	private List<SquareBoard> movesAvailable;
	private Boolean checkCheckMate=true;
	private SquareBoard[][] squareBoard;
	private EnumNameNotaionSquare currentPosition;
	private int index_x = -1;
	private int index_y = -1;
		
	@Override
	public MovimentOptionsAvailableDTO getMovimentsOptions() {
		MovimentOptionsAvailableDTO dto = new MovimentOptionsAvailableDTO();
		Set<SquareBoard> diferents = new HashSet<>();
		
		checkMateChecker.setTeamManager(teamManager);
		
		for(SquareBoard mov : movesAvailable) {
			EnumNameNotaionSquare nameNotationSquare = mov.getNameNotationSquare();
			if(nameNotationSquare.equals(currentPosition))
				continue;
		
			if(isAvailableMoviment())
				diferents.add(mov);
		}
		ArrayList<SquareBoard> chessSquaresAvailable = new ArrayList<>(diferents);
		chessSquaresAvailable.sort(Comparator.comparing(sb -> sb.getNameNotationSquare().name()));
		dto.setChessSquaresAvailable(chessSquaresAvailable);
		return dto;
	}
	
	@Override
	public MovimentOptionsAvailableDTO getMovimentsOptionsNoCheck() {
		MovimentOptionsAvailableDTO dto = new MovimentOptionsAvailableDTO();
		Set<SquareBoard> diferents = new HashSet<>();
		
		for(SquareBoard mov : movesAvailable) {
			EnumNameNotaionSquare nameNotationSquare = mov.getNameNotationSquare();
			if(nameNotationSquare.equals(currentPosition))
				continue;
			diferents.add(mov);
		}
		
		ArrayList<SquareBoard> chessSquaresAvailable = new ArrayList<>(diferents);
		dto.setChessSquaresAvailable(chessSquaresAvailable);
		return dto;
	}
	
	@Override
	public void addAnyMoveType(int index_x_to_move, int index_y_to_Move) {
		addMove(index_x_to_move, index_y_to_Move);
		addCaptureMove(index_x_to_move, index_y_to_Move);
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
	
	private void addMove() {
		if (isExists() && isEmpty() ) 
			movesAvailable.add(squareBoard[index_x][index_y]);
	}
	
	private void addCaptureMove() {
		if (isExists() && !isEmpty()) {
			SquareBoard squareToMove = squareBoard[index_x][index_y];
			Piece piece = squareToMove.getPiece();
			if ( piece!=null && piece.getTeam() != teamManager.getTeam())
				movesAvailable.add(squareToMove);
		}
	}
	
	@Override
	public boolean isAvailableMoviment() {
		if(!checkCheckMate) 
			return true;
		if(!isExists()) 
			return false;
		
		List<SquareBoard> movesPrevious = new ArrayList<>(movesAvailable);
		SquareBoard[][] copySquareList = SquareBoard.copySquareList(squareBoard);
		int index_x_copy = Integer.valueOf(index_x);
		int index_y_copy = Integer.valueOf(index_y);
		EnumNameNotaionSquare currentPosition_copy =  EnumNameNotaionSquare.get(currentPosition.getIndex_x(), currentPosition.getIndex_y());
		
		SquareBoard square = copySquareList[currentPosition.getIndex_x()][currentPosition.getIndex_y()];
		Piece removedPiece = square.removePiece();
				
		SquareBoard newSquare = copySquareList[index_x][index_y];
		newSquare.setPiece(removedPiece);
		
		boolean isAvailable = checkMateChecker.isAvailableForTeamToCheck(copySquareList);
		
		index_x =  index_x_copy;
		index_y = index_y_copy;
		checkCheckMate = true;
		currentPosition = currentPosition_copy;
		movesAvailable = new ArrayList<>(movesPrevious);
		return isAvailable;
	}
	
	@Override
	public boolean isEmpty(int x, int y) {
		SquareBoard squareToMove = squareBoard[x][y];
		return squareToMove.isEmpty();
	}

	private boolean isExists() {
		return isExists(index_x,index_y );
	}
	
	private boolean isEmpty() {
		return isEmpty(index_x, index_y );
	}
	@Override
	public void clear() {
		movesAvailable = new ArrayList<>();
		checkCheckMate= true;
	}
	@PostConstruct
	public void iniMoviments() {
		movesAvailable = new ArrayList<>();
	}
	@Override
	public void setCurrentPosition(EnumNameNotaionSquare currentPosition) {
		this.currentPosition = currentPosition;
	}
	@Override
	public boolean isExists(int x, int y) {
		EnumNameNotaionSquare notationSquareToMove = EnumNameNotaionSquare.get(x,y);
		return Objects.nonNull(notationSquareToMove);
	}
	@Override
	@Autowired
	public void setChessBoard(IBoard chessBoard) {
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
	@Override
	public void dontCheckCheckMate() {
		checkCheckMate = false;
	}
	@Override
	public void setSquareBoard(SquareBoard[][] squareBoard) {
		this.squareBoard = squareBoard;
	}
}
