import java.awt.*;

public class Frame {

    public Frame(){
    }
    public void paint(Graphics graphics){
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(Def.FRAME_START, Def.FRAME_START, Def.WIDTH, Def.FRAME_THICKNESS + Def.FRAME_THICKNESS);
        graphics.fillRect(Def.FRAME_START, Def.FRAME_START, Def.FRAME_THICKNESS, Def.HEIGHT);
        graphics.fillRect(Def.FRAME_START,Def.HEIGHT-Def.FRAME_THICKNESS, Def.WIDTH, Def.FRAME_THICKNESS);
        graphics.fillRect(Def.WIDTH-Def.FRAME_THICKNESS, Def.FRAME_START, Def.FRAME_THICKNESS,Def.HEIGHT);
    }

}
