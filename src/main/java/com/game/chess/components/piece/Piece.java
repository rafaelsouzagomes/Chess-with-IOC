package com.game.chess.components.piece;

import org.springframework.lang.NonNull;

import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

public class Piece {
	
	@NonNull
	private EnumTeam team;
	
	@NonNull
	private EnumTypePiece type;
	
	protected Piece() {}
	
	@Override
	public String toString() {
		return  type.getAbr()+team.getAbr();
	}
	
	protected void setTeam(EnumTeam team) {
		this.team = team;
	}
	
	protected void setType(EnumTypePiece type) {
		this.type = type;
	}
	
	public EnumTeam getTeam() {
		return team;
	}
	
	public EnumTypePiece getType() {
		return type;
	}
	
}
