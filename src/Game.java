import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Game extends JFrame implements Paintable {
    private GameScene player;
    private int idScene;

    public static void main(String[] args) {
        Game game = new Game();
    }

    public Game(){
        this.player = new GameScene();
        this.init();
        this.setupButtons();
    }

    public void setupButtons(){
        JButton easyBtn = new JButton("Easy");
        easyBtn.setBounds(390,290,100,20);
        JButton hardBtn = new JButton("Hard");
        hardBtn.setBounds(510,290,100,20);
        easyBtn.addActionListener((e -> {
            this.setIdScene(Def.GAME_START);
            this.startGame(true,easyBtn,hardBtn);
        }));
        this.add(easyBtn);

        hardBtn.addActionListener((e -> {
            this.setIdScene(Def.GAME_START);
            this.startGame(false,easyBtn,hardBtn);
        }));
        this.add(hardBtn);

    }

    public void startGame(boolean easy,JButton easyBtn,JButton hardBtn){
        this.requestFocus();
        this.remove(easyBtn);
        this.remove(hardBtn);
        this.player.setEasy(easy);
        PlayerMovement playerMovement = new PlayerMovement(this.player);
        this.addKeyListener(playerMovement);
        this.mainGameLoop(playerMovement);
    }

    public void mainGameLoop (PlayerMovement playerMovement) {
        new Thread(() -> {
            while (this.getIdScene()>0) {
                if (!this.player.isRun()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.setIdScene(Def.GAME_OVER);
                    repaint();
                    break;
                }
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

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
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
        switch (this.idScene){
            case Def.PRE_GAME:
                graphics.drawString("SNAKE",475, 100);
                graphics.drawString("Navigate with the arrows on the keyboard and eat the apples,", 350,200);
                graphics.drawString("The game has 2 levels:", 350,220);
                graphics.drawString("'Easy level': You can go through the walls", 350,240);
                graphics.drawString("'Hard level': Be careful not to collide with walls", 350,260);
                graphics.drawString("Select the desired game level", 350,280);
                break;
            case Def.GAME_START:
                paintFrame(graphics);
                this.player.getSnake().paint(graphics);
                this.player.getApple().paint(graphics);
                graphics.drawString("SCORE:" + this.player.getPoints(),920,55);
                break;
            case Def.GAME_OVER:
                graphics.drawString("--GAME OVER--",450,280);
                graphics.drawString("YOUR SCORE IS: " + this.player.getPoints(),450,320);
                break;
        }

    }

    public void paintFrame(Graphics graphics){
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(Def.FRAME_START, Def.FRAME_START, Def.WIDTH, Def.FRAME_UP_THICKNESS);
        graphics.fillRect(Def.FRAME_START, Def.FRAME_START, Def.FRAME_THICKNESS, Def.HEIGHT);
        graphics.fillRect(Def.FRAME_START,Def.HEIGHT-Def.FRAME_THICKNESS, Def.WIDTH, Def.FRAME_THICKNESS);
        graphics.fillRect(Def.WIDTH-Def.FRAME_THICKNESS, Def.FRAME_START, Def.FRAME_THICKNESS,Def.HEIGHT);
    }

    public GameScene getPlayer() {
        return player;
    }

    public void setPlayer(GameScene player) {
        this.player = player;
    }

    public int getIdScene() {
        return idScene;
    }

    public void setIdScene(int idScene) {
        this.idScene = idScene;
    }
}
