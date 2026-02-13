package lld.tictactoe.entities;

import lld.tictactoe.enums.Symbol;

public class Board {
    private final int size;
    private int movesCount;
    private final Cell[][] board;

    public Board(int size) {
        this.size = size;
        this.movesCount = 0;
        this.board = new Cell[size][size];
        initializeBoard();
    }

    private void initializeBoard(){
        for(int row=0;row<size;row++){
            for(int col=0;col<size;col++){
                this.board[row][col] = new Cell();
            }
        }
    }

    public boolean placeSymbol(int row,int col, Symbol symbol){
        if(row<0 || col>=size || row>= size || col<0){
            throw new IllegalArgumentException("Invalid positions : out of bounds.");
        }
        if(board[row][col].getSymbol()!=Symbol.EMPTY){
            throw new IllegalArgumentException("Invalid positions : array index of bounds");
        }
        board[row][col].setSymbol(symbol);
        movesCount++;
        return true;
    }

    public Cell getCell(int row,int col){
        if(row<0 || col>=size || row>= size || col<0){
            throw new IllegalArgumentException("Invalid positions : out of bounds.");
        }
        return board[row][col];
    }

    public boolean isFull() {
        return movesCount == size * size;
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                Symbol symbol = board[i][j].getSymbol();
                System.out.print(symbol.getChar() + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public int getSize() {
        return size;
    }
}
