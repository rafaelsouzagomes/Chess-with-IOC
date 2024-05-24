package com.game.chess.services.impls.piece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.game.chess.enums.EnumTeam;

@Service
public class PawnTeamManagerFactoryImpl implements PawnTeamManagerFactory {

    private  IPawnTeamManager whitePawnTeamManager;
    private  IPawnTeamManager blackPawnTeamManager;

    @Autowired
    public PawnTeamManagerFactoryImpl(@Qualifier("whitePawnTeamManager") IPawnTeamManager whitePawnTeamManager,
    								  @Qualifier("blackPawnTeamManager") IPawnTeamManager blackPawnTeamManager) {
        this.whitePawnTeamManager = whitePawnTeamManager;
        this.blackPawnTeamManager = blackPawnTeamManager;
    }
    
    @Autowired
    public void setWhitePawnTeamManager(IPawnTeamManager whitePawnTeamManager) {
		this.whitePawnTeamManager = whitePawnTeamManager;
	}
    
    @Autowired
    public void setBlackPawnTeamManager(IPawnTeamManager blackPawnTeamManager) {
		this.blackPawnTeamManager = blackPawnTeamManager;
	}

    @Override
    public IPawnTeamManager getPawnTeamManager(EnumTeam team) {
        switch (team) {
            case WHITE:
                return whitePawnTeamManager;
            case BLACK:
                return blackPawnTeamManager;
            default:
                throw new IllegalArgumentException("Unknown team type: " + team);
        }
    }
}
