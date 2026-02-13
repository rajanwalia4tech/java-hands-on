package lld.stackoverflow.tictactoe.entities;

import lld.stackoverflow.tictactoe.enums.GameStatus;
import lld.stackoverflow.tictactoe.observer.GameSubject;
import lld.stackoverflow.tictactoe.states.GameState;
import lld.stackoverflow.tictactoe.states.InProgressState;
import lld.stackoverflow.tictactoe.strategy.ColumnWinningStrategy;
import lld.stackoverflow.tictactoe.strategy.DiagonalWinningStrategy;
import lld.stackoverflow.tictactoe.strategy.RowWinningStrategy;
import lld.stackoverflow.tictactoe.strategy.WinningStrategy;

import java.util.List;

public class Game extends GameSubject{
    private final Player player1, player2;
    public final Board board;
    public Player currentPlayer;
    public  Player winner;
    public GameStatus status;
    public GameState state;
    private final List<WinningStrategy> winningStrategies;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(3);
        this.currentPlayer = player1;
        this.status = GameStatus.IN_PROGRESS;
        this.state = new InProgressState();
        this.winningStrategies = List.of(
            new ColumnWinningStrategy(),
            new RowWinningStrategy(),
            new DiagonalWinningStrategy()
        );
    }

    public boolean checkWinner(Player player){
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkWinner(board,player)){
                return true;
            }
        }
        return false;
    }

    public void switchPlayer(){
        this.currentPlayer = (this.currentPlayer == player1)? player2 : player1;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void makeMove(Player player, int row, int col) {
        state.handleMove(this, player, row, col);
    }

    public void setStatus(GameStatus status) {
        this.status = status;
        // Notify observers when the status changes to a finished state
        if (status != GameStatus.IN_PROGRESS) {
            notifyObservers();
        }
    }

}
