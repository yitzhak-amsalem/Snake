import javax.swing.*;
import java.awt.*;

public class Print extends JLabel {
    private String instructions;
    private String score;

    public Print(String text) {
        super(text);
        this.setForeground(Color.RED);
    }
}
