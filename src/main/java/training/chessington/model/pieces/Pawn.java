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

        if (getColour().equals(PlayerColour.WHITE) && from.getRow() == 0) {
            return moveList;
        }
        if (getColour().equals(PlayerColour.BLACK) && from.getRow() == 7) {
            return moveList;
        }

        if (colour == PlayerColour.WHITE) {
            if (from.getRow() == 6) {
                Coordinates whiteMove2 = new Coordinates(from.getRow() - 2, from.getCol());
                Move move = new Move(from, whiteMove2);
                if (board.get(whiteMove2) == null) {
                    moveList.add(move);
                }
            }
            Coordinates whiteMove1 = new Coordinates(from.getRow() - 1, from.getCol());
            Move move = new Move(from, whiteMove1);
            moveList.addAll(attackingFromDiagonals(from, PlayerColour.WHITE, board, moveList));
            if (board.get(whiteMove1) == null) {
                moveList.add(move);
            }
        } else {
            if (from.getRow() == 1) {
                Coordinates blackMove2 = new Coordinates(from.getRow() + 2, from.getCol()); // or add 1 to the move list
                Move move = new Move(from, blackMove2);
                if (board.get(blackMove2) == null) {
                    moveList.add(move);
                }
            }
            Coordinates blackMove1 = new Coordinates(from.getRow() + 1, from.getCol());
            Move move = new Move(from, blackMove1);
            //here
            attackingFromDiagonals(from, PlayerColour.BLACK, board, moveList);
            moveList.addAll(attackingFromDiagonals(from, PlayerColour.BLACK, board, moveList));
            if (board.get(blackMove1) == null) {
                moveList.add(move);
            }
        }
        return moveList;


    }

    public static List<Move> attackingFromDiagonals(Coordinates blackCurrentPos, PlayerColour colour, Board board, List<Move> moveList) {
        if (colour.equals(PlayerColour.BLACK)) {
            // CONDITION 1 // Pawn can attack diagonally when there is a piece diagonal to it

            if (blackCurrentPos.getCol() > 0 && board.get(blackCurrentPos.plus(1, -1)) != null ) {
                if (! board.get(blackCurrentPos.plus(1, -1)).getColour().equals(PlayerColour.BLACK)) {
                    Coordinates To = blackCurrentPos.plus(1, -1);
                    Move move = new Move(blackCurrentPos, To);
                    moveList.add(move);

                } }
                if (blackCurrentPos.getCol() < 7 && board.get(blackCurrentPos.plus(1, 1)) != null) {
                    if (! board.get(blackCurrentPos.plus(1, 1)).getColour().equals(PlayerColour.BLACK)) {
                        Coordinates To = blackCurrentPos.plus(1, 1);
                        Move move = new Move(blackCurrentPos, To);
                        moveList.add(move);

                } }

            } else {
                if (blackCurrentPos.getCol() < 7 && board.get(blackCurrentPos.plus(-1, 1)) != null) {
                    if (! board.get(blackCurrentPos.plus(-1, 1)).getColour().equals(PlayerColour.WHITE)){

                        Coordinates To = blackCurrentPos.plus(-1, 1);
                        Move move = new Move(blackCurrentPos, To);
                        moveList.add(move);
                } }
                if (blackCurrentPos.getCol() > 0 &&  board.get(blackCurrentPos.plus(-1, -1)) != null) {
                    if (! board.get(blackCurrentPos.plus(-1, -1)).getColour().equals(PlayerColour.WHITE)){

                        Coordinates To = blackCurrentPos.plus(-1, -1);
                        Move move = new Move(blackCurrentPos, To);
                        moveList.add(move);
                } }
            }

            return moveList;

        }


    }








