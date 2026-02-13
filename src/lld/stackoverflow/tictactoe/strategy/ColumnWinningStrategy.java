package lld.stackoverflow.tictactoe.strategy;

import lld.stackoverflow.tictactoe.entities.Board;
import lld.stackoverflow.tictactoe.entities.Player;

public class ColumnWinningStrategy implements WinningStrategy{


    @Override
    public boolean checkWinner(Board board, Player player) {
        for (int col = 0; col < board.getSize(); col++) {
            boolean colWin = true;
            for (int row = 0; row < board.getSize(); row++) {
                if (board.getCell(row, col).getSymbol() != player.getSymbol()) {
                    colWin = false;
                    break;
                }
            }
            if (colWin) return true;
        }
        return false;
    }
}
