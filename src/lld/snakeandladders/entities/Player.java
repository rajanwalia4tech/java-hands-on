package lld.snakeandladders.entities;

public class Player {
    private String name;
    private int position;

    Player(String name){
        this.name = name;
        this.position = 0; // default position of each player
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
