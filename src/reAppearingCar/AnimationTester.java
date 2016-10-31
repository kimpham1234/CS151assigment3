package reAppearingCar;
//assignment 4.22
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Source: Publisher's website 
 */
/**
   This program implements an animation that moves
   a plane shape.
*/
public class AnimationTester
{
   /**
      Construct a frame and animate a plane in it.
   */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final MoveableShape shape
         = new CarShape(200,30,50);

      final ShapeIcon icon = new ShapeIcon(shape,
         ICON_WIDTH, ICON_HEIGHT);

      final JLabel label = new JLabel(icon);
      frame.setLayout(new FlowLayout());
      frame.add(label);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 50;
      // milliseconds between timer ticks
      Timer t = new Timer(DELAY, new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               shape.translate(1, 0);
               label.repaint();
               
               //REQUIRED MODIFICATION FOR EXERCISE
               if(shape.getX() > frame.getWidth())
            	   shape.reset(0);
            }
         });
      t.start();
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}
