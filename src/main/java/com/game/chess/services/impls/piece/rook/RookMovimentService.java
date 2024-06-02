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
import com.game.chess.services.impls.piece.rook.moviment.Bottom;
import com.game.chess.services.impls.piece.rook.moviment.Init;
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
	
	
	@Override
	public void addMovimentsAvailable(ITeamManager teamManager, EnumNameNotaionSquare currentPosition) {
		iMovimentOptions.setTeamManager(teamManager);
		addMoviments2(null, currentPosition.getIndex_x(), currentPosition.getIndex_y());
	}
	
	protected int[] addMoviments2(ISenseDirection sentido, int x, int y) {
		if( Objects.nonNull(sentido) && sentido.isFastReturn(x, y) ) {
			iMovimentOptions.addMove(sentido.getFastXReturn(x), sentido.getYReturn(y));
			return new int[] {sentido.getFastXReturn(x),sentido.getYReturn(y)};
		}
				
		if(Objects.nonNull(sentido) && iMovimentOptions.isEmpty(x, y)  ) {
			iMovimentOptions.addMove(x, y);
			return addMoviments2(sentido, sentido.getX(x), sentido.getY(y));
		} 
		if(Objects.nonNull(sentido)) {
			iMovimentOptions.addCaptureMove(x, y);				
			return new int[] {x,y}; 
		} 
		
		int[] maxTop = addMoviments2(new Top(), x-1, y);
		int[] maxBottom = addMoviments2(new Bottom(), x+1, y);
		int[] maxRight = addMoviments2(new Right(), x, y+1);
		int[] maxLeft = addMoviments2(new Left(),x, y-1);
		
		return Stream.of(maxTop, maxBottom, maxRight, maxLeft)
               .flatMapToInt(IntStream::of)
               .toArray();
	}
	
	protected int[] addMoviments(String sentido, int x, int y) {
		if(sentido.equals("TOP") && x<=0) {
			iMovimentOptions.addMove(0, y);
			return new int[] {0,y};
		}
		
		if(sentido.equals("BOTTOM") && x>=7) {
			iMovimentOptions.addMove(7, y);
			return new int[] {7,y};
		}
		
		if(sentido.equals("RIGHT") && y>=7) {
			iMovimentOptions.addMove(x, 7);
			return new int[] {x,7};
		}
		
		if(sentido.equals("LEFT") && y<=0) {
			iMovimentOptions.addMove(x, 0);
			return new int[] {x,0};
		}
			
		if(iMovimentOptions.isEmpty(x, y) && !sentido.equals("INIT")) {
			iMovimentOptions.addMove(x, y);
			
			if(sentido.equals("TOP")) {
				return addMoviments("TOP", x-1, y);
			}
			
			if(sentido.equals("BOTTOM")) {
				return addMoviments("BOTTOM", x+1, y);
			}
			
			if(sentido.equals("RIGHT")) {
				return addMoviments("RIGHT", x, y+1);
			}
			
			if(sentido.equals("LEFT")) {
				return addMoviments("LEFT",x, y-1);
			}			
		} else {
			if(!sentido.equals("INIT")) {
 				iMovimentOptions.addCaptureMove(x, y);				
				return new int[] {x,y}; // problem
			}
		} 
		int[] maxTop = addMoviments("TOP", x-1, y);
		int[] maxBottom = addMoviments("BOTTOM", x+1, y);
		int[] maxRight = addMoviments("RIGHT", x, y+1);
		int[] maxLeft = addMoviments("LEFT",x, y-1);
		
		   return Stream.of(maxTop, maxBottom, maxRight, maxLeft)
                   .flatMapToInt(IntStream::of)
                   .toArray();
	}
	
	@Autowired
	@Lazy
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
		
	}

}
