package assignment4;

import java.util.ArrayList;

public class Bishop extends Piece {
    Bishop(Position position, Constants.PieceColor color) {
        super(position, color);
    }

    @Override
    public char getMarker() {
        return 'B';
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> possible_moves = new ArrayList<>();
        int row = getPosition().getRow();
        int col = getPosition().getCol();
        way(board, row, col, 1,1,possible_moves);
        way(board, row, col, 1,-1,possible_moves);
        way(board, row, col, -1,1,possible_moves);
        way(board, row, col, -1,-1,possible_moves);
        return possible_moves;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        return ((Bishop) object).getPosition().equals(this.getPosition()) && ((Bishop) object).getColor().equals(this.getColor());
    }

    private void way(Board board, int row, int col,int up, int right, ArrayList<Move> possible_moves){
        int index=1;
        while (true){
            Move new_move = move_check_board(board, row, col, up*index, right*index);  // same color or out of range(index)
            if (new_move != null) {
                possible_moves.add(new_move);
            }
            else{
                break;
            }
            if (board.getPiece(new_move.getEndPos()) != null){
                break;
            }
//            Piece end = board.getPiece(new_move.getEndPos());
//            Piece start = board.getPiece(new_move.getStartPos());
//            if (end != null && start.getColor() != end.getColor()){
//                break;
//            }
            index++;
        }
    }

}
