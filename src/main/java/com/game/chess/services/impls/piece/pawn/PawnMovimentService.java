package com.game.chess.services.impls.piece.pawn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.NamePieces;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.pawn.IPawnTeamManager;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Qualifier(NamePieces.PAWN)
public class PawnMovimentService implements IMovimentPiece {
	
	private IMovimentOptions iMovimentOptions;
	private int index_y;
	private int index_x;
	
	@Autowired
	@Lazy
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
	}
	
	@Override
	public void addMovimentsAvailable(ITeamManager teamManager,
									  EnumNameNotaionSquare currentPosition) {
	
		IPawnTeamManager pawnTeamManager = (IPawnTeamManager) teamManager;
		index_x = currentPosition.getIndex_x();
		index_y = currentPosition.getIndex_y();
		
		addSimpleMoviment(pawnTeamManager);
		addDoubleMoviment(pawnTeamManager);
		addCaptureMovimentLeft(pawnTeamManager);
		addCaptureMovimentRight(pawnTeamManager);
	}

	protected int[] addSimpleMoviment(IPawnTeamManager pawnTeamManager) {
		int index_x_to_move = pawnTeamManager.getSimpleMovimentAhead(index_x);
		int index_y_to_Move =index_y;
		
		iMovimentOptions.addMove(index_x_to_move, index_y_to_Move);
		
		return new int[] {index_x_to_move, index_y_to_Move};
	}

	protected int[] addDoubleMoviment(IPawnTeamManager pawnTeamManager) {
		boolean canMoveTwoSquares = pawnTeamManager.canMoveTwoSquares(index_x);
		int index_x_to_move = pawnTeamManager.getDoubleMovimentAhead(index_x);
		int index_y_to_Move =index_y;
		
		if(canMoveTwoSquares) {
			iMovimentOptions.addMove(index_x_to_move, index_y_to_Move);
			return new int[] {index_x_to_move, index_y_to_Move};
		}
		return new int[] {};
	}

	protected int[] addCaptureMovimentLeft(IPawnTeamManager pawnTeamManager) {
		int index_x_to_move = pawnTeamManager.getCaptureMovimentAhead(index_x);
		int index_y_to_Move = pawnTeamManager.getCaptureMovimentLeft(index_y);
		
		iMovimentOptions.addCaptureMove( index_x_to_move, index_y_to_Move);
		
		return new int[] {index_x_to_move, index_y_to_Move};
	}

	protected int[] addCaptureMovimentRight(IPawnTeamManager pawnTeamManager) {
		int index_x_to_move = pawnTeamManager.getCaptureMovimentAhead(index_x);
		int index_y_to_Move = pawnTeamManager.getCaptureMovimentRight(index_y);
		
		iMovimentOptions.addCaptureMove(index_x_to_move, index_y_to_Move);
		return new int[] {index_x_to_move, index_y_to_Move};
	}


	
}
