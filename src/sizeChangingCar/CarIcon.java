package sizeChangingCar;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class CarIcon implements Icon{
	int l;
	int x,y;
	
	public CarIcon(Car car){
		this.l  = car.l;
		this.x = car.x;
		this.y = car.y;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		//set up coordinate
		Point2D.Double p1 = new Point2D.Double(x+l/4, y);
		Point2D.Double p2 = new Point2D.Double(x+3*l/4, y);
		Point2D.Double p3 = new Point2D.Double(x + 7*l/8, y + l/4);
		Point2D.Double p4 = new Point2D.Double(x + l/8, y + l/4);
		
		//upper body
		Line2D line1 = new Line2D.Float(p1, p2);
		Line2D line2 = new Line2D.Float(p2, p3);
		Line2D line3 = new Line2D.Float(p4, p1);
		
		//body
		Rectangle2D body = new Rectangle2D.Double(x, y+l/4, l, l/4);
		
		//tire
		Ellipse2D tire1 = new Ellipse2D.Double(x+3*l/16, y+l/2, l/4, l/4);
		Ellipse2D tire2 = new Ellipse2D.Double(x+3*l/4-l/8,y+l/2,l/4,l/4);
		
		
		g2.draw(line1);
		g2.draw(line2);
		g2.draw(line3);
		g2.draw(body);
		g2.draw(tire1);
		g2.draw(tire2);
		
		
	}
	
	public void changeLength(Car car){
		l = car.l;
	}
	
	
	
	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return l;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return l/2;
	}

}
