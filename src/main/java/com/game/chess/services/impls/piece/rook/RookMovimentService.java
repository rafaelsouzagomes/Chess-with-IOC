package com.game.chess.services.impls.piece.rook;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
import com.game.chess.services.pieces.moviment.ISenseDirection;
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
	public void addMovimentsAvailable(ITeamManager teamManager, EnumNameNotaionSquare currentPosition) {
		iMovimentOptions.setTeamManager(teamManager);
		
		longerMoviment.setFirstDirection(top);
		longerMoviment.setSecondDirection(bottom);
		longerMoviment.setThirdDirection(right);
		longerMoviment.setFourthDirection(left);
		
		addMoviment(currentPosition);
		
//		addMoviments(null, currentPosition.getIndex_x(), currentPosition.getIndex_y());
	}

	protected int[] addMoviment(EnumNameNotaionSquare currentPosition) {
		return longerMoviment.addMoviments(currentPosition);
	}
	
	protected int[] addMoviments(ISenseDirection sentido, int x, int y) {
		if( Objects.nonNull(sentido) && sentido.isFastReturn(x, y) ) {
			iMovimentOptions.addMove(sentido.getFastXReturn(x), sentido.getYReturn(y));
			return new int[] {sentido.getFastXReturn(x),sentido.getYReturn(y)};
		}
				
		if(Objects.nonNull(sentido) && iMovimentOptions.isEmpty(x, y)  ) {
			iMovimentOptions.addMove(x, y);
			return addMoviments(sentido, sentido.getX(x), sentido.getY(y));
		} 
		if(Objects.nonNull(sentido)) {
			iMovimentOptions.addCaptureMove(x, y);				
			return new int[] {x,y}; 
		} 
		
		int[] maxTop = addMoviments(new Top(), x-1, y);
		int[] maxBottom = addMoviments(new Bottom(), x+1, y);
		int[] maxRight = addMoviments(new Right(), x, y+1);
		int[] maxLeft = addMoviments(new Left(),x, y-1);
		
		return Stream.of(maxTop, maxBottom, maxRight, maxLeft)
               .flatMapToInt(IntStream::of)
               .toArray();
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
