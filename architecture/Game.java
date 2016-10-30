package architecture;


import models.Snake;

public class Game {
    private Map currentMap;
    private Snake snake;

    public void makeMove() {
        snake.move();
    }
}
