import java.awt.*;
import java.util.Random;

public class Snake {
    private Head head;
    private Body[] body;
    private Boolean run;
    private Frame frame;
    private Apple apple;

    public Snake() {
        this.head = new Head(Def.SNAKE_START_X, Def.SNAKE_START_Y,
                Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT) ;
        this.body = new Body[15];
        for (int i = 1; i <= this.body.length; i++) {
            this.body[i-1] = new Body(Def.SNAKE_START_X - i * Def.SNAKE_HEIGHT, Def.SNAKE_START_Y,
                    Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT);
        }
        this.apple = new Apple(80,80, Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT);
        this.run = true;
    }

    public void paint(Graphics graphics){
        this.head.paint(graphics);
        for (int i = 0; i<this.body.length; i++) {
            this.body[i].paint(graphics);
        }

    }

    public void move (int direction) {
        apple.createApple();

        for (int i = this.body.length - 1; i > 0; i--) {
            this.body[i].setX(this.body[i - 1].getX());
            this.body[i].setY(this.body[i - 1].getY());
        }
        this.body[0].setX(this.head.getX());
        this.body[0].setY(this.head.getY());
        moveHead(direction);
        this.apple.setNewApple(isApple());
        setRun(checkStopRun());
        if (isApple()){
            addBody(this.body);
        }

    }
    public void addBody (Body[] body) {
        Body[] newBody = new Body[this.body.length+1];
        for (int i = 0; i<this.body.length; i++){
            newBody[i] = this.body[i];
        }
        newBody[this.body.length] = new Body(this.body[this.body.length-1].getX(), this.body[this.body.length-1].getY(),
                Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT);
        this.body = newBody;
    }

    public boolean isApple(){
        if (this.head.getX() == this.apple.getX() && this.head.getY() == this.apple.getY() ) {
            return true;
        }
        return false;
    }

    public boolean checkStopRun(){
        for (int i = this.body.length - 1; i >= 0; i--) {
            if (this.head.getX() == this.body[i].getX() && this.head.getY() == this.body[i].getY()) {
                return false;
            }
        }
        if (this.head.getX() == Def.FRAME_START+Def.FRAME_THICKNESS || this.head.getY() == Def.FRAME_START+Def.FRAME_THICKNESS
            || this.head.getX() == Def.WIDTH-Def.FRAME_THICKNESS || this.head.getY() == Def.HEIGHT-Def.FRAME_THICKNESS ) {
            return false;
        }
        return true;
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

    public Boolean getRun() {
        return run;
    }

    public void setRun(Boolean run) {
        this.run = run;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }
}

