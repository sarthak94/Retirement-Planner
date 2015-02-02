import java.awt.event.*;
import java.awt.*;
import javax.swing.* ;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

// Creating a class for the main frame
public class MyFrame extends JFrame {
	//Declaring a global instance variable
	public static MyPanel myPanel;

	public static void main(String [] args) {
		//This message pops up whenever the application is run
		JOptionPane.showMessageDialog(null,
									  "Once you have filled out all the details, please hit Enter.\n" +
									  "Please hover on the Labels to know the details",
									  "WELCOME TO THE RETIREMENT PLANNING APPLICATION)",
									  JOptionPane.INFORMATION_MESSAGE);
		//Creating a main frame for the frame based application
		JFrame frame = new JFrame();
		//Setting the general characteristics of a JFrame
		frame.setTitle("Retirement Planner");
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setLocation(350, 170);
		frame.setBackground(Color.black);
		frame.setResizable(false);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Creating and adding a JPanel
		myPanel = new MyPanel();
		frame.add(myPanel);
		//Creating and adding another JFrame
		JFrame helperWindow = new JFrame();
		//Setting the general characteristics of a JFrame
		helperWindow.setTitle("Helper Window");
		helperWindow.setVisible(true);
		helperWindow.setSize(700, 100);
		helperWindow.setLocation(415, 50);
		helperWindow.setBackground(Color.white);
		helperWindow.setResizable(false);
		//Creating and adding another JPanel
		HelperPanel helperPanel = new HelperPanel();
		helperWindow.add(helperPanel);
	}
}




