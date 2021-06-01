import java.awt.*;
import java.util.Random;

public class Apple{
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean newApple;

    public Apple(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.newApple = true;
    }

    public void createApple(){
        if (isNewApple()) {
            Random random = new Random();
            int randomX = random.nextInt(48) + 1;
            int randomY = random.nextInt(27) + 2;
            setX(randomX*20);
            setY(randomY*20);
        }
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(this.x, this.y, this.width, this.height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isNewApple() {
        return newApple;
    }

    public void setNewApple(boolean newApple) {
        this.newApple = newApple;
    }
}
