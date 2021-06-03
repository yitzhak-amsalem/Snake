import java.awt.*;

public class Head extends Dice implements Paintable{

    public Head(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }

}