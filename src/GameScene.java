import javax.swing.*;

public class GameScene {
    private boolean run;
    private boolean easy;
    private Apple apple;
    private Snake snake;
    private int points;

    public GameScene() {
        this.run = true;
        this.apple = new Apple(Def.APPLE_START_X_Y,Def.APPLE_START_X_Y, Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT);
        this.snake = new Snake();
        this.points = 0;
    }

    public void move (int direction) {
        for (int i = this.snake.getBody().length - 1; i > 0; i--) {
            this.snake.getBody()[i].setX(this.snake.getBody()[i - 1].getX());
            this.snake.getBody()[i].setY(this.snake.getBody()[i - 1].getY());
        }
        this.snake.getBody()[0].setX(this.snake.getHead().getX());
        this.snake.getBody()[0].setY(this.snake.getHead().getY());
        moveHead(direction);
        if (easy) {
            withoutWalls();
            setRun(checkStopRunByBody());
        }
        else {
            setRun(checkStopRunByBody() && checkStopByFrame());
        }
        if (isApple()) {
            this.apple.createNewApple(this.snake.getBody());
            setPoints(getPoints()+1);
            addBody();
        }
    }

    public void moveHead (int direction) {
        switch (direction) {
            case Def.DIRECTION_RIGHT:
                this.snake.getHead().setX(this.snake.getHead().getX() + Def.SNAKE_STEP);
                break;
            case Def.DIRECTION_LEFT:
                this.snake.getHead().setX(this.snake.getHead().getX() - Def.SNAKE_STEP);
                break;
            case Def.DIRECTION_UP:
                this.snake.getHead().setY(this.snake.getHead().getY() - Def.SNAKE_STEP);
                break;
            case Def.DIRECTION_DOWN:
                this.snake.getHead().setY(this.snake.getHead().getY() + Def.SNAKE_STEP);
                break;
        }
    }

    public void addBody () {
        Body[] newBody = new Body[this.snake.getBody().length+1];
        for (int i = 0; i<this.snake.getBody().length; i++){
            newBody[i] = this.snake.getBody()[i];
        }
        newBody[this.snake.getBody().length] = new Body(this.snake.getBody()[this.snake.getBody().length-1].getX(),
                this.snake.getBody()[this.snake.getBody().length-1].getY(),
                Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT);
        this.snake.setBody(newBody);
    }

    public boolean isApple(){
        if (this.snake.getHead().getX() == this.apple.getX() && this.snake.getHead().getY() == this.apple.getY() ) {
            return true;
        }
        return false;
    }

    public boolean checkStopRunByBody(){
        for (int i = this.snake.getBody().length - 1; i >= 0; i--) {
            if (this.snake.getHead().getX() == this.snake.getBody()[i].getX()
                    && this.snake.getHead().getY() == this.snake.getBody()[i].getY()) {
//                this.snake.getHead().setX(this.snake.getBody()[0].getX());
//                this.snake.getHead().setY(this.snake.getBody()[0].getY());
                return false;
            }
        }
        return true;
    }
    public boolean checkStopByFrame (){
        if (this.snake.getHead().getX() == Def.FRAME_START
                || this.snake.getHead().getY() == Def.FRAME_START+Def.FRAME_THICKNESS
                || this.snake.getHead().getX() == Def.WIDTH-Def.FRAME_THICKNESS
                || this.snake.getHead().getY() == Def.HEIGHT-Def.FRAME_THICKNESS ) {
            return false;
        }
        return true;
    }
    public void withoutWalls (){
        if (this.snake.getHead().getX() <= Def.FRAME_START) {
            this.snake.getHead().setX(Def.WIDTH - Def.FRAME_UP_THICKNESS);
        }
        if (this.snake.getHead().getX() >= Def.WIDTH - Def.FRAME_THICKNESS) {
            this.snake.getHead().setX(Def.FRAME_START + Def.FRAME_THICKNESS);
        }
        if (this.snake.getHead().getY() <= Def.FRAME_START + Def.FRAME_THICKNESS) {
            this.snake.getHead().setY(Def.HEIGHT - Def.FRAME_UP_THICKNESS);
        }
        if (this.snake.getHead().getY() >= Def.HEIGHT - Def.FRAME_THICKNESS){
            this.snake.getHead().setY(Def.FRAME_START + Def.FRAME_UP_THICKNESS);
        }
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public boolean isEasy() {
        return easy;
    }

    public void setEasy(boolean easy) {
        this.easy = easy;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

