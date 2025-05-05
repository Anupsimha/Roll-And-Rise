package view;

import model.*;
import java.util.*;

public class ConsoleView {
    private final Scanner sc = new Scanner(System.in);

    public void showTitle() {
        System.out.println("\n\t\t\tRoll And Rise : Snake and Ladder Game\n");
    }

    public int chooseGameMode() {
        System.out.println("Choose Game Mode:\n1. 1v1\n2. Multiplayer\n3. Vs Online (Coming Soon)");
        return sc.nextInt();
    }

    public int askForPlayerCount() {
        System.out.print("Enter number of players: ");
        return sc.nextInt();
    }

    public String askForPlayerName(int number) {
        sc.nextLine();
        System.out.print("Enter Player " + number + " name: ");
        return sc.nextLine();
    }

    public int askBoardSize() {
        sc.nextLine();
        System.out.print("Choose Board Size (Default is 10): ");
        String input = sc.nextLine();
        if (input.trim().isEmpty()) {
            System.out.println("Using default board size 10x10.");
            return 10;
        }
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Invalid input. Using default.");
            return 10;
        }
    }

    public void showBoardDetails(Board board) {
        System.out.println("\nBoard Initialized: " + board.getSize() + "x" + board.getSize());
        board.printBoard();

        System.out.println("\nSnakes:");
        for (Snake s : board.getSnakes()) {
            System.out.println("From: " + s.start + " To: " + s.end);
        }

        System.out.println("\nLadders:");
        for (Ladder l : board.getLadders()) {
            System.out.println("From: " + l.start + " To: " + l.end);
        }
    }

    public boolean isPlayerReady(String name) {
        System.out.print("\n" + name + ", are you ready? (Y/N): ");
        return sc.nextLine().equalsIgnoreCase("Y");
    }

    public void showDiceRoll(String name, int roll) {
        System.out.println(name + " rolled a " + roll);
    }

    public void showPlayerPosition(Player player) {
        System.out.println(player.getName() + " is at position: " + player.getPosition());
    }

    public void showWinner(String name) {
        System.out.println(name + " wins the game! 🏆");
    }
}
