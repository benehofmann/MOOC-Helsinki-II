package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Worm worm;
    private Updatable updatable;
    private Apple apple;
    private Random generator;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        worm = new Worm(width / 2, height / 2, Direction.DOWN);
        this.generator = new Random();

        apple = new Apple(generator.nextInt(this.width), generator.nextInt(this.width));

        while (worm.runsInto(apple)) {
            this.apple = new Apple(generator.nextInt(this.width), generator.nextInt(this.width));
        }

        addActionListener(this);
        setInitialDelay(2000);

    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (!continues) {

            return;

        }

        this.worm.move();

        if (this.worm.runsInto(this.apple)) {

            this.worm.grow();

            while (true) {

                this.apple.setNewXY(this.generator.nextInt(this.width - 1) + 1, this.generator.nextInt(this.height - 1) + 1);

                if (!this.worm.runsInto(apple)) {

                    break;

                }

            }

        }

        if (this.worm.runsIntoItself()) {

            this.continues = false;

        }

        for (Piece p : worm.getPieces()) { //worm out of bounds
            if (p.getX() >= this.width || p.getX() <= 0 || p.getY() <= 0 || p.getY() >= this.height) {
                this.continues = false;
            }
        }
        this.updatable.update();
        super.setDelay(1000 / worm.getLength());
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Worm getWorm() {
        return worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

}
