package assignment4;

import java.util.ArrayList;
import java.util.Arrays;

import static assignment4.Constants.*;

public class Board {
    // row == col
    private Piece[][] matrix;  // [row][col]

    private ArrayList<Piece> data_structure = new ArrayList<>();
    public Piece[][] getUnderlyingMatrix() {
        return this.matrix;
    }

    // Start from here

    Board(){
        matrix = new Piece[7][7];
    }

    Board(int size){  // size * size
        matrix = new Piece[size][size];
    }


    Board(Piece[][] board){
        matrix = board;
    }

    /**
     * return all the pieces in the same color
     */
    public ArrayList<Piece> getPieces(PieceColor color){
        ArrayList<Piece> temp = new ArrayList<>();
        for (Piece piece : data_structure) {
            if (piece != null && piece.getColor().equals(color)) {
                temp.add(piece);
            }
        }
        return temp;
    }

    /**
     * return the position if it not exists it return null
     */
    public Piece getPiece(Position position){
        for (Piece piece : data_structure) {
            if (piece != null && piece.getPosition().equals(position)){
                return piece;
            }
        }
        if (matrix[position.getRow()][position.getCol()] != null){
            return matrix[position.getRow()][position.getCol()];
        }
        return null; // was not found
    }



    /**
     * adding piece
     */
    public void addPiece(Piece piece){
        if (matrix[piece.getPosition().getRow()][piece.getPosition().getCol()] != null){
            Piece will_be_remove = matrix[piece.getPosition().getRow()][piece.getPosition().getCol()];
            data_structure.remove(will_be_remove);
        }
        matrix[piece.getPosition().getRow()][piece.getPosition().getCol()] = piece;
        data_structure.add(piece);
    }

    /**
     * removing pieces
     */
    public void removePiece(Position position){
        if (matrix[position.getRow()][position.getCol()] == null){ // if there are no pieces
            return;
        }
        Piece will_be_remove = matrix[position.getRow()][position.getCol()];
        data_structure.remove(will_be_remove);
        matrix[position.getRow()][position.getCol()] = null;
    }

    /**
     * updating position
     */
    public void updatePosition(Position oldPos, Position newPos){
        Piece piece = matrix[oldPos.getRow()][oldPos.getCol()];

        if (matrix[newPos.getRow()][newPos.getCol()] != null){
            data_structure.remove(matrix[newPos.getRow()][newPos.getCol()]);
        }
        matrix[newPos.getRow()][newPos.getCol()] = piece;  //move
        piece.setPosition(newPos);
        matrix[oldPos.getRow()][oldPos.getCol()] = null;

        if (piece instanceof Tank){
            if (((Tank) piece).getCooldown() > 0) {
                ((Tank) piece).setCooldown(((Tank) piece).getCooldown()-1);
            }
        }
    }

    protected void tank_fire(Position newpos, Piece got_fired){
        data_structure.remove(got_fired);
        matrix[newpos.getRow()][newpos.getCol()] = null;
    }

    /**
     * returning the amount of all the pieces in the same color
     */
    public int getPieceCount(PieceColor pieceColor){
        if (getPieces(pieceColor) != null) {
            return getPieces(pieceColor).size();
        }
        return 0;
    }

    /**
     * Checking if it entitled to a promotion
     */
    public boolean verifyPromotion(Piece piece){
        if (piece != null && piece.getColor().equals(BLACK) && (piece.getPosition().getRow() == (matrix.length - 1))){ //| black, black black black|
            return true;                                                                                              // |                         |
        }                                                                                                            //  |                         |
        if (piece != null && piece.getColor().equals(WHITE) && piece.getPosition().getRow() == 0){                  //   |                         |
            return true;                                                                                           //    | white, white white white|
        }
        return false;
    }

    /**
     * giving promotion
     */
    public void promote(Piece piece){
        if (verifyPromotion(piece) && piece instanceof Pawn){
            Tank upgrade = new Tank(piece.getPosition(), piece.getColor());
           // matrix[piece.getPosition().getRow()][piece.getPosition().getCol()] = upgrade;
            data_structure.remove(piece);
            //data_structure.add(upgrade);
            addPiece(upgrade);
            return;
        }
        throw new IllegalArgumentException();
    }

    public int getBoardSize(){
        return matrix.length;
    }

    protected Piece[][] get_matrix(){
        return matrix;
    }

    public ArrayList<Piece> get_data_structure(){
        return data_structure;
    }

    public boolean equals(Object obj){
        return (obj instanceof Board && Arrays.deepEquals(((Board) obj).get_matrix(), this.get_matrix()) && data_structure.equals(((Board) obj).data_structure));
    }
    public Piece get_piece_board(int row, int col){
        return get_matrix()[row][col];
    }
}
