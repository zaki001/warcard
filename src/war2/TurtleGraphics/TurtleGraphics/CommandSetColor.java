package war2.TurtleGraphics.TurtleGraphics;

import java.awt.Color;
import java.awt.Graphics2D;

public class CommandSetColor extends Command {

   private Color color;

   public CommandSetColor(Color c){
      color = c;
   }

   @Override
public void doCommand(Graphics2D g, int width, int height){
      g.setColor(color);
   }
}
