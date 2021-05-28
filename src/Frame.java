import java.awt.*;

public class Frame {

    public Frame(){
    }
    public void paint(Graphics graphics){
        graphics.setColor(Color.BLUE);
        graphics.fillRect(Def.FRAME_START, Def.FRAME_START, Def.WIDTH, Def.FRAME_UP_THICKNESS);
        graphics.fillRect(Def.FRAME_START, Def.FRAME_START, Def.FRAME_THICKNESS, Def.HEIGHT);
        graphics.fillRect(Def.FRAME_START,Def.HEIGHT-12, Def.WIDTH, Def.FRAME_THICKNESS );
        graphics.fillRect(Def.WIDTH-Def.FRAME_THICKNESS, Def.FRAME_START, Def.FRAME_UP_THICKNESS,Def.HEIGHT);
    }

}
