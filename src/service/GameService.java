package service;

import model.*;
import view.ConsoleView;
import java.util.*;

public class GameService {
    private List<Player> players;
    private Board board;
    private Dice dice;
    private final ConsoleView view = new ConsoleView();
    private final Scanner sc = new Scanner(System.in);

    public void initializeGame() {
        view.showTitle();
        int mode = view.chooseGameMode();

        players = new ArrayList<>();
        int numPlayers = (mode == 1) ? 2 : 0;
        if (mode == 2) {
            numPlayers = view.askForPlayerCount();
        }

        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(view.askForPlayerName(i + 1)));
        }

        int size = view.askBoardSize();
        board = new Board(size);
        dice = new Dice();

        view.showBoardDetails(board);
    }

    public void play() {
        boolean won = false;
        while (!won) {
            for (Player player : players) {
                while (!view.isPlayerReady(player.getName())) {
                    // keep asking until ready
                }
                int roll = dice.roll();
                view.showDiceRoll(player.getName(), roll);
                player.move(roll, board);
                view.showPlayerPosition(player);
                if (player.getPosition() >= board.getSize() * board.getSize()) {
                    view.showWinner(player.getName());
                    won = true;
                    break;
                }
            }
        }
    }
}