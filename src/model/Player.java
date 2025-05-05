package model;

public class Player {
    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int steps, Board board) {
        position += steps;
        position = board.checkPosition(position);
    }
}