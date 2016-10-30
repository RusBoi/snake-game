package models;

import architecture.Item;
import architecture.Point;

public class Apple
        extends Item
{
    public Apple(int x, int y) {
        super(x, y);
    }

    public Apple(Point location) {
        super(location);
    }

    public void effectOnSnake(Snake snake) {

    }
}
