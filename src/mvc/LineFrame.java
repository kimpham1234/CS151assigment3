package mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * Displays view and provide controllers for Line model
 *
 */
public class LineFrame extends JFrame implements ChangeListener {
	private JTextArea textArea;
	private JButton addButton;
	private JTextField textField;
	private Line line;
	
	public LineFrame(Line line){
		this.line = line;
		addButton = new JButton("Add");
		this.add(addButton, BorderLayout.NORTH);
		
		textArea = new JTextArea(20,30);
		this.add(textArea, BorderLayout.CENTER);
		
		textField = new JTextField();
		this.add(textField, BorderLayout.SOUTH);
		
		addButton.addActionListener(event->{
			String text = textField.getText();
			line.update(text);
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		String text = line.getLine();
		textArea.setText(text);
		repaint();
	}

}
