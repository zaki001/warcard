package war2.TurtleGraphics.TurtleGraphics;

public class BackwardPen extends AbstractPen {

   // Constructors ------------------------------

   public BackwardPen(){
      this(new SketchPadWindow(new SketchPad()));
   }

   public BackwardPen (SketchPad p){
      initialize (p);
   }

   public BackwardPen(SketchPadWindow win){
      initialize(win.pad);
   }

   // Public methods ----------------------------

   @Override
protected void drawLine (double x, double y){
      if (isDown){
         pad.setColor (color);
         pad.setPenWidth(width);
         pad.drawLine (-xPos, -yPos, -x, -y, color, width);
      }
      xPos = x;
      yPos = y;
   }

   // Protected methods -------------------------

   @Override
public void drawString (String text) {
      pad.setColor (color);
      pad.drawString(text, -xPos, -yPos, color);
   }
}
