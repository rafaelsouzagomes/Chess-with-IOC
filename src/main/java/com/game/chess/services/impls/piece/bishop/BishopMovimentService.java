package com.game.chess.services.impls.piece.bishop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.NamePieces;
import com.game.chess.services.impls.piece.LongerMoviment;
import com.game.chess.services.impls.piece.bishop.moviment.BottomLeft;
import com.game.chess.services.impls.piece.bishop.moviment.BottomRight;
import com.game.chess.services.impls.piece.bishop.moviment.TopLeft;
import com.game.chess.services.impls.piece.bishop.moviment.TopRight;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Qualifier(NamePieces.BISHOP)
public class BishopMovimentService implements IMovimentPiece{

	private LongerMoviment longerMoviment;
	
	private TopLeft topLeft;
	private BottomRight bottomRight;
	private BottomLeft bottomLeft;
	private TopRight topRight;
	
	@Override
	public void addMovimentsAvailable(ITeamManager teamManager, 
									  EnumNameNotaionSquare currentPosition) {
		
		longerMoviment.setFirstDirection(topLeft);
		longerMoviment.setSecondDirection(topRight);
		longerMoviment.setThirdDirection(bottomLeft);
		longerMoviment.setFourthDirection(bottomRight);
		
		addMoviment(currentPosition);
	}

	protected int[] addMoviment(EnumNameNotaionSquare currentPosition) {
		return longerMoviment.addMoviments(currentPosition);
	}
	
	@Autowired
	@Lazy
	public void setLongerMoviment(LongerMoviment longerMoviment) {
		this.longerMoviment = longerMoviment;
	}
	
	@Autowired
	public void setBottomLeft(BottomLeft bottomLeft) {
		this.bottomLeft = bottomLeft;
	}
	
	@Autowired
	public void setBottomRight(BottomRight bottomRight) {
		this.bottomRight = bottomRight;
	}
	
	@Autowired
	public void setTopLeft(TopLeft topLeft) {
		this.topLeft = topLeft;
	}
	
	@Autowired
	public void setTopRight(TopRight topRight) {
		this.topRight = topRight;
	}

}
