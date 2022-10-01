package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moveList = new ArrayList<>();

        if(getColour().equals(PlayerColour.WHITE) && from.getRow() == 0){
            return moveList;
        }
        if(getColour().equals(PlayerColour.BLACK) && from.getRow() == 7){
            return moveList;
        }

        moveList = returnMoveIfValid(from, from.getRow()- 1, from.getCol(), board, moveList, colour);
        moveList = returnMoveIfValid(from, from.getRow(), from.getCol() + 1, board, moveList, colour);
        moveList = returnMoveIfValid(from, from.getRow()- 2, from.getCol(), board, moveList, colour);
        moveList = returnMoveIfValid(from, from.getRow(), from.getCol() + 2, board, moveList, colour);
        moveList = returnMoveIfValid(from, from.getRow()- 3, from.getCol(), board, moveList, colour);
        moveList = returnMoveIfValid(from, from.getRow(), from.getCol() + 3, board, moveList, colour);

    return moveList;
    }
    public static List<Move> returnMoveIfValid(Coordinates from, int row, int column, Board board, List<Move> moveList, PlayerColour colour) {
        return getMoves(from, row, column, board, moveList, colour);
    }

    static List<Move> getMoves(Coordinates from, int row, int column, Board board, List<Move> moveList, PlayerColour colour) {
        if (row >= 0 && row <= 7 && column >= 0 && column <= 7) {
            Coordinates checkingCoordinates = new Coordinates(row, column);
            if(board.get(checkingCoordinates) == null) {
                Move move = new Move(from, checkingCoordinates);
                moveList.add(move);
            } else {
                if(! board.get(checkingCoordinates).getColour().equals(colour)) {
                    Move move = new Move(from, checkingCoordinates);
                    moveList.add(move);
                }
            }
        }
        return moveList;
    }


}
