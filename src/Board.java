import java.util.*;

public class Board {
    int size;
    TreeNode root;
    List<Snake> snakes;
    List<Ladder> ladders;
    Map<Integer, Integer> snakeMap;
    Map<Integer, Integer> ladderMap;

    public Board(int size) {
        this.size = size;
        root = TreeNode.createTree(1, size * size);
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();

        // hardcoded for demo; you can make them random
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