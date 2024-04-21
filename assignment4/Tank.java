package assignment4;
import java.util.ArrayList;

import static assignment4.Constants.*;

public class Tank extends Piece {

    int cooldown = 0;

    Tank(Position position, PieceColor color) {
        super(position, color);
    }

    @Override
    public char getMarker() {
        return 'T';
    }


    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> possible_moves = new ArrayList<>();
        int row = getPosition().getRow();
        int col = getPosition().getCol();
        ArrayList<Move> moves = only_move(board, possible_moves, row, col);

        if (getCooldown() != 0){
            return moves;
        }

        Piece tank = board.get_piece_board(row, col);
        for (int i=1; i <= 2; i++){  //right
            if (board.get_piece_board(row, col+i) != null && board.get_piece_board(row, col+i).getColor() != tank.getColor()){
                moves.add(new TankEatMove(getPosition(), new Position(row, col+i)));
                break;
            }
            if (board.get_piece_board(row, col+i) != null && board.get_piece_board(row, col+i).getColor() == tank.getColor()){
                break;
            }
        }

        for (int i=1; i <= 2; i++){  //down
            if (board.get_piece_board(row+i, col) != null && board.get_piece_board(row+i, col).getColor() != tank.getColor()){
                moves.add(new TankEatMove(getPosition(), new Position(row+i, col)));
                break;
            }
            if (board.get_piece_board(row+i, col) != null && board.get_piece_board(row+i, col).getColor() == tank.getColor()){
                break;
            }
        }

        for (int i=1; i <= 2; i++){  //up
            if (board.get_piece_board(row-i, col) != null && board.get_piece_board(row-i, col).getColor() != tank.getColor()){
                moves.add(new TankEatMove(getPosition(), new Position(row-i, col)));
                break;
            }
            if (board.get_piece_board(row-i, col) != null && board.get_piece_board(row-i, col).getColor() == tank.getColor()){
                break;
            }
        }

        for (int i=1; i <= 2; i++){  //left
            if (board.get_piece_board(row, col-i) != null && board.get_piece_board(row, col-i).getColor() != tank.getColor()){
                moves.add(new TankEatMove(getPosition(), new Position(row, col-i)));
                break;
            }
            if (board.get_piece_board(row, col-i) != null && board.get_piece_board(row, col-i).getColor() == tank.getColor()){
                break;
            }
        }

        for (int i=1; i <= 2; i++){  //right down
            if (board.get_piece_board(row+i, col+i) != null && board.get_piece_board(row+i, col+i).getColor() != tank.getColor()){
                moves.add(new TankEatMove(getPosition(), new Position(row+i, col+i)));
                break;
            }
            if (board.get_piece_board(row+i, col+i) != null && board.get_piece_board(row+i, col+i).getColor() == tank.getColor()){
                break;
            }
        }

        for (int i=1; i <= 2; i++){  //left down
            if (board.get_piece_board(row+i, col-i) != null && board.get_piece_board(row+i, col-i).getColor() != tank.getColor()){
                moves.add(new TankEatMove(getPosition(), new Position(row+i, col-i)));
                break;
            }
            if (board.get_piece_board(row+i, col-i) != null && board.get_piece_board(row+i, col-i).getColor() == tank.getColor()){
                break;
            }
        }

        for (int i=1; i <= 2; i++){  //right up
            if (board.get_piece_board(row-i, col+i) != null && board.get_piece_board(row-i, col+i).getColor() != tank.getColor()){
                moves.add(new TankEatMove(getPosition(), new Position(row-i, col+i)));
                break;
            }
            if (board.get_piece_board(row-i, col+i) != null && board.get_piece_board(row-i, col+i).getColor() == tank.getColor()){
                break;
            }
        }

        for (int i=1; i <= 2; i++){  //left up
            if (board.get_piece_board(row-i, col-i) != null && board.get_piece_board(row-i, col-i).getColor() != tank.getColor()){
                moves.add(new TankEatMove(getPosition(), new Position(row-i, col-i)));
                break;
            }
            if (board.get_piece_board(row-i, col-i) != null && board.get_piece_board(row-i, col-i).getColor() == tank.getColor()){
                break;
            }
        }

        return moves;

    }

    private ArrayList<Move> only_move(Board board, ArrayList<Move> possible_moves, int row, int col){
        for (int i=-1; i< 2;i++){
            if (row+i > 0 && row+i < board.getBoardSize() && board.get_piece_board(row+i, col) == null){
                Move moving = new Move(getPosition(), new Position(row+i,col));
                possible_moves.add(moving);
            }
            if (col+i > 0 && col+i < board.getBoardSize() && board.get_piece_board(row, col+i) == null){
                Move moving = new Move(getPosition(), new Position(row,col+i));
                possible_moves.add(moving);
            }
        }
        return possible_moves;
    }
    public int getCooldown(){
            return cooldown;

    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        return ((Tank) object).getPosition().equals(this.getPosition()) && ((Tank) object).getColor().equals(this.getColor())  && this.getCooldown() == ((Tank) object).getCooldown();
    }

    public void setCooldown(int cooldown){
        this.cooldown = cooldown;
    }
}