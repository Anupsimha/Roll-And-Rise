import java.util.*;

public class Game {
    private List<Player> players;
    private Board board;
    private Dice dice;

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Game Mode:\n1. 1v1\n2. Multiplayer\n3. Vs Online (Coming Soon)");
        int mode = sc.nextInt();

        players = new ArrayList<>();

        int numPlayers = (mode == 1) ? 2 : 0;
        if (mode == 2) {
            System.out.print("Enter number of players: ");
            numPlayers = sc.nextInt();
        }

        sc.nextLine(); // consume newline
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter Player " + (i + 1) + " name: ");
            String name = sc.nextLine();
            players.add(new Player(name));
        }

        System.out.println("Choose Board Size (Default is 10): ");
        String sizeInput = sc.nextLine();
        int size = 10;
        if (!sizeInput.trim().isEmpty()) {
            try {
                size = Integer.parseInt(sizeInput);
            } catch (Exception e) {
                System.out.println("Invalid input. Using default board size 10x10.");
            }
        } else {
            System.out.println("Using default board size 10x10.");
        }

        board = new Board(size);
        dice = new Dice();

        System.out.println("\nBoard Initialized with size: " + size + "x" + size);
        board.printBoard();

        System.out.println("\nSnakes:");
        for (Snake s : board.snakes) {
            System.out.println("From: " + s.start + " To: " + s.end);
        }
        System.out.println("\nLadders:");
        for (Ladder l : board.ladders) {
            System.out.println("From: " + l.start + " To: " + l.end);
        }

        boolean won = false;
        while (!won) {
            for (Player p : players) {
                String ready = "";
                do {
                    System.out.print("\n" + p.getName() + ", are you ready? (Y/N): ");
                    ready = sc.nextLine();
                } while (!ready.equalsIgnoreCase("Y"));

                int roll = dice.roll();
                System.out.println(p.getName() + " rolled a " + roll);
                p.move(roll, board);
                if (p.getPosition() >= size * size) {
                    System.out.println(p.getName() + " wins the game! 🏆");
                    won = true;
                    break;
                }
            }
        }
    }
}
