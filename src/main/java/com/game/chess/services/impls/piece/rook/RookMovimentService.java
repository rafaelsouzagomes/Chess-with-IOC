package com.game.chess.services.impls.piece.rook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.NamePieces;
import com.game.chess.services.impls.piece.LongerMoviment;
import com.game.chess.services.impls.piece.rook.moviment.Bottom;
import com.game.chess.services.impls.piece.rook.moviment.Left;
import com.game.chess.services.impls.piece.rook.moviment.Right;
import com.game.chess.services.impls.piece.rook.moviment.Top;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Qualifier(NamePieces.ROOK)
public class RookMovimentService implements IMovimentPiece{

	private IMovimentOptions iMovimentOptions;
	
	private LongerMoviment longerMoviment;
	
	private Bottom bottom;
	private Top top;
	private Left left;
	private Right right;
	
	
	@Override
	public void addMovimentsOptionsAvailable(ITeamManager teamManager, EnumNameNotaionSquare currentPosition) {
		iMovimentOptions.setTeamManager(teamManager);
		
		longerMoviment.setFirstDirection(top);
		longerMoviment.setSecondDirection(bottom);
		longerMoviment.setThirdDirection(right);
		longerMoviment.setFourthDirection(left);
		
		addMoviment(currentPosition);
	}

	protected int[] addMoviment(EnumNameNotaionSquare currentPosition) {
		return longerMoviment.addMoviments(currentPosition);
	}
	
	@Autowired
	@Lazy
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
		
	}
	@Autowired
	public void setLongerMoviment(LongerMoviment longerMoviment) {
		this.longerMoviment = longerMoviment;
	}
	@Autowired
	public void setBottom(Bottom bottom) {
		this.bottom = bottom;
	}
	@Autowired
	public void setLeft(Left left) {
		this.left = left;
	}
	@Autowired
	public void setRight(Right right) {
		this.right = right;
	}
	@Autowired
	public void setTop(Top top) {
		this.top = top;
	}
}
