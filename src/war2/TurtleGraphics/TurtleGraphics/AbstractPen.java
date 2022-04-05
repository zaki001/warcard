package war2.TurtleGraphics.TurtleGraphics;

import java.awt.Color;

abstract public class AbstractPen implements Pen {

   // Instance variables ------------------------

   protected double xPos, yPos,direction;
   protected int width;
   protected boolean isDown;
   protected Color color;
   protected SketchPad pad;


   // Public methods ----------------------------

   @Override
public void down(){
      isDown = true;
   }

   abstract protected void drawLine (double x, double y);

   @Override
abstract public void drawString (String text);
   @Override
public void home () {
      xPos = 0;
      yPos = 0;
      direction = 90.0;
   }
   protected void initialize (SketchPad p){
      pad = p;
      isDown = true;
      color = Color.blue;
      width = 2;
      home();
   }
   public boolean isDown(){
      return isDown;
   }

   @Override
public void move (double distance) {
      drawLine (xDestination (distance), yDestination (distance));
   }

   @Override
public void move (double x, double y){
      turn(x, y);
      drawLine (x, y);
   }
   @Override
public void setColor (Color c) {
      color = c;
   }
   @Override
public void setDirection(double d){
      direction = d % 360.0;
   }
   public void setPosition (double xPosition, double yPosition) {
	      xPos = xPosition;
	      yPos = yPosition;
	      direction = 90.0;
   }

   public void setPosition (double xPosition, double yPosition, double xDirection) {
	      xPos = xPosition;
	      yPos = yPosition;
	      direction = xDirection;
}

   @Override
public void setWidth(int w){
      if (w < 1) {
		throw new RuntimeException
                   ("Width " + w + " is invalid -- must be >= 1");
	}
      width = w;
   }

   @Override
public String toString () {
      return
            "Position: "  + xPos + ", " + yPos + " " +
            "\nColor: "     + color + " "  +
            "\nWidth: "     + width + " " +
            "\nIs down: "   + isDown + " "  +
            "\nDirection: " + direction;
   }

   @Override
public void turn (double degrees) {
      direction = (direction + degrees) % 360.0;
   }

   protected void turn (double x, double y){
      if ((xPos == x) && (yPos == y)) {
		return;
	}
      double deltaX = x - xPos;
      double deltaY = y - yPos;
      double distance = Math.sqrt ((deltaX * deltaX) + (deltaY * deltaY));
      direction = Math.toDegrees (Math.asin(Math.abs(deltaY) / distance));
      if (deltaY < 0) {
		direction = - direction;
	}
      if (deltaX < 0) {
		direction = 180.0 - direction;
	}
   }

   // Private and protected methods -------------------------

   @Override
public void up () {
      isDown = false;
   }

   private double xDestination (double distance){
      return xPos + (distance * Math.cos(Math.toRadians (direction)));
   }

   public double xPos(){
	      return xPos;
	   }

   private double yDestination (double distance){
      return yPos + (distance * Math.sin(Math.toRadians (direction)));
   }

   public double yPos(){
	      return yPos;
	   }
}
