package com.game.chess.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.game.chess.models.enums.EnumTeam;

@Entity
public class Player {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlayer;
	
	private String username;
	
    @Enumerated(EnumType.STRING)
    private EnumTeam team;
    
    public void setTeam(EnumTeam team) {
		this.team = team;
	}
    
    public EnumTeam getTeam() {
		return team;
	}

	public Long getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
