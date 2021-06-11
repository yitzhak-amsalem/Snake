import java.awt.*;
import java.util.Random;

public class Apple extends Dice {

    public Apple(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void createNewApple(Body[] body){
        Random random = new Random();
        int randomX = random.nextInt(Def.LIMIT_RANDOM_X) + Def.MORE_THAN_RANDOM_X;
        int randomY = random.nextInt(Def.LIMIT_RANDOM_Y) + Def.MORE_THAN_RANDOM_Y;
        while (isBusyCell(body, randomX, randomY)) {
            randomX = random.nextInt(Def.LIMIT_RANDOM_X) + Def.MORE_THAN_RANDOM_X;
            randomY = random.nextInt(Def.LIMIT_RANDOM_Y) + Def.MORE_THAN_RANDOM_Y;
        }
        setX(randomX * Def.SNAKE_STEP);
        setY(randomY * Def.SNAKE_STEP);
    }

    public boolean isBusyCell(Body[] body, int randomX, int randomY){
        for (int i = 0 ; i < body.length; i++) {
            if (randomX * Def.SNAKE_STEP == body[i].getX() && randomY * Def.SNAKE_STEP == body[i].getY()) {
                return true;
            }
        }
        return false;
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }

}
