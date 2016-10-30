package models;

import architecture.Item;
import architecture.Point;

public class SnakePart
        extends Item
{
    public SnakePart next;
    public SnakePart previous;

    public SnakePart(int x, int y) {
        super(x, y);
    }

    public SnakePart(Point location) {
        super(location);
    }

    public void effectOnSnake(Snake snake) {

    }
}
