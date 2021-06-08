import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Game extends JFrame implements Paintable {
    private GameScene player;

    public static void main(String[] args) {
        Game game = new Game();

    }

    public Game(){
        this.player = new GameScene();
        this.init();
        JLabel score1 = new JLabel();
        PlayerMovement playerMovement = new PlayerMovement(this.player);
        this.addKeyListener(playerMovement);
        this.mainGameLoop(playerMovement, score1);

//        boolean level = false;
//        this.player.setEasy(level);

    }

    public void mainGameLoop (PlayerMovement playerMovement, JLabel score1) {
        new Thread(() -> {
            while (this.player.isRun()) {
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
                    Thread.sleep(Def.GAME_SPEED);


                    score1.setLayout(null);
                    score1.setText("SCORE:" + this.player.getPoints());
                    score1.setBounds(900, 10, 100, 20);
                    this.add(score1);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!this.player.isRun()){
                score1.setLayout(null);
                score1.setText("YOUR SCORE IS:" + this.player.getPoints());
                score1.setBounds(500, 300, 100, 20);
                this.add(score1);
            }

        }).start();

    }


    public void init(){
        this.setVisible(true);
        this.setSize(Def.WIDTH, Def.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setTitle("Snake");

    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        paintFrame(graphics);
        this.player.getSnake().paint(graphics);
        this.player.getApple().paint(graphics);

    }

    public void paintFrame(Graphics graphics){
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(Def.FRAME_START, Def.FRAME_START, Def.WIDTH, Def.FRAME_UP_THICKNESS);
        graphics.fillRect(Def.FRAME_START, Def.FRAME_START, Def.FRAME_THICKNESS, Def.HEIGHT);
        graphics.fillRect(Def.FRAME_START,Def.HEIGHT-Def.FRAME_THICKNESS, Def.WIDTH, Def.FRAME_THICKNESS);
        graphics.fillRect(Def.WIDTH-Def.FRAME_THICKNESS, Def.FRAME_START, Def.FRAME_THICKNESS,Def.HEIGHT);
    }

}
