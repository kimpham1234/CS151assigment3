package analogClock;
//4.18
/**
 * CS151-Assignment3
 * Exercise 4.18
 * Kim Pham
 */

/**
 * ClockTester.java: Tester for clock icon
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		Calendar now = new GregorianCalendar();
		int[] time = new int[3];
		time[0] = now.get(GregorianCalendar.HOUR);
		time[1] = now.get(GregorianCalendar.MINUTE);
		time[2] = now.get(GregorianCalendar.SECOND);
		System.out.println(time[0]+ " "+time[1] + " " + time[2]);
	
		ClockIcon clock = new ClockIcon(200,250,250,time);
		JLabel clockLabel = new JLabel(clock);
		
		frame.add(clockLabel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
