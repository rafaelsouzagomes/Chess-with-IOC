package com.game.chess.services.impls.piece.pawn;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.game.chess.enums.NamePieces;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.IMovimentPieceFactory;

@Component
public class MovimentPieceFactory implements IMovimentPieceFactory{

	 
	private final Map<String, IMovimentPiece> movimentPieceMap;

    @Autowired
    public MovimentPieceFactory(@Qualifier(NamePieces.ROOK) IMovimentPiece pieceA,
                                @Qualifier(NamePieces.PAWN) IMovimentPiece pieceB) {
    	
        movimentPieceMap = new HashMap<>();
        movimentPieceMap.put(NamePieces.ROOK, pieceA);
        movimentPieceMap.put(NamePieces.PAWN, pieceB);
    }

    @Override
    public IMovimentPiece getMovimentPiece(String key) {
        return movimentPieceMap.get(key);
    }
}
