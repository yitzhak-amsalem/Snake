import java.awt.*;

public class Snake {
    private Head head;
    private Body[] body;
    private String side;


    public Snake() {
        this.head = new Head(Def.SNAKE_START_X, Def.SNAKE_START_Y,
                Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT) ;
        this.body = new Body[10];
        for (int i = 1; i <= this.body.length; i++) {
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
            for (int i = this.body.length - 1; i > 0; i--) {
                this.body[i].setX(this.body[i - 1].getX());
                this.body[i].setY(this.body[i - 1].getY());
            }
            this.body[0].setX(this.head.getX());
            this.body[0].setY(this.head.getY());
            moveHead(direction);
    }

    public int calculateMoveHead (int direction) {
        int nextStep = 0;
        switch (direction) {
            case Def.DIRECTION_RIGHT:
                return this.head.getX() + 20;
            case Def.DIRECTION_LEFT:
                return this.head.getX() - 20;
            case Def.DIRECTION_UP:
                return this.head.getY() - 20;
            case Def.DIRECTION_DOWN:
                return this.head.getY() + 20;
        }
        return nextStep;
    }

//    public boolean goBackRight(Head head, Body currentBody){
//        return !(head.getX() + Def.SNAKE_HEIGHT == currentBody.getX() && head.getY() == currentBody.getY());
//    }
//    public boolean goBackLeft(Head head, Body currentBody){
//        return !(this.head.getX() - Def.SNAKE_HEIGHT == currentBody.getX() && this.head.getY() == currentBody.getY());
//    }
//    public boolean goBackUp(Head head, Body currentBody){
//        return !(this.head.getX() == currentBody.getX() && this.head.getY() == currentBody.getY() + Def.SNAKE_HEIGHT);
//    }
//    public boolean goBackDown(Head head, Body currentBody){
//        return !(this.head.getX() + Def.SNAKE_HEIGHT == currentBody.getX() && this.head.getY() == currentBody.getY());
//    }

    public void moveHead (int direction) {
        switch (direction) {
            case Def.DIRECTION_RIGHT:
                if (this.head.getX() + Def.SNAKE_HEIGHT == this.body[0].getX() && this.head.getY() == this.body[0].getY()) {
                    break;
                } else {
                    this.head.setX(this.head.getX() + 20);
                }
                break;
            case Def.DIRECTION_LEFT:
                if (this.head.getX() - Def.SNAKE_HEIGHT == this.body[0].getX() && this.head.getY() == this.body[0].getY()) {
                    break;
                } else {
                    this.head.setX(this.head.getX() - 20);
                }
                break;
            case Def.DIRECTION_UP:
                if (this.head.getX() == this.body[0].getX() && this.head.getY() == this.body[0].getY() + Def.SNAKE_HEIGHT) {
                    break;
                } else {
                    this.head.setY(this.head.getY() - 20);
                }
                break;
            case Def.DIRECTION_DOWN:
                if (this.head.getX() == this.body[0].getX() && this.head.getY() + Def.SNAKE_HEIGHT == this.body[0].getY()) {
                    break;
                } else {
                    this.head.setY(this.head.getY() + 20);
                }
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

