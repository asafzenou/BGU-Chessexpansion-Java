package assignment4;

import java.util.ArrayList;

public class Knight extends Piece {
    Knight(Position position, Constants.PieceColor color) {
        super(position, color);
    }

    @Override
    public char getMarker() {
        return 'N';
    }

    private int abs(int i) {
        if (i < 0) {
            i = i * -1;
        }
        return i;
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> possible_moves = new ArrayList<>();
        int row = getPosition().getRow();
        int col = getPosition().getCol();
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (abs(i) + abs(j) == 3) {
                    Move new_move = move_check_board(board, row, col, i, j);
                    if (new_move != null && (i != 0 || j != 0)) {
                        possible_moves.add(new_move);
                    }
                }
            }
        }
        return possible_moves;
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        return ((Knight) object).getPosition().equals(this.getPosition()) && ((Knight) object).getColor().equals(this.getColor());
    }
}
