package com.game.chess.models.enums;

import java.util.HashMap;
import java.util.Map;

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
	
	private static final Map<String, EnumTeam> ENUM_MAP;
	
	static {
		ENUM_MAP = new HashMap<>();
        for (EnumTeam instance : EnumTeam.values()) {
            ENUM_MAP.put(instance.getName(), instance);
        }
    }

    public static EnumTeam get(String name) {
        return ENUM_MAP.get(name);
    }
    
	public static EnumTeam getAdversaryTeam(EnumTeam teamthatPlayed) {
		EnumTeam adversaryteam = EnumTeam.BLACK;
		if(teamthatPlayed.isBlack())
			adversaryteam = EnumTeam.WHITE;
		return adversaryteam;
	}
	
}
