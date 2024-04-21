package assignment4;

import static assignment4.Constants.*;

import assignment4.*;

import java.util.ArrayList;

public class MainRun {

    public static void boardMain() {
        Board b = new Board(4);
        Board c = new Board();
        Board d = new Board(new Piece[5][5]);
//        System.out.println("Board size: " + b.getBoardSize());
//        System.out.println("Board size: " + b);
//        b = new Board(5);
//        System.out.println("Board size: " + b.getBoardSize());
//        Piece[][] matrix = new Piece[3][3];
//        b = new Board(matrix);
//        System.out.println("Board size: " + b.getBoardSize());
//        Position p1 = new Position(0, 0);
//        Position p2 = new Position(1, 0);
//        b.addPiece(new Pawn(p1, BLACK));
//        System.out.println("Piece at (0,0): " + b.getPiece(p1));
//        System.out.println("Piece at (1,0): " + b.getPiece(p2));
//        b.updatePosition(p1, p2);
//        System.out.println("Piece at (0,0): " + b.getPiece(p1));
//        System.out.println("Piece at (1,0): " + b.getPiece(p2));
//        b.addPiece(new Pawn(p1, WHITE));
//        System.out.println("White pieces: " + b.getPieces(WHITE));
//        System.out.println("Black pieces: " + b.getPieces(BLACK));
//        b.removePiece(p1);
//        b.removePiece(p2);
//        System.out.println("# of black pieces: " + b.getPieceCount(BLACK));
//        Pawn promotable = new Pawn(new Position(0, 0), WHITE);
//        b.addPiece(promotable);
//        System.out.println(b.verifyPromotion(promotable));
//        b.promote(promotable);
//        System.out.println(b.equals(new Board()));

//        Position p3 = new Position(1, 1);
//        b.addPiece(new Bishop(p3, BLACK));
//        ArrayList<Move> move = b.getPiece(p3).getPossibleMoves(b);
//        for (int i=0; i < move.size(); i++){
//            System.out.println(move.get(i));
//        }
//        System.out.println(b.getPiece(new Position(1, 1)));
        Position p00 = new Position(1, 3);
        Position p02 = new Position(0, 2);
        Position p21 = new Position(2, 1);
        Position p22 = new Position(2, 2);
        Position p11 = new Position(1, 1);
        Position p31 = new Position(3, 1);

        b.addPiece(new Bishop(p00, BLACK));
        b.addPiece(new King(p02, BLACK));
        b.addPiece(new Pawn(p21, BLACK));
        b.addPiece(new Knight(p22, BLACK));


//        System.out.println(b.getPiece(p00).getPossibleMoves(b));
//        System.out.println(b.get_data_structure());
//        b.removePiece(p22);
//        System.out.println(b.get_data_structure());
//        System.out.println(b.getPiece(p00).getPossibleMoves(b));
//        b.addPiece(new Knight(p22, WHITE));
//        b.addPiece(new Bishop(p11, BLACK));
//
//        System.out.println(b.getPiece(p11).getPossibleMoves(b));
//        b.removePiece(p22);
//        System.out.println(b.getPiece(p11).getPossibleMoves(b));
//        b.addPiece(new Knight(p22, WHITE));
//
//        System.out.println(b.getPiece(p22).getPossibleMoves(b));
//
//        System.out.println(b.get_data_structure());
//        b.removePiece(p00);
        b.removePiece(p02);
        System.out.println();
        for (int i=0; i < b.getBoardSize(); i++){
            String l = "";
            for (int j=0; j < b.getBoardSize(); j++){
                l = l +  b.getUnderlyingMatrix()[i][j] + "     " ;
            }
            System.out.println(l);

        }


        for (int k=0; k < b.getPiece(p00).getPossibleMoves(b).size(); k++){
            String end = "" + b.getPiece(p00).getPossibleMoves(b).get(k).getEndPos();
            String start = "" + b.getPiece(p00).getPossibleMoves(b).get(k).getStartPos();
            System.out.println(start + "-->" + end);
        }
        b.updatePosition(p00, p22);

        b.removePiece(p02);
        System.out.println("DATA STRUC - " + b.get_data_structure());
        System.out.println("--------------------------------------");

        b.addPiece(new Pawn(p31, WHITE));
        for (int i=0; i < b.getBoardSize(); i++){
            String l = "";
            for (int j=0; j < b.getBoardSize(); j++){
                l = l +  b.getUnderlyingMatrix()[i][j] + "     " ;
            }
            System.out.println(l);

        }


        for (int k=0; k < b.getPiece(p22).getPossibleMoves(b).size(); k++){
            String end = "" + b.getPiece(p22).getPossibleMoves(b).get(k).getEndPos();
            String start = "" + b.getPiece(p22).getPossibleMoves(b).get(k).getStartPos();
            System.out.println(start + "-->" + end);
        }

//        System.out.println();
        System.out.println("DATA STRUC - " + b.get_data_structure());
        System.out.println(b.getPiece(p21).getPossibleMoves(b).size());
        System.out.println();
        System.out.println(b.getPieceCount(PieceColor.Black));
        System.out.println(b.getPieces(PieceColor.White));
        b.removePiece(p22);
        b.removePiece(p21);
        System.out.println(b.getPieceCount(PieceColor.Black));






    }

    public static void moveMain() {
//        Position p1 = new Position(0, 0);
//        Position p2 = new Position(1, 1);
//        Position p3 = new Position(1, 1);
//        Board b = new Board();
//        b.addPiece(new Pawn(p1, BLACK));
//        Move m = new Move(p1, p2);
//        System.out.println("Move start position: " + m.getStartPos());
//        System.out.println("Move end position: " + m.getEndPos());
//        m.updateBoard(b);
//        System.out.println("Piece at (0,0): " + b.getPiece(p1));
//        System.out.println("Piece at (1,1): " + b.getPiece(p2));
//        System.out.println(m.equals(new Move(p1, p2)));
//        System.out.println(m.equals(new Move(p1, p3)));
    }

    public static void pawnMain() {
        // While each piece type needs to be implemented accordingly, we will test the general methods on pawn.
        // Be encouraged to add your own tests!
//        Piece piece = new Pawn(new Position(1, 1), WHITE);
//        System.out.println("Pawn marker: " + piece.getMarker());
//        System.out.println("Pawn color: " + piece.getColor());
//        System.out.println("Pawn position: " + piece.getPosition());
//        piece.setPosition(new Position(2, 2));
//        System.out.println("Pawn new position: " + piece.getPosition());
//        System.out.println("Pawn string form: " + piece);
//        Board b = new Board();
//        b.addPiece(piece);
//        System.out.println("# of possible moves: " + piece.getPossibleMoves(b).size());
    }

    public static void tankMain() {
//        Tank t = new Tank(new Position(1, 1), BLACK);
//        System.out.println("Tank initial cooldown: " + t.getCooldown());
//        t.setCooldown(1);
//        System.out.println("Tank cooldown after change: " + t.getCooldown());
    }

    public static void main(String[] args) {
//        System.out.println("---Board Testing---");
        boardMain();
//        System.out.println("---Move Testing---");
        moveMain();
//        System.out.println("---Piece (Pawn) Testing---");
        pawnMain();
//        System.out.println("---Tank Testing---");
        tankMain();
    }
}