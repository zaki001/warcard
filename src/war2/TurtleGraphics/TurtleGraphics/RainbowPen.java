package war2.TurtleGraphics.TurtleGraphics;

import java.awt.Color;
import java.util.Random;

public class RainbowPen extends StandardPen {

   Random random = new Random();;

   public RainbowPen(){
      super();
   }

   public RainbowPen(SketchPad pad){
     super(pad);
   }

   public RainbowPen(SketchPadWindow win){
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
