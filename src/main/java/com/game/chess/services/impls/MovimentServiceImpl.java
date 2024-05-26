package com.game.chess.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.piece.Piece;
import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumTeam;
import com.game.chess.services.IMovimentService;
import com.game.chess.services.impls.piece.pawn.MovimentPieceFactory;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.pawn.IPawnTeamManager;

@Service
public class MovimentServiceImpl implements IMovimentService {
	
	private ChessBoard chessboard;
	
	private MovimentPieceFactory movimentPieceFactory;
	
	@Autowired
	public void setChessboard(ChessBoard chessboard) {
		this.chessboard = chessboard;
	}
	
	@Autowired
	public void setMovimentPieceFactory(MovimentPieceFactory movimentPieceFactory) {
		this.movimentPieceFactory = movimentPieceFactory;
	}

	@Override
	public MovimentOptionsAvailableDTO getMovimentOptions(MovimentRequestDTO mov) {
		chessboard.createNewGame();

		IMovimentPiece movimentPiece = movimentPieceFactory.getMovimentPiece(mov.getPieceToMove());
		
//		EnumTeam team = EnumTeam.get(mov.getTeam());
//		IPawnTeamManager pawnTeamManager = pawnTeamManagerFactory.getPawnTeamManager(team);
//		iMovimentOptions.setTeamManager(pawnTeamManager); // isso precisa ser injetado apenas manualmente
//		iMovimentOptions.setChessBoard(chessBoard);
		
		return movimentPiece.findMovimentsAvailable(mov);
	}

	

}
