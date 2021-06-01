import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Game extends JFrame {
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
        this.mainGameLoop(playerMovement);

    }
    public void mainGameLoop (PlayerMovement playerMovement) {
        new Thread(() -> {
            while (this.player.getRun()) {
                repaint();
                try {
                    if (playerMovement.getDirection() == Def.DIRECTION_RIGHT) {
                        this.player.move(playerMovement.getDirection());
                    }
                    if (playerMovement.getDirection() == Def.DIRECTION_LEFT) {
                        this.player.move(playerMovement.getDirection());
                    }
                    if (playerMovement.getDirection() == Def.DIRECTION_UP) {
                        this.player.move(playerMovement.getDirection());
                    }
                    if (playerMovement.getDirection() == Def.DIRECTION_DOWN) {
                        this.player.move(playerMovement.getDirection());
                    }
                    Thread.sleep(200);
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
        this.player.getApple().paint(graphics);

    }


}
