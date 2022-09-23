package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moveList = new ArrayList<>();
        Coordinates coordinateAbove = new Coordinates(from.getRow()-1 , from.getCol());
        Move move = new Move(from, coordinateAbove);
        moveList.add(move);

        return moveList;
    }
}
