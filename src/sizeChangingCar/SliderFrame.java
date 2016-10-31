package sizeChangingCar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderFrame extends JFrame{
	
	private JPanel sliderPanel; 
	private Car car;
	private ChangeListener listener;
		
	public SliderFrame(Car car){
		setLocation(0,400);
		sliderPanel = new JPanel();
		
		JSlider slider = new JSlider();
		sliderPanel.add(slider);
		sliderPanel.add(new JLabel("Length"));
		
		listener = new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				car.update(slider.getValue()*3);
			}
		};
		slider.addChangeListener(listener);
		
		
		this.add(sliderPanel);
		
		
		this.setSize(300, 300);
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
