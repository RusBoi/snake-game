package architecture;

import models.Snake;
import models.SnakePart;

import java.util.List;

public class Game {
    public Map currentMap;
    private Snake snake;

    public Game() {
        currentMap = new Map(20, 20);
        snake = new Snake(10, 5, 8, currentMap);
    }

    public void makeMove() {
        snake.move();
    }

    public List<SnakePart> getSnakeBody() {
        return snake.getBody();
    }

    public void changeSnakeDirection(Direction dir) {
        snake.changeDirection(dir);
    }
}
