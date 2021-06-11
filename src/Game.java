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
        easyBtn.setBounds(Def.BUTTON_EASY_X,Def.BUTTONS_Y,Def.BUTTONS_WIDTH,Def.BUTTONS_HEIGHT);
        JButton hardBtn = new JButton("Hard");
        hardBtn.setBounds(Def.BUTTON_HARD_X,Def.BUTTONS_Y,Def.BUTTONS_WIDTH,Def.BUTTONS_HEIGHT);
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
            while (this.getIdScene() > Def.PRE_GAME) {
                if (!this.player.isRun()) {
                    try {
                        Thread.sleep(Def.GAME_OVER_SPEED);
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
                graphics.drawString("SNAKE",Def.TITLE_PRINT_X, Def.TITLE_PRINT_Y);
                graphics.drawString("Navigate with the arrows on the keyboard and eat the apples,", Def.INSTRUCTIONS_PRINT_X, Def.INSTRUCTIONS_PRINT_Y );
                graphics.drawString("The game has 2 levels:",Def.INSTRUCTIONS_PRINT_X, Def.INSTRUCTIONS_PRINT_Y + Def.LINEBREAK_PRINT * Def.FIRST_LINE);
                graphics.drawString("'Easy level': You can go through the walls", Def.INSTRUCTIONS_PRINT_X, Def.INSTRUCTIONS_PRINT_Y + Def.LINEBREAK_PRINT * Def.SECOND_LINE);
                graphics.drawString("'Hard level': Be careful not to collide with walls", Def.INSTRUCTIONS_PRINT_X, Def.INSTRUCTIONS_PRINT_Y + Def.LINEBREAK_PRINT * Def.THIRD_LINE);
                graphics.drawString("Select the desired game level", Def.INSTRUCTIONS_PRINT_X, Def.INSTRUCTIONS_PRINT_Y + Def.LINEBREAK_PRINT * Def.FOURTH_LINE);
                break;
            case Def.GAME_START:
                paintFrame(graphics);
                this.player.getSnake().paint(graphics);
                this.player.getApple().paint(graphics);
                graphics.drawString("SCORE:" + this.player.getPoints(),Def.SCORE_PRINT_X,Def.SCORE_PRINT_Y);
                break;
            case Def.GAME_OVER:
                graphics.drawString("--GAME OVER--",Def.GAME_OVER_PRINT_X,Def.GAME_OVER_PRINT_Y);
                graphics.drawString("YOUR SCORE IS: " + this.player.getPoints(),Def.GAME_OVER_PRINT_X,Def.GAME_OVER_PRINT_Y + Def.LINEBREAK_PRINT);
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
