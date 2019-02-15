import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class DrawingComponent extends JComponent
{
   private final int STROKE_WIDTH = 5; 
   
   private int xLeft;
   private int yTop;

   public DrawingComponent()
   {
      xLeft = 30;
      yTop = 30;
   }
   
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(STROKE_WIDTH));
      drawPlayStation(g, xLeft, yTop, 400);
   }
   
   void drawPlayStation(Graphics g, int xLeft, int yTop, int width)
   {
      g.setColor(Color.BLUE);
      g.drawLine(xLeft, yTop, xLeft + width/4, yTop + width/4);
      g.drawLine(xLeft, yTop + width/4, xLeft+ width/4, yTop);
      
      g.setColor(Color.RED);
      g.drawOval(xLeft + width/4, yTop, width/4, width/4);
      
      g.setColor(Color.MAGENTA);
      g.drawRect(xLeft + width/2, yTop, width/4, width/4);
      
      g.setColor(Color.GREEN);
      g.drawLine(xLeft + (width/4 * 3), yTop + (width/4), xLeft + width, yTop + (width/4));
      g.drawLine(xLeft + (width/4 * 3), yTop + (width/4), xLeft + (width/8 * 7), yTop);
      g.drawLine(xLeft + (width/8 * 7), yTop, xLeft + width, yTop + (width/4));
      
      // g.setColor(Color.BLACK);
//       g.drawString("x, circle, square, triangle", 50, width/2);
   }
   
   public void moveDrawingTo(int x, int y)
   {
      xLeft = x;
      yTop = y;
      repaint();      
   }
   
   public void moveDrawingBy(int dx, int dy)
   {
      xLeft = xLeft + dx;
      yTop = yTop + dy;
      repaint();
   }
}