package com.game.chess.enums;

public enum EnumTeam {
	
	BLACK("B", "Black"), 
	WHITE("W", "White");
	
	private String abr;
	private String name;
	
	private EnumTeam(String abr, String name) {
		this.abr = abr;
		this.name = name;
	}
	
	public String getAbr() {
		return abr;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isBlack() {
		return abr.equals("B");
	}
	
	public boolean isWhite() {
		return abr.equals("W");
	}
	
}
