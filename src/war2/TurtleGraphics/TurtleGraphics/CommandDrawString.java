package war2.TurtleGraphics.TurtleGraphics;

import java.awt.Graphics2D;

public class CommandDrawString extends Command {

   private String str;
   private double x1, x2;

   public CommandDrawString(String s, double y1, double y2){
      str = s;
      this.x1 = y1;
      this.x2 = y2;
    }

   @Override
public void doCommand(Graphics2D g, int width, int height){
      g.drawString(str, round(adjustX(x1, width)), round(adjustY(x2, height)));
   }
}
