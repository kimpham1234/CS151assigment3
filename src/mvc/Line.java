package mvc;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * Line.java: Model for the program
 */
public class Line {
	String line;
	ChangeListener listener;
	
	public Line(){
		this.line = "";
		listener = null;
	}
	
	public String getLine(){
		return line;
	}
	
	public void attach(ChangeListener listener){
		this.listener = listener;
	}
	
	public void update(String newline){
		line += newline+"\n";
		listener.stateChanged(new ChangeEvent(this));
	}
	
}
