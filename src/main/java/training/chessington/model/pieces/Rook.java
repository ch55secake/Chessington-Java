package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.awt.event.MouseEvent;
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

        moveList = whiteRookMovingForward(from, board, moveList);
        if(from.getCol() != 7) {
            moveList = whiteRookMovingRight(from, board, moveList);
        }
        if(from.getCol() != 0) {
            moveList = whiteRookMovingLeft(from, board, moveList);
        }
        return moveList;



    // moveList = returnMoveIfValid(from, from.getRow() -6, from.getCol(), board, moveList, colour);

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

    public List<Move> whiteRookMovingForward(Coordinates from, Board board, List<Move> moveList) {
        int count = 1;
        for (int i = 0; i < 7; i++) {
            Coordinates rookMove = new Coordinates(from.getRow() - count, from.getCol());
            if(board.get(rookMove) == null) {
                Move move = new Move(from, rookMove);
                moveList.add(move);
                count++;
            } else {
                return moveList;
            }

        }
        return moveList;
    }

    public List<Move> whiteRookMovingRight(Coordinates from, Board board, List<Move> moveList) {
        int count = 1;
        for (int i = 0; i < 7; i++) {
            Coordinates rookMove = new Coordinates(from.getRow(), from.getCol() + count);
            if(board.get(rookMove) == null) {
                Move move = new Move(from, rookMove);
                moveList.add(move);
                count++;
            } else {
                return moveList;
            }

        }
        return moveList;
    }
    public List<Move> whiteRookMovingLeft(Coordinates from, Board board, List<Move> moveList) {
        int count = 1;
        for (int i = 0; i < 7; i++) {
            Coordinates rookMove = new Coordinates(from.getRow(), from.getCol() - count);
            if(board.get(rookMove) == null) {
                Move move = new Move(from, rookMove);
                moveList.add(move);
                count++;
            } else {
                return moveList;
            }

        }
        return moveList;
    }



}
