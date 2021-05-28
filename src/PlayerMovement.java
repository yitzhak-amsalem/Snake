import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMovement implements KeyListener {
    private Snake player;

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
                this.player.move(Def.DIRECTION_RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                this.player.move(Def.DIRECTION_LEFT);
                break;
            case KeyEvent.VK_UP:
                this.player.move(Def.DIRECTION_UP);
                break;
            case KeyEvent.VK_DOWN:
                this.player.move(Def.DIRECTION_DOWN);
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
