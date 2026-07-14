package lld.snakeandladders.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Board {
    int size;
    Map<Integer, Integer> snakeAndLadders;

    public Board(int size, List<BoardEntity> entities){
        this.size = size;
        this.snakeAndLadders = new HashMap<>();

        for(BoardEntity entity : entities){
            int start = entity.getStart();
            int end = entity.getEnd();

            if(start < 1  || start > size || end < 1 || end > size){
                throw new IllegalArgumentException("Snake and Ladders position must be within 1 and " + size + ".");
            }

            if(snakeAndLadders.containsKey(start)){
                throw new IllegalArgumentException("Snake and Ladders cannot share the same start cell: " + start + ".");
            }
            snakeAndLadders.put(start, end);
        }
    }

    public int getSize() {
        return size;
    }

    public int getFinalPosition(int position) {
        return snakeAndLadders.getOrDefault(position,position);
    }
}
