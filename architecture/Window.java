package architecture;

import models.SnakePart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Window
        extends JFrame implements ActionListener
{
    private Game game;
    private final int cellWidth = 30;
    private final int cellHeight = 30;
    private int mapWidth;
    private int mapHeight;

    private int counter = 0;
    Timer timer = new Timer(3, this);

    public Window() {
        super("Snake");
        game = new Game();
        mapWidth = game.currentMap.getWidth();
        mapHeight = game.currentMap.getHeight();
        addKeyListener(new Keyboard());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255, 255, 255));
        g2d.fillRect(0, 0, cellWidth * mapWidth, cellHeight * mapHeight);

        g2d.setColor(new Color(212, 3, 7));
        for(SnakePart s : game.getSnakeBody()) {
            int x = s.getX() * cellWidth;
            int y = s.getY() * cellHeight;
            g2d.fillRect(x, y, cellWidth, cellHeight);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (counter == 0)
            game.makeMove();
        repaint();
        counter = (counter + 1) % 10;
    }

    private class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent keyevent){
            int key = keyevent.getKeyCode();
            if(key == KeyEvent.VK_RIGHT)
                game.changeSnakeDirection(Direction.RIGHT);
            if(key == KeyEvent.VK_LEFT)
                game.changeSnakeDirection(Direction.LEFT);
            if(key == KeyEvent.VK_UP)
                game.changeSnakeDirection(Direction.UP);
            if(key == KeyEvent.VK_DOWN)
                game.changeSnakeDirection(Direction.DOWN);
        }
    }
}
