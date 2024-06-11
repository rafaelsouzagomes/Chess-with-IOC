package com.game.chess.services.impls.piece.queen;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.NamePieces;
import com.game.chess.services.impls.piece.LongerMoviment;
import com.game.chess.services.impls.piece.bishop.moviment.BottomLeft;
import com.game.chess.services.impls.piece.bishop.moviment.BottomRight;
import com.game.chess.services.impls.piece.bishop.moviment.TopLeft;
import com.game.chess.services.impls.piece.bishop.moviment.TopRight;
import com.game.chess.services.impls.piece.rook.moviment.Bottom;
import com.game.chess.services.impls.piece.rook.moviment.Left;
import com.game.chess.services.impls.piece.rook.moviment.Right;
import com.game.chess.services.impls.piece.rook.moviment.Top;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Qualifier(NamePieces.QUEEN)
public class QueenMovimentService implements IMovimentPiece{

	private LongerMoviment longerMoviment;
	
	private Bottom bottom;
	private Top top;
	private Left left;
	private Right right;
	
	private TopLeft topLeft;
	private BottomRight bottomRight;
	private BottomLeft bottomLeft;
	private TopRight topRight;
	
	@Override
	public void addMovimentsOptionsAvailable(ITeamManager teamManager, EnumNameNotaionSquare currentPosition) {
		addMoviments(currentPosition);
	}

	protected int[] addMoviments(EnumNameNotaionSquare currentPosition) {
		longerMoviment.setFirstDirection(topLeft);
		longerMoviment.setSecondDirection(topRight);
		longerMoviment.setThirdDirection(bottomLeft);
		longerMoviment.setFourthDirection(bottomRight);
		
		int[] rookMovs = addMoviment(currentPosition);
		
		longerMoviment.setFirstDirection(top);
		longerMoviment.setSecondDirection(bottom);
		longerMoviment.setThirdDirection(right);
		longerMoviment.setFourthDirection(left);
		
		int[] bishopMovs= addMoviment(currentPosition);
		
		return IntStream.concat(Arrays.stream(rookMovs), Arrays.stream(bishopMovs)).toArray();
	}
	
	private int[] addMoviment(EnumNameNotaionSquare currentPosition) {
		return longerMoviment.addMoviments(currentPosition);
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
