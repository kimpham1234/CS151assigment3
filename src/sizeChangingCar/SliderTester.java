package sizeChangingCar;
//exercise 5.4
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SliderTester {

	public static void main(String[] args) {
	
		Car car = new Car(50,200,100);
		CarFrame frame = new CarFrame(car);
		SliderFrame slider = new SliderFrame(car);
		car.attach(frame);
		
		
	}

}
