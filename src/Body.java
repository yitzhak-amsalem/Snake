import java.awt.*;

public class Body {
    private int x;
    private int y;
    private int width;
    private int height;
    private Head head;

    public Body(int x, int y, int width, int height, Head head) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.head = head;
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.GREEN);
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

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public void move(int direction) {
        switch (direction) {
            case Def.DIRECTION_RIGHT:
                if (this.head.getX() > this.x && this.head.getY() == this.y){
                    this.x++;
                }
                if (this.head.getY() < this.y && this.head.getX() <= this.x + Def.SNAKE_HEIGHT){    //מלמטה למעלה
                    this.y--;
                }
                if (this.head.getY() > this.y && this.head.getX() <= this.x + Def.SNAKE_HEIGHT){   //מלמעלה למטה
                    this.y++;
                }
//                if (this.head.getX() - Def.SNAKE_HEIGHT == this.x && this.head.getY() == this.y) {
//                    break;
//                }
                break;
            case Def.DIRECTION_LEFT:
                if (this.head.getX() < this.x && this.head.getY() == this.y){
                    this.x--;
                }
                if (this.head.getY() < this.y && this.head.getX() <= this.x + Def.SNAKE_HEIGHT){    //מלמטה למעלה
                    this.y--;
                }
                if (this.head.getY() > this.y && this.head.getX() <= this.x + Def.SNAKE_HEIGHT){   //מלמעלה למטה
                    this.y++;
                }
//                if (this.head.getX() == this.x - Def.SNAKE_HEIGHT && this.head.getY() == this.y) {
//                    break;
//                }
                break;
            case Def.DIRECTION_UP:
                if (this.head.getY() < this.y && this.head.getX() == this.x){
                    this.y--;
                }
                if (this.head.getX() < this.x && this.head.getY() + Def.SNAKE_HEIGHT >= this.y ){    //מימין לשמאל
                    this.x--;
                }
                if (this.head.getX() > this.x && this.head.getY() + Def.SNAKE_HEIGHT >= this.y){   //משמאל לימין
                    this.x++;
                }
                else break;
                break;
            case Def.DIRECTION_DOWN:
                if (this.head.getY() > this.y && this.head.getX() == this.x){
                    this.y++;
                }
                if (this.head.getX() < this.x && this.head.getY() + Def.SNAKE_HEIGHT >= this.y){    //משמאל לימין
                    this.x--;
                }
                if (this.head.getX() > this.x && this.head.getY() + Def.SNAKE_HEIGHT >= this.y){   //מימין לשמאל
                    this.x++;
                }
                else break;
                break;
        }
    }

}
