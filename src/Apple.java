import java.awt.*;
import java.util.Random;

public class Apple extends Dice implements Paintable{
    private boolean newApple;

    public Apple(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.newApple = true;
    }

    public void createApple(Body[] body){
        Random random = new Random();
        boolean equals = false;
        int randomX;
        int randomY;
        if (isNewApple()) {
            do {
                randomX = random.nextInt(Def.LIMIT_RANDOM_X) + Def.MORE_THAN_RANDOM_X;
                randomY = random.nextInt(Def.LIMIT_RANDOM_Y) + Def.MORE_THAN_RANDOM_Y;
                for (int i = 0 ; i < body.length; i++) {
                    if (randomX == body[i].getX() && randomY == body[i].getY()) {
                        equals = true;
                        break;
                    }
                    else equals = false;
                }
            } while (equals);
            setX(randomX*Def.SNAKE_STEP);
            setY(randomY*Def.SNAKE_STEP);
        }
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }

    public boolean isNewApple() {
        return newApple;
    }

    public void setNewApple(boolean newApple) {
        this.newApple = newApple;
    }
}
