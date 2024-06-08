package com.game.chess.services.impls.piece;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.services.pieces.ILongerMoviment;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.moviment.ISenseDirection;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LongerMoviment implements ILongerMoviment {
	
	private IMovimentOptions iMovimentOptions;
	
	private ISenseDirection firstDirection;
    private ISenseDirection secondDirection;
    private ISenseDirection thirdDirection;
    private ISenseDirection fourthDirection;

    
	public int[] addMoviments(EnumNameNotaionSquare currentPosition) {	
		return addMoviments(null, currentPosition.getIndex_x(), currentPosition.getIndex_y());
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
		
		int[] maxTopLeft = addMoviments(firstDirection.setInitPosition(x,y), 
										firstDirection.getX(x), 
										firstDirection.getY(y));
		
		int[] maxTopRight = addMoviments(secondDirection.setInitPosition(x,y),
										 secondDirection.getX(x), 
										 secondDirection.getY(y));
		
		int[] maxBottomLeft = addMoviments(thirdDirection.setInitPosition(x,y), 
										   thirdDirection.getX(x), 
										   thirdDirection.getY(y));
		
		int[] maxBottomRight = addMoviments(fourthDirection.setInitPosition(x,y),
											fourthDirection.getX(x), 
											fourthDirection.getY(y));
		
		return Stream.of(maxTopLeft, maxTopRight, maxBottomLeft, maxBottomRight)
               .flatMapToInt(IntStream::of)
               .toArray();
	}

	@Autowired
	@Lazy
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
	}

	@Autowired
	@Lazy
	public void setFirstDirection(ISenseDirection firstDirection) {
		this.firstDirection = firstDirection;
	}

	@Autowired
	@Lazy
	public void setSecondDirection(ISenseDirection secondDirection) {
		this.secondDirection = secondDirection;
	}
	
	@Autowired
	@Lazy
	public void setThirdDirection(ISenseDirection thirdDirection) {
		this.thirdDirection = thirdDirection;
	}

	@Autowired
	@Lazy
	public void setFourthDirection(ISenseDirection fourthDirection) {
		this.fourthDirection = fourthDirection;
	}
	
	
	
}
