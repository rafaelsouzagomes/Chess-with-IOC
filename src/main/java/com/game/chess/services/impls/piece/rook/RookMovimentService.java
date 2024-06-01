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
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Qualifier(NamePieces.ROOK)
public class RookMovimentService implements IMovimentPiece{

	private IMovimentOptions iMovimentOptions;
	
	@Override
	public void addMovimentsAvailable(ITeamManager teamManager, EnumNameNotaionSquare currentPosition) {
		currentPosition.getIndex_x();
		
	}
	
//	public static enum SentidoEnumMov {
//		INIT(), TOP, BOTTOM, LEFT, RIGHT;
//		
//		Integer x_max;
//		Integer x_min;
//		Integer y_max;
//		Integer y_min;
//		
//		
//	}
	
	public interface ISense {}
	
	public class Top implements ISense{
		
		public int getX(int x) {
			return x-1;
		}
		public int getY(int y) {
			return y;
		}
	}
	
	protected int[] addMoviments2(String sentido, int x, int y) {
		
		if( sentido.equals("TOP") && x<=0 || sentido.equals("BOTTOM") && x>=7 || sentido.equals("RIGHT") && y>=7  || sentido.equals("LEFT") && y<=0  ) {
			x = Math.max(x, 0);
			x = Math.min(x, 7);
			y = Math.max(y, 0);
			y = Math.min(y, 7);
			iMovimentOptions.addMove(x, y);
			return new int[] {x,y};
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
