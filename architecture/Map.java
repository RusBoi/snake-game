package architecture;

import models.SnakePart;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Map {
    private List<SnakePart> objects;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Map generateNewMap(int width, int length) {
        throw new NotImplementedException();
    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public Point validateLocation(Point expectedLocation) {
        int x = (width + expectedLocation.x) % width;
        int y = (height + expectedLocation.y) % height;
        return new Point(x, y);
    }
}
