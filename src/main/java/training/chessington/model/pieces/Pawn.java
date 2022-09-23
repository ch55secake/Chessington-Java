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
        // if pawn has never moved it can move two
        List<Move> moveList = new ArrayList<>();
        if (colour == PlayerColour.WHITE) {
            if (from.getRow() == 6) {
                Coordinates whiteMove2 = new Coordinates(from.getRow() - 2, from.getCol());
                Move move = new Move(from, whiteMove2);
                if(board.get(whiteMove2) == null){
                    moveList.add(move);
                }
            }
                Coordinates whiteMove1 = new Coordinates(from.getRow() - 1, from.getCol());
                Move move = new Move(from, whiteMove1);
                if(board.get(whiteMove1) == null){
                     moveList.add(move);
                }
        }
        else  {
            if (from.getRow() == 1) {
                Coordinates blackMove2 = new Coordinates(from.getRow() + 2, from.getCol()); // or add 1 to the move list
                Move move = new Move(from, blackMove2);
                if(board.get(blackMove2) == null){
                    moveList.add(move);
                }
            }
                Coordinates blackMove1 = new Coordinates(from.getRow() + 1, from.getCol());
                Move move = new Move(from, blackMove1);
                if(board.get(blackMove1) == null){
                    moveList.add(move);
                }
        }
        return moveList;



    }

    }







