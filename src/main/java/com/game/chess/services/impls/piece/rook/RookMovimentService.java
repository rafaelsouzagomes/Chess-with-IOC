package com.game.chess.services.impls.piece.rook;

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
	
	protected int[] searchMoviments(String sentido, int x, int y) {
		if(sentido.equals("TOP") && x==0) {
			iMovimentOptions.addMove(x, y);
			return new int[] {x,y};
		}
		
		if(sentido.equals("BOTTOM") && x==7) {
			iMovimentOptions.addMove(x, y);
			return new int[] {x,y};
		}
		
		if(sentido.equals("RIGHT") && y==7) {
			iMovimentOptions.addMove(x, y);
			return new int[] {x,y};
		}
		
		if(sentido.equals("LEFT") && y==0) {
			iMovimentOptions.addMove(x, y);
			return new int[] {x,y};
		}
			
		if(iMovimentOptions.isEmpty(x, y) && !sentido.equals("INIT")) {
			iMovimentOptions.addMove(x, y);
			
			if(sentido.equals("TOP")) {
				return searchMoviments("TOP", x-1, y);
			}
			
			if(sentido.equals("BOTTOM")) {
				return searchMoviments("BOTTOM", x+1, y);
			}
			
			if(sentido.equals("RIGHT")) {
				return searchMoviments("RIGHT", x, y+1);
			}
			
			if(sentido.equals("LEFT")) {
				return searchMoviments("LEFT",x, y-1);
			}			
		} else {
			if(!sentido.equals("INIT")) {
 				iMovimentOptions.addCaptureMove(x, y);				
				return new int[] {x,y}; // problem
			}
		} 
		int c_x = x;
		int c_y = y; 
		int[] maxTop = searchMoviments("TOP", c_x-1, c_y);
		int[] maxBottom = searchMoviments("BOTTOM", c_x+1, c_y);
		int[] maxRight = searchMoviments("RIGHT", c_x, c_y+1);
		int[] maxLeft = searchMoviments("LEFT",c_x, c_y-1);
		
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
