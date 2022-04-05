package war2.TurtleGraphics.TurtleGraphics;

import java.awt.Graphics2D;

abstract public class Command {

   protected double adjustX(double x, int width){
      return (x + (width /2.0));

   }

// Protected methods -------------------------------

   protected double adjustY(double y, int height){
      return ((height / 2.0) - y);
   }

   abstract public void doCommand(Graphics2D g, int width, int height);

   protected int round (double x) {
      if (x >= 0.0) {
		return (int)(0.5 + x);
	} else {
		return -(int)(0.5 - x);
	}
   }


}
