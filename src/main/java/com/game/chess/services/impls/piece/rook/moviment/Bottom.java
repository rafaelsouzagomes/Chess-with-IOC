package com.game.chess.services.impls.piece.rook.moviment;

import org.springframework.stereotype.Component;

import com.game.chess.services.pieces.moviment.ISenseDirection;

@Component
public class Bottom implements ISenseDirection {

	@Override
	public boolean isFastReturn(int x, int y) {
		return x>=7;
	}
	
	@Override
	public int getYReturn(int y) {
		return y;
	}

	@Override
	public int getFastXReturn(int x) {
		return 7;
	}

	@Override
	public int getY(int y) {
		return y;
	}

	@Override
	public int getX(int x) {
		return x+1;
	}

	@Override
	public ISenseDirection setInitPosition(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
}