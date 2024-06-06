package com.game.chess.services.impls.piece.bishop.moviment;

import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.services.pieces.moviment.ISenseDirection;

public class TopRight implements ISenseDirection{
	
	private EnumNameNotaionSquare initPos;

	@Override
	public boolean isFastReturn(int x, int y) {
		return y>=7 || x<=0;
	}
	
	@Override
	public int getYReturn(int y) {
		
		if(!secondPositionExists()) {
			return initPos.getIndex_y();
		}
		if(y>=7) {
			return 7;
		}
		return y;
	}

	@Override
	public int getFastXReturn(int x) {
		
		if(!secondPositionExists()) {
			return initPos.getIndex_x();
		}
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
	
	public boolean secondPositionExists() {
		int index_x = getX(initPos.getIndex_x());
		int index_y = getY(initPos.getIndex_y());
		EnumNameNotaionSquare enumNameNotaionSquare = EnumNameNotaionSquare.get(index_x, index_y);
		return enumNameNotaionSquare!=null;
	}

	@Override
	public ISenseDirection setInitPosition(int x, int y) {
		this.initPos = EnumNameNotaionSquare.get(x, y);
		return this;
	}



}
