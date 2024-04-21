package assignment4;

import static assignment4.Constants.BLACK;

public class Move {
    protected Position startPos;
    protected Position endPos;

    public Move(Position startPos, Position endPos){
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public Position getStartPos(){
        return startPos;
    }

    public Position getEndPos(){
        return endPos;
    }

    public void updateBoard(Board board){
        board.updatePosition(startPos, endPos);
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        return ((Move) object).getEndPos().equals(this.getEndPos()) && ((Move) object).getStartPos().equals(this.getStartPos());
    }
}
// delte
//    public String toString(){
//        return ("" + startPos + " " + endPos);
//        }
//
//    public boolean equals(Object object) {
//        if (object == null || getClass() != object.getClass()) return false;
//        return ((Bishop) object).getPosition().equals(this.getPosition()) && ((Bishop) object).getColor().equals(this.getColor());
//    }

//    public boolean equals(Object object) {
//        if (object == null || getClass() != object.getClass()) return false;
//        return ((Move) object).getPosition().equals(this.getPosition()) && ((Bishop) object).getColor().equals(this.getColor());
