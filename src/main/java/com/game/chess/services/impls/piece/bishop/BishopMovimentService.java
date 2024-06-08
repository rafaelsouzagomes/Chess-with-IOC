package com.game.chess.services.impls.piece.bishop;

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
import com.game.chess.services.impls.piece.bishop.moviment.BottomLeft;
import com.game.chess.services.impls.piece.bishop.moviment.BottomRight;
import com.game.chess.services.impls.piece.bishop.moviment.TopLeft;
import com.game.chess.services.impls.piece.bishop.moviment.TopRight;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.moviment.ISenseDirection;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Qualifier(NamePieces.BISHOP)
public class BishopMovimentService implements IMovimentPiece{

	private IMovimentOptions iMovimentOptions;
	
	private TopLeft topLeft;
	
	private BottomRight bottomRight;
	
	private BottomLeft bottomLeft;
	
	private TopRight topRight;
	
	private LongerMoviment longerMoviment;
	
	@Override
	public void addMovimentsAvailable(ITeamManager teamManager, EnumNameNotaionSquare currentPosition) {
		iMovimentOptions.setTeamManager(teamManager);
		
		longerMoviment.setFirstDirection(topLeft);
		longerMoviment.setSecondDirection(topRight);
		longerMoviment.setThirdDirection(bottomLeft);
		longerMoviment.setFourthDirection(bottomRight);
		
		extracted(currentPosition);
//		addMoviments(null, currentPosition.getIndex_x(), currentPosition.getIndex_y());
	}

	private void extracted(EnumNameNotaionSquare currentPosition) {
		longerMoviment.addMoviments(currentPosition);
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
		
		int[] maxTopLeft = addMoviments(topLeft.setInitPosition(x,y), x-1, y-1);
		int[] maxTopRight = addMoviments(topRight.setInitPosition(x,y), x-1, y+1);
		int[] maxBottomLeft = addMoviments(bottomLeft.setInitPosition(x,y), x+1, y-1);
		int[] maxBottomRight = addMoviments(bottomRight.setInitPosition(x,y),x+1, y+1);
		
		return Stream.of(maxTopLeft, maxTopRight, maxBottomLeft, maxBottomRight)
               .flatMapToInt(IntStream::of)
               .toArray();
	}
	
	@Autowired
	@Lazy
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
		
	}

}
