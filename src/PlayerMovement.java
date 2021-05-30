import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMovement implements KeyListener {
    private Snake player;
    private int direction;

    public PlayerMovement(int direction) {
        this.direction = 0;
    }

    public PlayerMovement(Snake player){
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                if (getDirection() != Def.DIRECTION_LEFT){
                    setDirection(Def.DIRECTION_RIGHT);
                    this.player.move(direction);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (getDirection() != Def.DIRECTION_RIGHT){
                    setDirection(Def.DIRECTION_LEFT);
                    this.player.move(direction);
                }
                break;
            case KeyEvent.VK_UP:
                if (getDirection() != Def.DIRECTION_DOWN) {
                    setDirection(Def.DIRECTION_UP);
                    this.player.move(direction);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (getDirection() != Def.DIRECTION_UP) {
                    setDirection(Def.DIRECTION_DOWN);
                    this.player.move(direction);
                }
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
