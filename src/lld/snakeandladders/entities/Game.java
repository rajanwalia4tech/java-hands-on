package lld.snakeandladders.entities;

import lld.snakeandladders.enums.GameStatus;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    Board board;
    Queue<Player> players;
    Dice dice;
    GameStatus status;
    Player winner;

    private Game(Builder builder){
        this.board = builder.board;
        this.players = new LinkedList<>(builder.players);
        this.dice = builder.dice;
        this.status = GameStatus.NOT_STARTED;
    }

    public void play(){
        if(players.size() < 2){
            System.out.printf("Cannot start game. At least 2 players are required.");
            return;
        }

        this.status = GameStatus.RUNNING;
        System.out.println("Game Started...");
        while(status == GameStatus.RUNNING){
            Player currentPlayer = players.poll();
            takeTurn(currentPlayer);
            if(status == GameStatus.RUNNING){
                players.add(currentPlayer);
            }
        }
        System.out.println("Game Finished...");

        if(winner!= null){
            System.out.printf("The Winner is %s!%n", winner.getName());
        }
    }

    private void takeTurn(Player player){
        takeTurn(player, 0, player.getPosition());
    }

    private void takeTurn(Player player, int consecutiveSixes, int turnStartPosition){
        int roll = dice.roll();
        if(roll == 6 && consecutiveSixes == 2){
            player.setPosition(turnStartPosition);
            System.out.printf("%s rolled three 6s in a row. Turn Forfeited, back to %d.%n", player.getName(),turnStartPosition);
            return;
        }

        int currentPosition = player.getPosition();
        int nextPosition = currentPosition + roll;

        // is it overshooting the board?
        if(nextPosition > board.getSize()){
            System.out.printf("Oops, %s needs to land exactly on %d. Turn skipped. %n", player.getName(),turnStartPosition);
            return;
        }

        // check for winning
        if(nextPosition == board.getSize()){
            player.setPosition(nextPosition);
            this.winner = player;
            this.status = GameStatus.FINISHED;
            System.out.printf("%s reached the final square %d and won! %n", player.getName(), board.getSize());
            return;
        }

        int finalPosition = board.getFinalPosition(nextPosition);

        if(finalPosition > nextPosition){
            System.out.printf("Wow! %s found a ladder at %d and climbed to %d. %n", player.getName(), nextPosition, finalPosition);
        }else if(finalPosition < nextPosition){
            System.out.printf("Oh no! %s was bitten by a snake at %d and slid down to %d. %n", player.getName(), nextPosition, finalPosition);
        }else{
            System.out.printf("%s moved from %d to %d. %n", player.getName(), currentPosition, finalPosition);
        }

        player.setPosition(finalPosition);

        // Extra turn for rolling 6
        if(roll == 6){
            System.out.printf("%s moved from %d to %d. %n", player.getName(), currentPosition, finalPosition);
            takeTurn(player, consecutiveSixes + 1, turnStartPosition);
        }
    }

    // Builder inner class
    public static class Builder{
        private Board board;
        private Queue<Player> players;
        private Dice dice;

        public Builder setBoard(int boardSize, List<BoardEntity> boardEntities){
            this.board = new Board(boardSize,boardEntities);
            return this;
        }

        public Builder setPlayers(List<String> playerNames){
            this.players = new LinkedList<>();
            for(String playerName : playerNames){
                players.add(new Player(playerName));
            }
            return this;
        }

        public Builder setDice(Dice dice){
            this.dice = dice;
            return this;
        }

        public Game build(){
            if(board == null || players == null || dice == null){
                throw new IllegalStateException("Board, Players and Dice must be set before starting game");
            }
            return new Game(this);
        }
    }

}
