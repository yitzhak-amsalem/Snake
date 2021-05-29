import java.awt.*;

public class Head {
    private int x;
    private int y;
    private int width;
    private int height;

    public Head(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public void paint(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(this.x, this.y, this.width, this.height);
    }


//    public void move(int direction) {
//        switch (direction) {
//            case Def.DIRECTION_RIGHT:
//                this.x++;
//                break;
//            case Def.DIRECTION_LEFT:
//                if (this.head.getX() - Def.SNAKE_HEIGHT == this.x && this.head.getY() == this.y) {
//                    this.x--;
//                }
//                break;
//            case Def.DIRECTION_UP:
//                this.y--;
//                break;
//            case Def.DIRECTION_DOWN:
//                this.y++;
//                break;
//        }
//    }

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
}