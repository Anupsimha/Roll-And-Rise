package controller;

import service.GameService;

public class GameController {
    private final GameService gameService = new GameService();

    public void launch() {
        gameService.initializeGame();
        gameService.play();
    }
}