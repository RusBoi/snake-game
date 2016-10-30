package architecture;


public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEquals(Point p) {
        return (p.x == x) && (p.y == y);
    }

    public String toString() {
        return String.format("x=%1$s y=%2$s", x, y);
    }
}
