import java.awt.*;

public class Body extends Dice {

    public Body(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }

}
