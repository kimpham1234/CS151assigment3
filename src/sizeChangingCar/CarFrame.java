package sizeChangingCar;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CarFrame extends JFrame implements ChangeListener {
	JLabel label;
	CarIcon icon;
	Car car;
	
	
	public CarFrame(Car car){
		icon = new CarIcon(car);
		label = new JLabel(icon);
		this.car = car;
		this.add(label);
		
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		icon.changeLength(car);
		repaint();
	}
	
}
