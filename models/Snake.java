package models;

import architecture.Direction;
import architecture.Map;
import architecture.Point;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private Map map;
    private SnakePart head;
    private SnakePart tail;
    private int length;
    private Direction direction;

    public Snake(int x, int y, int length, Map map) {
        assert length > 1 : "Length can't be less than 2";
        head = new SnakePart(x, y);
        tail = head;
        direction = Direction.UP;
        this.length = length;
        this.map = map;

        for(int i = 0; i < length - 1; i++)
            addToTail();
    }

    private void addToTail() {
        Point delta = direction.opposite().getDelta();
        Point expectedLocation = new Point(tail.getX() + delta.x, tail.getY() + delta.y);
        Point nextLocation = map.validateLocation(expectedLocation);

        SnakePart newPart = new SnakePart(nextLocation);
        tail.next = newPart;
        newPart.previous = tail;
        tail = newPart;

        length += 1;
    }

    private void deleteFromTail() {
        tail.previous.next = null;
        tail = tail.previous;
    }

    public void move() {
        Point delta = direction.getDelta();
        Point expectedLocation = new Point(head.getX() + delta.x, head.getY() + delta.y);
        Point nextLocation = map.validateLocation(expectedLocation);

        SnakePart newPart = new SnakePart(nextLocation);
        head.previous = newPart;
        newPart.next = head;
        head = newPart;

        deleteFromTail();
    }

    public List<SnakePart> getBody() {
        SnakePart nowPart = head;
        List<SnakePart> body = new ArrayList<SnakePart>();
        while (nowPart != null) {
            body.add(nowPart);
            nowPart = nowPart.next;
        }
        return body;
    }

    public void changeDirection(Direction dir) {
        if (!(direction.getDelta().x + dir.getDelta().x == 0 && direction.getDelta().y + dir.getDelta().y == 0)) {
            direction = dir;
        }
    }
}
