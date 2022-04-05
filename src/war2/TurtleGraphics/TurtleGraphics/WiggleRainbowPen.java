package war2.TurtleGraphics.TurtleGraphics;

import java.awt.Color;
import java.util.Random;

public class WiggleRainbowPen extends WigglePen {

   private Random random = new Random();

   public WiggleRainbowPen(){
      super();
   }

   public WiggleRainbowPen(SketchPad pad, int wiggles, double wiggleAngle){
     super(pad, wiggles, wiggleAngle);
  }

   public WiggleRainbowPen(SketchPadWindow win){
      super(win);
   }

   @Override
public void drawString (String str){
      setColor(new Color (random.nextInt (256),
                          random.nextInt (256),
                          random.nextInt (256)));
      super.drawString(str);
   }



   @Override
public void move(double distance){
      setColor(new Color (random.nextInt (256),
                          random.nextInt (256),
                          random.nextInt (256)));
      super.move(distance);
   }

   @Override
public void move(double x, double y){
      setColor(new Color (random.nextInt (256),
                          random.nextInt (256),
                          random.nextInt (256)));
      super.move(x, y);
   }
}
