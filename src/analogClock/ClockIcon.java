package analogClock;
/**
 * CS151-Assignment3
 * Exercise 4.18
 * Kim Pham
 */

/**
 * ClockIcon.java: define clock icon
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.Icon;

public class ClockIcon implements Icon {
	private int radius;
	private int centerX;
	private int centerY;
	private int hourLength;
	private int minLength;
	private int secondLength;
	
	private String hour;
	private double min;
	private double second;
	private String[] numbers = {"3","2","1","12","11","10","9","8","7","6","5","4"};
	
	public ClockIcon(int radius, int centerX, int centerY,int[] time){
		this.radius = radius;
		this.centerX = centerX;
		this.centerY = centerY;
		hourLength = 2*radius/5+radius/6;
		minLength = radius/4;
		secondLength = radius/4;
		if(time[0]==0) time[0] = 12;
		hour = Integer.toString(time[0]);
		min = time[1]/5.0;
		second = time[2]/5.0;
		
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		int padY = 10;
		int padX = -5;
		Graphics2D g2 = (Graphics2D) g;
		
		//draw clock
		Ellipse2D clock = new Ellipse2D.Double();
		clock.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
		g2.draw(clock);
		
		//draw center
		Ellipse2D center = new Ellipse2D.Double(centerX, centerY, 3, 3);
		g2.fill(center);
		g2.draw(center);
		
		//font
		Font font = new Font("Serif", Font.BOLD, 30);
		g2.setFont(font);
		
		
		for(int i = 0; i < 12; i++){
			
			double incX = (radius-10)*Math.round(Math.cos(i*2*Math.PI/12)*100)/100;
			double incY = (radius-10)*Math.round(Math.sin(i*2*Math.PI/12)*100)/100;
			double posX = 0;
			double posY = 0;
			
		    posX = centerX+incX;
	    	posY = centerY - incY;
			
			g2.drawString(numbers[i], (int) posX + padX, (int) posY+padY);
		}
		
		//draw hour hand
		double incX = (radius-hourLength)*Math.round(Math.cos(getIndex(hour)*2*Math.PI/12)*100)/100;
		double incY = (radius-hourLength)*Math.round(Math.sin(getIndex(hour)*2*Math.PI/12)*100)/100;
		double posX = 0;
		double posY = 0;
		
	    posX = centerX+incX;
    	posY = centerY - incY;
    	g2.setStroke(new BasicStroke(5));
		Line2D hand = new Line2D.Double(centerX, centerY, posX, posY);
		g2.draw(hand);
		
		//draw min and second hand
		g2.setStroke(new BasicStroke(2));
		for(int i = 0; i < 2; i++){
			int length = 0;
			double time = 0;
			if(i==0){
				length = minLength;
				time = min;
			}else{
				length = secondLength;
				time = second;
				g2.setColor(Color.RED);
			}
		
			incX = (radius-length)*Math.round(Math.cos(-(time-3)*2*Math.PI/12)*100)/100;
			incY = (radius-length)*Math.round(Math.sin(-(time-3)*2*Math.PI/12)*100)/100;
			posX = centerX + incX;
			posY = centerY - incY;
			Line2D otherhand = new Line2D.Double(centerX, centerY, posX, posY);
			g2.draw(otherhand);
			
		}
		
	}

	public int getIndex(String num){
		for(int i = 0; i < numbers.length; i++){
			if(num.equals(numbers[i]))
				return i;
		}
		return 0;
	}
	
	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 40;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 40;
	}

}
