import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    //    private Robot robot;
    private Snake player;
    private Frame frame;


    public static void main(String[] args) {
        Game game = new Game();

    }

    public Game(){
        this.init();
        this.player = new Snake();
        this.frame = new Frame();
        PlayerMovement playerMovement = new PlayerMovement(this.player);
        this.addKeyListener(playerMovement);
        this.mainGameLoop();

    }
    public void mainGameLoop () {
        new Thread(() -> {
            while (true) {
                repaint();
                try {
                    Thread.sleep(Def.GAME_SPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    public void init(){
        this.setVisible(true);
        this.setSize(Def.WIDTH, Def.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // פריסה על החלון, ברירת מחדל היא משמאל לימין, ריק הוא הגדרה עצמאית
        this.setLocationRelativeTo(null); // מרכז מסך
        this.setResizable(false); // אי אפשר להגדיל
        this.setTitle("Snake");


    }
    public void paint(Graphics graphics){
        super.paint(graphics);
        this.player.paint(graphics);
        this.frame.paint(graphics);
    }


}
