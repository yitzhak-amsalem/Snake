import java.awt.*;
import java.util.Random;

public class Snake {
    private Head head;
    private Body[] body;

    public Snake() {
        this.head = new Head(Def.SNAKE_START_X, Def.SNAKE_START_Y,
                Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT) ;
        this.body = new Body[10];
        for (int i = 1; i <= this.body.length; i++) {
            this.body[i-1] = new Body(Def.SNAKE_START_X - i * Def.SNAKE_HEIGHT, Def.SNAKE_START_Y,
                    Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT);
        }
    }

    public void paint(Graphics graphics){
        this.head.paint(graphics);
        for (int i = 0; i<this.body.length; i++) {
            this.body[i].paint(graphics);
        }

    }
    public void move (int direction) {
        for (int i = this.body.length - 1; i > 0; i--) {
            this.body[i].setX(this.body[i - 1].getX());
            this.body[i].setY(this.body[i - 1].getY());
        }
        this.body[0].setX(this.head.getX());
        this.body[0].setY(this.head.getY());
        moveHead(direction);
    }

//    public int calculateMoveHead (int direction) {
//        int nextStep = 0;
//        switch (direction) {
//            case Def.DIRECTION_RIGHT:
//                return this.head.getX() + 20;
//            case Def.DIRECTION_LEFT:
//                return this.head.getX() - 20;
//            case Def.DIRECTION_UP:
//                return this.head.getY() - 20;
//            case Def.DIRECTION_DOWN:
//                return this.head.getY() + 20;
//        }
//        return nextStep;
//    }

    public void moveHead (int direction) {
        switch (direction) {
            case Def.DIRECTION_RIGHT:
                    this.head.setX(this.head.getX() + Def.SNAKE_HEIGHT);
                break;
            case Def.DIRECTION_LEFT:
                    this.head.setX(this.head.getX() - Def.SNAKE_HEIGHT);
                break;
            case Def.DIRECTION_UP:
                    this.head.setY(this.head.getY() - Def.SNAKE_HEIGHT);
                break;
            case Def.DIRECTION_DOWN:
                    this.head.setY(this.head.getY() + Def.SNAKE_HEIGHT);
                break;
        }
    }

    public Body[] getBody() {
        return body;
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

