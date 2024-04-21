package assignment4;

import java.util.ArrayList;

public class King extends Piece {
    King(Position position, Constants.PieceColor color) {
        super(position, color);
    }

    @Override
    public char getMarker() {
        return 'K';
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> possible_moves = new ArrayList<>();
        int row = getPosition().getRow();
        int col = getPosition().getCol();

        for (int i = -1; i < 2; i++) {  // rows
            for (int j = -1; j < 2; j++) {  // cols
               Move new_move =  move_check_board(board, row, col, i, j);
               if (new_move != null && (i != 0 || j != 0)) {
                   possible_moves.add(new_move);
               }

            }
        }
        return possible_moves;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        return ((King) object).getPosition().equals(this.getPosition()) && ((King) object).getColor().equals(this.getColor());
    }
}
