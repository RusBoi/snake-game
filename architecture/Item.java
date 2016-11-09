package architecture;

import models.Snake;

public abstract class Item {
    private Point location;

    public Item(int x, int y) {
        location = new Point(x, y);
    }

    public Item(Point location) {
        this.location = location.clone();
    }

    public int getX() {
        return location.x;
    }

    public int getY() {
        return location.y;
    }

    public abstract void effectOnSnake(Snake snake);
}
