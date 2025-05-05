package model;

import java.util.*;

public class Board {
    private final int size;
    private final TreeNode root;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    private final Map<Integer, Integer> snakeMap;
    private final Map<Integer, Integer> ladderMap;

    public Board(int size) {
        this.size = size;
        root = TreeNode.createTree(1, size * size);
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();

        snakes.add(new Snake(97, 78));
        snakes.add(new Snake(62, 19));
        ladders.add(new Ladder(4, 56));
        ladders.add(new Ladder(23, 89));

        for (Snake s : snakes) snakeMap.put(s.start, s.end);
        for (Ladder l : ladders) ladderMap.put(l.start, l.end);
    }

    public int checkPosition(int pos) {
        if (snakeMap.containsKey(pos)) return snakeMap.get(pos);
        if (ladderMap.containsKey(pos)) return ladderMap.get(pos);
        return pos;
    }

    public int getSize() {
        return size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void printBoard() {
        int n = size;
        boolean leftToRight = true;
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                int val = (i - 1) * n + (leftToRight ? (n - j + 1) : j);
                System.out.print(String.format("%4d", val));
            }
            leftToRight = !leftToRight;
            System.out.println();
        }
    }
}
