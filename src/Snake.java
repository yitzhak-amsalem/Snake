import java.awt.*;

public class Snake {
    private Head head;
    private Body[] body;

    public Snake() {
        this.head = new Head(Def.SNAKE_START_X, Def.SNAKE_START_Y,
                Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT) ;
        this.body = new Body[1];
        for (int i = 1; i<=this.body.length; i++) {
            this.body[i-1] = new Body(Def.SNAKE_START_X - i * Def.SNAKE_HEIGHT, Def.SNAKE_START_Y,
                    Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT, this.head);
        }
    }

    public void paint(Graphics graphics){
        this.head.paint(graphics);
        for (int i = 0; i<this.body.length; i++) {
            this.body[i].paint(graphics);
        }

    }
    public void move (int direction) {
        moveHead(direction);
        for (int i = 0; i<this.body.length; i++) {
            this.body[i].move(direction);
        }

    }
    public void moveHead(int direction) {
        switch (direction) {
            case Def.DIRECTION_RIGHT:
                if (this.head.getX() + Def.SNAKE_HEIGHT == this.body[0].getX() && this.head.getY() == this.body[0].getY()) {
                    break;
                } else this.head.setX(this.head.getX()+20);
                break;
            case Def.DIRECTION_LEFT:
                if (this.head.getX() - Def.SNAKE_HEIGHT == this.body[0].getX() && this.head.getY() == this.body[0].getY()) {
                    break;
                } else this.head.setX(this.head.getX()-20);
                break;
            case Def.DIRECTION_UP:
                if (this.head.getX() == this.body[0].getX() && this.head.getY() == this.body[0].getY() + Def.SNAKE_HEIGHT) {
                    break;
                } else this.head.setY(this.head.getY()-20);
                break;
            case Def.DIRECTION_DOWN:
                if (this.head.getX() == this.body[0].getX() && this.head.getY() + Def.SNAKE_HEIGHT == this.body[0].getY()) {
                    break;
                } else this.head.setY(this.head.getY()+20);
                break;
        }
    }


    public void setBody(Body[] body) {
        this.body = body;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
}
