package assignment4;

public class TankEatMove extends Move {

    public TankEatMove(Position startPos, Position endPos) {
        super(startPos, endPos);
    }

    public void updateBoard(Board board){
        Tank tank_move = (Tank)board.getPiece(startPos);
        if (tank_move.getCooldown() == 0){
            Piece got_fired = board.getPiece(endPos);
            board.tank_fire(endPos, got_fired);
            tank_move.setCooldown(2);
        }
    }
}
//        if (piece instanceof Tank){
//            int cool = ((Tank) piece).getCooldown();
//            if (matrix[newPos.getRow()][newPos.getCol()] == null){
//                ((Tank) piece).setCooldown(cool-1);
//            }
//            else {
//                if(((Tank) piece).getCooldown() != 0){
//                    return;
//                }
//                ((Tank) piece).setCooldown(2);
//            }
//        }