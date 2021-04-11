package _06_overloading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * Overloading is when we have multiple methods with the SAME name, but DIFFERENT parameters.
 * This can mean a different number of parameters, or the parameter types can differ, or both!
 * An overloaded method can also have a different return type, in addition to changing the parameters.
 * 
 * GOAL: Create your own custom pop-up messages
 */
public class LeagueOptionPane implements ActionListener {

	JButton button1 = new JButton("Original!");
	JButton button2 = new JButton("Choose your title and message!");
	JButton button3 = new JButton("Choose your image!");

	public void setup() {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(200, 200);

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (arg0.getSource() == button1) {
			showMessageDialog("original");
		}

		else if (arg0.getSource() == button2) {
			showMessageDialog2();
		}

		else if (arg0.getSource() == button3) {
			showMessageDialog3();
		}

	}

	public static void showMessageDialog(String message) {
		// 1. Open example.png and make a GUI that looks like that
		// The message parameter is what we want to show on our pop-up
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		JTextArea text = new JTextArea();

		frame.add(panel);
		frame.setVisible(true);
		frame.setTitle("Message");
		frame.setSize(200, 100);

		panel.add(label);
		panel.add(text);
		label.setIcon(loadImage("league.png"));
		text.setText("The League is the best!");

		// 2. Uncomment the line of code below. It sets the location of our frame to the
		// center of the screen
		frame.setLocationRelativeTo(null);
	}

	// 3. Call this method in the Runner class

	// 4. Create another showMessageDialog() method that lets us also choose the
	// Message and Title
	// 2 String parameters (one for the message and one for the title)
	public static void showMessageDialog2() {

		JFrame frame2 = new JFrame();
		JPanel panel2 = new JPanel();
		JLabel label2 = new JLabel();
		JTextArea text2 = new JTextArea();

		String msg = JOptionPane.showInputDialog("Give me a message!");
		String ttl = JOptionPane.showInputDialog("Give me a title!");

		frame2.add(panel2);
		frame2.setVisible(true);
		frame2.setTitle(ttl);
		frame2.setSize(200, 100);

		panel2.add(label2);
		panel2.add(text2);
		label2.setIcon(loadImage("league.png"));
		text2.setText(msg);

	}

	// 5. Call this method in the Runner class

	// 6. Create another showMessageDialog() method that lets us choose the Message,
	// Title, and Image
	// 3 String parameters (one for the message, one for the title, and one for the
	// fileName)
	public static void showMessageDialog3() {

		JFrame frame3 = new JFrame();
		JPanel panel3 = new JPanel();
		JLabel label3 = new JLabel();
		JTextArea text3 = new JTextArea();

		String msg = JOptionPane.showInputDialog("Give me a message!");
		String ttl = JOptionPane.showInputDialog("Give me a title!");
		String img = JOptionPane.showInputDialog("Choose one: " + "league.png or leagueDark.png");

		frame3.add(panel3);
		frame3.setVisible(true);
		frame3.setTitle(ttl);
		frame3.setSize(200, 100);

		panel3.add(label3);
		panel3.add(text3);
		label3.setIcon(loadImage(img));
		text3.setText(msg);

	}

	// 7. Call this method in the Runner class

	// CHALLENGE:
	// 1. Create another showMessageDialog() method that lets us choose the Message,
	// Title, Image, and Background Color
	// 3 String parameters (one for the message, one for the title, and one for the
	// fileName)
	// 1 Color parameter for the backgroundColor
	//
	// 2. Change the return type of the 3rd showMessageDialog() method(the one right
	// above) to JPanel
	// Make sure to return your panel at the end of that method
	//
	// 3. Call the showMessageDialog() method you just modified in this method
	// Set the method equal to a JPanel
	//
	// 4. Set the background of your panel to the backgroundColor parameter
	//
	// 5. Call this method in the Runner class
	//
	// WHY DID WE DO THIS? - because we were able to overload this method by calling
	// one of the other methods inside of it

	public static ImageIcon loadImage(String fileName) {
		try {
			return new ImageIcon(ImageIO.read(new LeagueOptionPane().getClass().getResourceAsStream(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
