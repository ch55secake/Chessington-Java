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
    public void knightCanMoveGenerally() {
        //Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5,2 );
        board.placePiece(coords, knight);

        //Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        //Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 2)));
    }
}
