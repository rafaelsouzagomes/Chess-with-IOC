package com.game.chess.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.IBoard;
import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;
import com.game.chess.services.IMovimentService;
import com.game.chess.services.impls.piece.pawn.MovimentPieceFactory;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.pawn.ITeamManager;
import com.game.chess.services.pieces.pawn.ITeamManagerFactory;

@Service
public class MovimentServiceImpl implements IMovimentService {
	
	private IBoard chessboard;
	
	private MovimentPieceFactory movimentPieceFactory;
	
	private IMovimentOptions iMovimentOptions;
	
	private ITeamManagerFactory teamManagerFactory;
	
	@Override
	public MovimentOptionsAvailableDTO getMovimentOptions(MovimentRequestDTO mov) {
		chessboard.createNewGame();
		IMovimentPiece movimentPiece = movimentPieceFactory.getMovimentPiece(mov.getPieceToMove());
		ITeamManager teamManager =  teamManagerFactory.getTeamManager(getEnumTypePiece(mov), getEnumTeam(mov));
		EnumNameNotaionSquare currentPosition = EnumNameNotaionSquare.get(mov.getCurrentPosition());
		movimentPiece.addMovimentsAvailable(teamManager, currentPosition);
		 
		return iMovimentOptions.getMovimentsOptions();
	}

	private EnumTypePiece getEnumTypePiece(MovimentRequestDTO mov) {
		return EnumTypePiece.get(mov.getPieceToMove());
	}

	private EnumTeam getEnumTeam(MovimentRequestDTO mov) {
		return EnumTeam.get(mov.getTeam());
	}
	
	@Autowired
	public void setChessboard(IBoard chessboard) {
		this.chessboard = chessboard;
	}
	@Autowired
	public void setTeamManagerFactory(ITeamManagerFactory teamManagerFactory) {
		this.teamManagerFactory = teamManagerFactory;
	}
	@Autowired
	@Lazy
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
	}
	@Autowired
	public void setMovimentPieceFactory(MovimentPieceFactory movimentPieceFactory) {
		this.movimentPieceFactory = movimentPieceFactory;
	}

}
