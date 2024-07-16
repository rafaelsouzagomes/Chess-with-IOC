package com.game.chess.services.components.piece;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.enums.EnumTypePiece;

@Component
public class Piece {
	
	@NonNull
	private EnumTeam team;
	
	@NonNull
	private EnumTypePiece type;
	
	protected Piece() {}
	
	public Piece(EnumTypePiece type, EnumTeam team) {
		this.type = type;
		this.team = team;
	}
	
	@Override
	public boolean equals(Object obj) {
		Piece pieceToCompare = (Piece) obj;
		
		return this.getType() == pieceToCompare.getType() && 
				this.getTeam() == pieceToCompare.getTeam();
	}
	
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

	@JsonIgnore
	public boolean isKing() {
		return type == EnumTypePiece.KING;
	}
	
	@JsonIgnore
	public boolean isPawn() {
		return type == EnumTypePiece.PAWN;
	}
	
}
