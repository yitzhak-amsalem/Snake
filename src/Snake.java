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
        this.head.move(direction);
        for (int i = 0; i<this.body.length; i++) {
            this.body[i].move(direction);
        }

    }
//    public void moveBody (int direction) {
//        switch (direction) {
//            case Def.DIRECTION_RIGHT:
//                if (Head.)
//                    this.x+=5;
//                break;
//            case Def.DIRECTION_LEFT:
//                this.x-=5;
//                break;
//            case Def.DIRECTION_UP:
//                this.y-=5;
//                break;
//            case Def.DIRECTION_DOWN:
//                this.y+=5;
//                break;
//        }
//    }


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
