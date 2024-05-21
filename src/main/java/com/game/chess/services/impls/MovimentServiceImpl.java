package com.game.chess.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.piece.Piece;
import com.game.chess.dtos.MovimentOptionsAvailable;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumTeam;
import com.game.chess.services.IMovimentService;
import com.game.chess.services.impls.piece.MovimentPieceFactory;
import com.game.chess.services.pieces.IMovimentPiece;

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
	public MovimentOptionsAvailable getMovimentOptions(MovimentRequestDTO mov) {
		chessboard.createNewGame();

		IMovimentPiece movimentPiece = movimentPieceFactory.getMovimentPiece(mov.getPieceToMove());
		
		return movimentPiece.findMovimentsAvailable(mov);
	}

	

}
