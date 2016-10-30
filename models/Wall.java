package models;

import architecture.Item;
import architecture.Point;

public class Wall
        extends Item
{
    public Wall(int x, int y) {
        super(x, y);
    }

    public Wall(Point location) {
        super(location);
    }

    public void effectOnSnake(Snake snake) {

    }
}
