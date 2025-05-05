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


        Random rand = new Random();
        Set<Integer> usedPositions = new HashSet<>();
        
        int maxPos = size * size;
        
        // Random number of snakes and ladders between 4 and 5
        int numSnakes = rand.nextInt(2) + 4;  // 4 or 5
        int numLadders = rand.nextInt(2) + 4; // 4 or 5
        
        // Generate snakes
        while (snakes.size() < numSnakes) {
            int start = rand.nextInt(maxPos - 1) + 2; // start from 2 to maxPos
            int end = rand.nextInt(start - 1) + 1;    // end from 1 to start-1
        
            if (start == end || usedPositions.contains(start) || usedPositions.contains(end)) {
                continue;
            }
        
            snakes.add(new Snake(start, end));
            snakeMap.put(start, end);
            usedPositions.add(start);
            usedPositions.add(end);
        }
        
        // Generate ladders
        while (ladders.size() < numLadders) {
            int start = rand.nextInt(maxPos - 2) + 1;      // start from 1 to maxPos - 2
            int end = rand.nextInt(maxPos - start) + start + 1; // end from start+1 to maxPos
        
            if (start == end || usedPositions.contains(start) || usedPositions.contains(end)) {
                continue;
            }
        
            ladders.add(new Ladder(start, end));
            ladderMap.put(start, end);
            usedPositions.add(start);
            usedPositions.add(end);
        }
        

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