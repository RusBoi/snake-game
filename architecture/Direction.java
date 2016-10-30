package architecture;

import java.util.HashMap;

public enum Direction {
    UP, RIGHT, DOWN, LEFT;

    public Direction opposite() {
        switch (this) {
            case UP:
                return Direction.DOWN;
            case DOWN:
                return Direction.UP;
            case LEFT:
                return Direction.RIGHT;
            default:
                return Direction.LEFT;
        }
    }

    public Point getDelta() {
        int dy = 0;
        int dx = 0;

        switch (this) {
            case UP:
                dy = 1;
                break;
            case DOWN:
                dy = -1;
                break;
            case LEFT:
                dx = -1;
                break;
            default:
                dx = 1;
                break;
        }
        return new Point(dx, dy);
    }
}
