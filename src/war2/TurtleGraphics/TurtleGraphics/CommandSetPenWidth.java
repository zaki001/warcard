package war2.TurtleGraphics.TurtleGraphics;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class CommandSetPenWidth extends Command {

   private int penWidth;

   public CommandSetPenWidth(int w){
      penWidth = w;
   }

   @Override
public void doCommand(Graphics2D g, int width, int height){
      g.setStroke(new BasicStroke(penWidth));
   }
}
