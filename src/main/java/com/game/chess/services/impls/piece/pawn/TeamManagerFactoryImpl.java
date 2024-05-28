package com.game.chess.services.impls.piece.pawn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;
import com.game.chess.services.pieces.pawn.IPawnTeamManager;
import com.game.chess.services.pieces.pawn.ITeamManager;
import com.game.chess.services.pieces.pawn.TeamManagerFactory;

@Service
public class TeamManagerFactoryImpl implements TeamManagerFactory {

    private  ITeamManager whitePawnTeamManager;
    private  ITeamManager blackPawnTeamManager;
    
    private ITeamManager whiteTeamManager;
    
    private ITeamManager blackTeamManager;

    @Autowired
    public TeamManagerFactoryImpl(@Qualifier("whitePawnTeamManager") IPawnTeamManager whitePawnTeamManager,
    							  @Qualifier("blackPawnTeamManager") IPawnTeamManager blackPawnTeamManager,
    							  @Qualifier("whiteTeamManager") ITeamManager whiteTeamManager,
    							  @Qualifier("blackTeamManager") ITeamManager blackTeamManager) {
    	
        this.whitePawnTeamManager = whitePawnTeamManager;
        this.blackPawnTeamManager = blackPawnTeamManager;
        this.whiteTeamManager = whiteTeamManager;
        this.blackTeamManager = blackTeamManager;
    }
    
    @Override
    public ITeamManager getTeamManager(EnumTypePiece piece, EnumTeam team) {
    	if(piece.isPawn()) 
    		return getPawnManager(team);
      
    	return getGeneralTeamManager(team);
    }
    


	private ITeamManager getGeneralTeamManager(EnumTeam team) {
		switch (team) {
	        case WHITE:
	            return whiteTeamManager;
	        case BLACK:
	            return blackTeamManager;
	        default:
	            throw new IllegalArgumentException("Unknown team type: " + team);
			}
	}

	private ITeamManager getPawnManager(EnumTeam team) {
		switch (team) {
		case WHITE:
		    return whitePawnTeamManager;
		case BLACK:
		    return blackPawnTeamManager;
		default:
		    throw new IllegalArgumentException("Unknown team type: " + team);
		}
	}
    
    @Autowired
    public void setBlackTeamManager(ITeamManager blackTeamManager) {
		this.blackTeamManager = blackTeamManager;
	}
    
    @Autowired
    public void setWhiteTeamManager(ITeamManager whiteTeamManager) {
		this.whiteTeamManager = whiteTeamManager;
	}
    
    @Autowired
    public void setWhitePawnTeamManager(IPawnTeamManager whitePawnTeamManager) {
		this.whitePawnTeamManager = whitePawnTeamManager;
	}
    
    @Autowired
    public void setBlackPawnTeamManager(IPawnTeamManager blackPawnTeamManager) {
		this.blackPawnTeamManager = blackPawnTeamManager;
	}
}
