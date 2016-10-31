package sizeChangingCar;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Car {
	int l, x, y;
	ChangeListener listener;
	
	public Car(int l, int x, int y){
		this.l = l;
		this.x = x;
		this.y = y;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void attach(ChangeListener observerListener){
		listener = observerListener;
	}
	
	public void update(int newLength){
		l = newLength;
		listener.stateChanged(new ChangeEvent(this));
	}
	
}
