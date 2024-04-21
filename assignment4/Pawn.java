package assignment4;

import java.util.ArrayList;
import static assignment4.Constants.*;

public class Pawn extends Piece {


    Pawn(Position position, PieceColor color) {
        super(position, color);
    }

    @Override
    public char getMarker() {
        return 'P';  // TODO: what?
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {  // [row][col]
        ArrayList<Move> possible_moves = new ArrayList<>();
        int row = this.getPosition().getRow();
        int col = this.getPosition().getCol();
        int size = board.getBoardSize();
        Piece will_move = board.getPiece(getPosition());

        if (will_move.getColor() == BLACK && row +1 < size){
            //Move forward
            if (board.get_matrix()[row+1][col] == null){
                possible_moves.add(new Move(new Position(row, col), new Position(row+1, col)));
            }

            // eat to the right
            if (((col + 1) < size) && board.getPiece(new Position(row + 1, col + 1)) != null && (!(board.getPiece(new Position(row + 1, col + 1)).getColor() == BLACK))){
                possible_moves.add(new Move(new Position(row, col), new Position(row+1, col+1)));
            }

            // eat to the left
            if (((col - 1) > - 1) && board.getPiece(new Position(row + 1, col - 1)) != null && (!(board.getPiece(new Position(row + 1, col - 1)).getColor() == BLACK))){
                possible_moves.add(new Move(new Position(row, col), new Position(row+1, col-1)));
            }

        }
        else if (will_move.getColor() == WHITE && row - 1 > -1) {
            //Move forward
            if (board.get_matrix()[row - 1][col] == null) {
                possible_moves.add(new Move(new Position(row, col), new Position(row - 1, col)));
            }

            // eat to the right
            if (col + 1 < size && board.getPiece(new Position(row - 1, col + 1)) != null && ((board.getPiece(new Position(row - 1, col + 1)).getColor() != WHITE))){
                possible_moves.add(new Move(new Position(row, col), new Position(row-1, col+1)));
            }

            // eat to the left
            if (((col - 1) > - 1) && board.getPiece(new Position(row - 1, col - 1)) != null && (!(board.getPiece(new Position(row - 1, col - 1)).getColor() == WHITE))){
                possible_moves.add(new Move(new Position(row, col), new Position(row-1, col-1)));
            }
        }


    return possible_moves;
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        return ((Pawn) object).getPosition().equals(this.getPosition()) && ((Pawn) object).getColor().equals(this.getColor());
    }
}
