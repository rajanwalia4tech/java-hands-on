package lld.stackoverflow.tictactoe.strategy;

import lld.stackoverflow.tictactoe.entities.Board;
import lld.stackoverflow.tictactoe.entities.Player;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player) {
        boolean leftDiagonalWin = true;
        for (int idx = 0; idx < board.getSize(); idx++) {
           if(board.getCell(idx,idx).getSymbol() != player.getSymbol()){
               leftDiagonalWin = false;
               break;
           }
        }
        if(leftDiagonalWin) return true;

        boolean rightDiagonalWin = true;
        for (int idx = 0; idx < board.getSize(); idx++) {
            if(board.getCell(idx,board.getSize()-idx-1).getSymbol() != player.getSymbol()){
                rightDiagonalWin = false;
                break;
            }
        }
        if(rightDiagonalWin) return true;

        return false;
    }
}
