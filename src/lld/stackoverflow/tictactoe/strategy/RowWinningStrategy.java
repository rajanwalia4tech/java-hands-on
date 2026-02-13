package lld.stackoverflow.tictactoe.strategy;

import lld.stackoverflow.tictactoe.entities.Board;
import lld.stackoverflow.tictactoe.entities.Player;

import java.awt.desktop.AboutEvent;

public class RowWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board, Player player) {
        for(int row=0;row<board.getSize();row++){
            boolean rowWin=true;
            for(int col=0; col< board.getSize(); col++){
                if(board.getCell(row,col).getSymbol() != player.getSymbol()){
                    rowWin = false;
                    break;
                }
            }
            if(rowWin) return true;
        }
        return false;
    }
}
