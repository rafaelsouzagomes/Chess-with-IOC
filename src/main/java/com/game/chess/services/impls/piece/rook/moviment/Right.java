package com.game.chess.services.impls.piece.rook.moviment;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.game.chess.services.pieces.moviment.ISenseDirection;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Right implements ISenseDirection {

	@Override
	public boolean isFastReturn(int x, int y) {
		return y>=7;
	}
	
	@Override
	public int getYReturn(int y) {
		return 7;
	}

	@Override
	public int getFastXReturn(int x) {
		return x;
	}

	@Override
	public int getY(int y) {
		return y+1;
	}

	@Override
	public int getX(int x) {
		return x;
	}

	@Override
	public ISenseDirection setInitPosition(int x, int y) {
		return this;
	}
}