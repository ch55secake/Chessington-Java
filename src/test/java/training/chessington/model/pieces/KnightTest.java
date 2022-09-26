package training.chessington.model.pieces;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.PlayerColour;
import training.chessington.model.Move;
import training.chessington.*;
import java.util.List;

public class KnightTest {


    @Test
    public void whiteKnightCanMoveGenerally() {
        //Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5,2 );
        board.placePiece(coords, knight);

        //Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));
    }

    @Test
    public void blackKnightCanMoveGenerally() {
        //Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(5,2 );
        board.placePiece(coords, knight);

        //Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 1)));
    }

    @Test
    public void knightCanCaptureOthers() {
        //Arrange
        Board board = Board.empty();
        Piece friendlyPiece = new Knight(PlayerColour.BLACK);
        Piece enemyPiece = new Knight(PlayerColour.WHITE);
        Coordinates knightCoordinates = new Coordinates(3,3);
        board.placePiece(knightCoordinates, friendlyPiece);

        Coordinates enemyCoordinates = new Coordinates(1, 3);
        board.placePiece(enemyCoordinates, enemyPiece);

        //Act
        List<Move> moveList = friendlyPiece.getAllowedMoves(knightCoordinates, board);


        //Assert
        assertThat(moveList).contains(new Move(knightCoordinates, enemyCoordinates));



    }

}
