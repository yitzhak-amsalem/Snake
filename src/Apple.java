import java.awt.*;
import java.util.Random;

public class Apple extends Dice{
    private Random random;


    public Apple(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
