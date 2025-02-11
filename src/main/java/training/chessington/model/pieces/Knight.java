package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static training.chessington.model.pieces.Rook.getMoves;

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
        moveList = returnMoveifValid(from, from.getRow() + 1, from.getCol() - 2, board, moveList, colour);
        moveList = returnMoveifValid(from, from.getRow() + 2, from.getCol() - 1, board, moveList,colour);
        moveList = returnMoveifValid(from, from.getRow() + 2, from.getCol() + 1, board, moveList,colour);
        moveList = returnMoveifValid(from, from.getRow() + 1, from.getCol() + 2, board, moveList,colour);
        moveList = returnMoveifValid(from, from.getRow() - 2, from.getCol() +1, board, moveList,colour);
        moveList = returnMoveifValid(from, from.getRow() -2, from.getCol() - 1, board, moveList,colour);
        moveList = returnMoveifValid(from, from.getRow() -1, from.getCol()- 2, board, moveList,colour);
        moveList = returnMoveifValid(from, from.getRow()- 1, from.getCol() +2, board, moveList,colour);


        return moveList;


    }

    public static List<Move> returnMoveifValid(Coordinates from, int row, int column, Board board, List<Move> moveList, PlayerColour colour) {
        return getMoves(from, row, column, board, moveList, colour);
    }
}
