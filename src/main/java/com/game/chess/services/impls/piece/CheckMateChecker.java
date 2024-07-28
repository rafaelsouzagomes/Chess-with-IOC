package com.game.chess.services.impls.piece;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.game.chess.models.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.services.components.IBoard;
import com.game.chess.services.components.piece.Piece;
import com.game.chess.services.components.squareboard.SquareBoard;
import com.game.chess.services.pieces.ICheckMateChecker;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.IMovimentPieceFactory;
import com.game.chess.services.pieces.pawn.ITeamManager;
import com.game.chess.services.pieces.pawn.ITeamManagerFactory;

@Service
public class CheckMateChecker implements ICheckMateChecker {

	private IMovimentPieceFactory movimentPieceFactory;
	private IMovimentOptions movimentOptions;
	private ITeamManagerFactory teamManagerFactory;
	private Piece pieceToMove;
	private IBoard IBoard;
	private ITeamManager teamToCheck;
	
	@Override
	public boolean isAvailableForTeamToCheck(SquareBoard[][] squareBoard) {
//		IBoard.setChessBoard(squareBoard);
//		IBoard.showBoard();
		
		
		for(int line=0; line <= 7; line++) {
			for(int column=0; column<=7; column++) {
				SquareBoard currentSquare = squareBoard[line][column];
				if(currentSquare.isEmpty())	
					continue;
				
				List<SquareBoard> movimentsAvailables = simulateMoviments(currentSquare);
				for(SquareBoard movOptions: movimentsAvailables )
					if(isImpossivelMoviment(movOptions) )  
						return false;
			}
		}
		
		return true;
	}
	
	public boolean isImpossivelMoviment(SquareBoard movOptions) {
		if(movOptions.getNameNotationSquare().equals(EnumNameNotaionSquare.E1)) {
			System.out.println();
		}
		return Objects.nonNull(movOptions.getPiece()) 
					&& movOptions.getPiece().isKing() 
					&& movOptions.getPiece().getTeam()==teamToCheck.getTeam()
					&& pieceToMove.getTeam() != teamToCheck.getTeam();
	}
	
	public List<SquareBoard> simulateMoviments(SquareBoard currentSquare ){
		MovimentOptionsAvailableDTO movimentsOptions = setUpMoviments(currentSquare);
		List<SquareBoard> chessSquaresAvailable = movimentsOptions.getChessSquaresAvailable();
		return chessSquaresAvailable;
	}

	private MovimentOptionsAvailableDTO setUpMoviments(SquareBoard currentSquare) {
		pieceToMove = currentSquare.getPiece();
		IMovimentPiece movimentPiece = movimentPieceFactory.getMovimentPiece(pieceToMove.getType().getName());
		EnumNameNotaionSquare nameNotationSquare = currentSquare.getNameNotationSquare();
		
		movimentOptions.clear();
		movimentOptions.dontCheckCheckMate();
		movimentOptions.setCurrentPosition(nameNotationSquare);
		
		EnumTeam enumTeamToCheck = teamToCheck.getTeam();
		
		ITeamManager team =  teamManagerFactory.getTeamManager(pieceToMove.getType(), pieceToMove.getTeam());
		movimentOptions.setTeamManager(team);
		
		if(pieceToMove.getType().isQueen()) {
			System.out.println();
		}
		
		movimentPiece.addMovimentsOptionsAvailable(team, nameNotationSquare);
		MovimentOptionsAvailableDTO movimentsOptions = movimentOptions.getMovimentsOptionsNoCheck();
		
		ITeamManager myTeamMan =teamManagerFactory.getTeamManager(enumTeamToCheck);
		setTeamManager(myTeamMan);
		
		return movimentsOptions;
	}
	
	@Autowired
	public void setMovimentOptions(IMovimentOptions movimentOptions) {
		this.movimentOptions = movimentOptions;
	}
	@Autowired
	public void setMovimentPieceFactory(IMovimentPieceFactory movimentPieceFactory) {
		this.movimentPieceFactory = movimentPieceFactory;
	}
	@Autowired
	@Override
	public void setTeamManager(@Lazy ITeamManager teamManager) {
		this.teamToCheck = teamManager;
	}
	@Autowired
	public void setTeamManagerFactory(ITeamManagerFactory teamManagerFactory) {
		this.teamManagerFactory = teamManagerFactory;
	}
	@Autowired
	@Lazy
	public void setIBoard(IBoard iBoard) {
		IBoard = iBoard;
	}
}
