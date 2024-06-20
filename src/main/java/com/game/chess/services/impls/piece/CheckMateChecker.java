package com.game.chess.services.impls.piece;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.components.piece.Piece;
import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.services.pieces.ICheckMateChecker;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.IMovimentPieceFactory;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
public class CheckMateChecker implements ICheckMateChecker {

	private ITeamManager teamManager;
	private IMovimentPieceFactory movimentPieceFactory;
	private IMovimentOptions movimentOptions;
	
	@Override
	public boolean isAvailable(SquareBoard[][] squareBoard) {
		for(int line=0; line <= 7; line++) {
			for(int column=0; column<=7; column++) {
				SquareBoard currentSquare = squareBoard[line][column];
				if(currentSquare.isEmpty())	
					continue;
				
				List<SquareBoard> movimentsAvailables = simulateMoviments(currentSquare);
				for( SquareBoard movOptions: movimentsAvailables )
					if( isImpossivelMoviment(movOptions) )  
						return false;
			}
		}
		
		return true;
	}
	
	public boolean isImpossivelMoviment(SquareBoard movOptions) {
		return Objects.nonNull(movOptions.getPiece()) && movOptions.getPiece().isKing() &&  movOptions.getPiece().getTeam()==teamManager.getTeam();
	}
	
	public List<SquareBoard> simulateMoviments(SquareBoard currentSquare ){
		MovimentOptionsAvailableDTO movimentsOptions = setUpMoviments(currentSquare);
		List<SquareBoard> chessSquaresAvailable = movimentsOptions.getChessSquaresAvailable();
		return chessSquaresAvailable;
	}

	private MovimentOptionsAvailableDTO setUpMoviments(SquareBoard currentSquare) {
		Piece piece = currentSquare.getPiece();
		IMovimentPiece movimentPiece = movimentPieceFactory.getMovimentPiece(piece.getType().getName());
		EnumNameNotaionSquare nameNotationSquare = currentSquare.getNameNotationSquare();
		
		movimentOptions.clear();
		movimentPiece.addMovimentsOptionsAvailable(teamManager, nameNotationSquare);
		MovimentOptionsAvailableDTO movimentsOptions = movimentOptions.getMovimentsOptions();
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
	@Lazy
	public void setTeamManager(ITeamManager teamManager) {
		this.teamManager = teamManager;
	}
}
