package lld.tictactoe.strategy;

import lld.tictactoe.entities.Board;
import lld.tictactoe.entities.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player);
}
