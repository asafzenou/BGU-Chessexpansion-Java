package assignment4;

import java.util.ArrayList;
import static assignment4.Constants.*;

public abstract class Piece {
    // I got this class empty and abstract
    private Position position;
    private PieceColor color;

    Piece(Position position, PieceColor color){  // constructor
        this.position = position;
        this.color = color;
    }

    public abstract char getMarker();

    public abstract ArrayList<Move> getPossibleMoves(Board board);

    public PieceColor getColor(){
        return this.color;
    }

    public char get_color_as_string(){
        return getColorMarker(this.color);
    }

    public Position getPosition(){
        return this.position;
    }

    public String toString(){
        String color = "";
        if (getColor() == BLACK){
            color = "B";
        }
        else {
            color = "W";
        }

        return getMarker() + "(" + getPosition().getRow() + "," + getPosition().getCol() + ")" + color;

    }
    public void setPosition(Position position){
        this.position = position;
    }

    protected Move move_check_board(Board board, int row, int col,int i, int j){
        if (row+i > board.getBoardSize()-1 || col+j > board.getBoardSize()-1 || row+i < 0 || col+j < 0){
            return null;
        }

        Piece piece = board.get_piece_board(row + i, col + j);
        Position new_position = new Position(row + i, col + j);

        if (piece == null) {
            Move new_move = new Move(getPosition(), new_position);
            return new_move;
        }
        Piece old = board.get_piece_board(row, col);
        if (old.getColor() != piece.getColor()){
            Move new_move = new Move(getPosition(), new_position);
            return new_move;
        }

//        try {
//
//        } catch (Exception e) {
//            return null;
//
//        }
        return null;
    }

    public abstract boolean equals(Object object);
//    public boolean equals(Object object){
//        if (this == object) return true;
//        if (object == null || getClass() != object.getClass()) return false;
//        Piece piece = (Piece) object;
//        return piece.position == this.position && piece.color == this.color && piece.getMarker() == this.getMarker();
//    }



}
