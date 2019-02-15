import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

import javax.swing.*;
import java.awt.*;


public class DrawingFrame extends JFrame
{
   private static final int FRAME_WIDTH = 600;
   private static final int FRAME_HEIGHT = 300;

   private DrawingComponent scene;

   class MousePressListener implements MouseListener
   {  
      public void mousePressed(MouseEvent event)
      {  
         int x = event.getX();
         int y = event.getY();
         scene.moveDrawingTo(x, y);
      }

      // Do-nothing methods
      public void mouseReleased(MouseEvent event) {}
      public void mouseClicked(MouseEvent event) {}
      public void mouseEntered(MouseEvent event) {}
      public void mouseExited(MouseEvent event) {}
   }

   class KeyStrokeListener implements KeyListener
   {
      public void keyPressed(KeyEvent event) 
      {
         String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", ""); 
         if (key.equals("DOWN"))
         {
            scene.moveDrawingBy(0, 1);            
         }
         else if (key.equals("UP"))
         {
            scene.moveDrawingBy(0, -1);            
         }
         else if (key.equals("LEFT"))
         {
            scene.moveDrawingBy(-1, 0);            
         }
         else if (key.equals("RIGHT"))
         {
            scene.moveDrawingBy(1, 0);            
         }
      }
      public void keyTyped(KeyEvent event) {}
      public void keyReleased(KeyEvent event) {}
   }
   
   public DrawingFrame()
   {
      scene = new DrawingComponent();
      add(scene);
      
      getContentPane().setBackground(Color.BLACK);
      
      MouseListener listener = new MousePressListener();
      scene.addMouseListener(listener);

      scene.addKeyListener(new KeyStrokeListener());
      scene.setFocusable(true);

      setSize(FRAME_WIDTH, FRAME_HEIGHT);

      
   }
}
