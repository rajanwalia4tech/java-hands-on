# Snake and Ladders

## Functional Requirements

1. The game is played on a standard 10x10 board with 100 numbered cells
2. Support configuration of snakes and ladders with flexible start and end positions
3. Allow multiple players (minimum two), with turn rotation in round-robin order
4. Simulate dice rolls with random values between 1 and 6. A player gets an extra turn if they roll a 6
5. Three 6s in a row forfeits the turn, sending the player back to the position they started the turn from
6. A player must roll the exact number to land on cell 100 and win the game
7. Multiple players can occupy the same cell without interaction


## Non Functional Requirements

**Modularity** : The system should follow object-oriented principles with clean separation between components

**Extensibility** : The design should allow future enhancements such as custom board sizes or different types of dice

**Maintainability**: The codebase should be clean, readable, and easy to extend

**User Feedback** : The system should provide clear console output after each turn, indicating player moves, dice rolls, snake or ladder interactions, and current positions

## Core Entities

### Classes
1. **Board** - Game is played on a standard 10x10 board with 100 numbered cells.
2. **Player** - name and current position on the board. Players start at position 0 (off the board) and move toward 100.
3. **Game** -  The game should manage turns, apply snakes and ladders, and determine when a player wins.
4. **Snake** - Snake's start (head) will be higher than it end tail.
5. **Ladder** - Ladder's start(bottom) will be lower than its end (top).
   Both are "board entities" that transport a player from one position to another. This suggests an abstract base class BoardEntity that Snake and Ladder can inherit from.
6. **Dice** - Dice entity to simulate random rolls.

### Enums
**GameStatus** - The game also needs to track its current state. Is it still running? Has someone won? An enum GameStatus with values NOT_STARTED, RUNNING, and FINISHED captures all possibilities cleanly.

## Open Points
- How can we make the game such that it can have multiple winners in sequence?



