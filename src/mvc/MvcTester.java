package mvc;
/**
 * Read Me: This programs demonstrate the use of MVC model:
 * Model: Line
 * View: Components in LineFrame
 * Controller: LineFrame implements ChangeListener to update TextArea
 * 			   Button implements ActionListener to get new input from textField
 * @author kimpham
 *
 */

public class MvcTester {

	public static void main(String[] args) {
		Line line = new Line();
		LineFrame frame = new LineFrame(line);
		line.attach(frame);

	}

}
