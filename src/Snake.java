import java.awt.*;

public class Snake implements Paintable{
    private Head head;
    private Body[] body;

    public Snake() {
        this.head = new Head(Def.SNAKE_START_X, Def.SNAKE_START_Y,
                Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT);
        this.body = new Body[Def.SIZE_DEFAULT_BODY];
        for (int i = 1; i <= this.body.length; i++) {
            this.body[i - 1] = new Body(Def.SNAKE_START_X - i * Def.SNAKE_HEIGHT, Def.SNAKE_START_Y,
                    Def.SNAKE_WIDTH, Def.SNAKE_HEIGHT);
        }
    }

    public void paint(Graphics graphics) {
        for (int i = 0; i < this.body.length; i++) {
            this.body[i].paint(graphics);
        }
        this.head.paint(graphics);
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

