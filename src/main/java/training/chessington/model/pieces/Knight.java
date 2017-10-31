package training.chessington.model.pieces;

import javafx.scene.layout.CornerRadii;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moveList = new ArrayList<>();

        if (getColour().equals(PlayerColour.WHITE) && from.getRow() == 0) {
            return moveList;
        }
        if (getColour().equals(PlayerColour.BLACK) && from.getCol() == 7) {
            return moveList;
        }
        // as they always start in the same place make it so that the they cannot run off the map
        // similar rules to pawn inverse where the first move it moves less and after it can move more.
        if (colour == PlayerColour.WHITE) {
            Coordinates horseMove1 = new Coordinates(from.getRow() - 1, from.getCol() + 2);
            Coordinates horseMove2 = new Coordinates(from.getRow() - 2, from.getCol() + 1);
            Move move = new Move(from, horseMove1);
            Move move2 = new Move(from, horseMove2);
            moveList.add(move);
            moveList.add(move2);
        }
        if(colour == PlayerColour.BLACK) {
            Coordinates blackHorse1 = new Coordinates(from.getRow() + 1, from.getCol() + 2);
            Coordinates blackHorse2 = new Coordinates(from.getRow() + 2, from.getCol() + 1);
            Move blackMove = new Move(from, blackHorse1);
            Move blackMove2 = new Move(from, blackHorse2);
            moveList.add(blackMove);
            moveList.add(blackMove2);

        }

        return moveList;


    }
}