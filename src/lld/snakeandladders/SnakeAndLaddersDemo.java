package lld.snakeandladders;

import lld.snakeandladders.entities.*;

import java.util.*;

public class SnakeAndLaddersDemo {
    static void main() {
        List<BoardEntity> boardEntities = List.of(
                new Snake(41, 17),
                new Snake(73, 36),
                new Snake(62, 26),
                new Snake(98, 79),
                new Ladder(3, 38),
                new Ladder(12, 33),
                new Ladder(42, 93),
                new Ladder(56, 84)
        );

        List<String> players = Arrays.asList("Rajan", "Mukul", "Aman");

        Game game = new Game.Builder()
                .setBoard(100, boardEntities)
                .setPlayers(players)
                .setDice(new Dice(1, 6))
                .build();

        game.play();
    }
}
