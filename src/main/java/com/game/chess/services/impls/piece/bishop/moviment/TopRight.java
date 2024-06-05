package com.game.chess.services.impls.piece.bishop.moviment;

import com.game.chess.services.pieces.moviment.ISenseDirection;

public class TopRight implements ISenseDirection{
	
	private Integer y;

	@Override
	public boolean isFastReturn(int x, int y) {
		this.y=y;
		return y>=7 || x<=0;
	}
	
	@Override
	public int getYReturn(int y) {
		if(y>=7) {
			return 7;
		}
		return y;
	}

	@Override
	public int getFastXReturn(int x) {
		if(x<=0) {
			return 0;
		}
		return x;
	}

	@Override
	public int getY(int y) {
		return y+1;
	}

	@Override
	public int getX(int x) {
		return x-1;
	}



}
