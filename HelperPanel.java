import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
//Creates a class that extends JPanel. This Panel helps the user in filling out the details
//in the application
public class HelperPanel extends JPanel {
	//Declaring the instance variables
	static JLabel displayTextOne, displayTextTwo;
	private static JLabel[] labels;
	private static JTextField [] fields;
	//Creates a constructor
	public HelperPanel() {
		// Creating shallow copies of arrays of labels and fields created in the FlowPanel
		//This helps in accessing those arrays here easily
		labels = MyFrame.myPanel.flow.labels;
		fields = MyFrame.myPanel.flow.fields;
		//Setting the layout to Flow layout
		setLayout(new FlowLayout());
		//Initializing the labels to empty Strings for now
		displayTextOne = new JLabel(" Hover on the labels to know the details");
		displayTextTwo = new JLabel("");
		//Adding the labels to the helper panel
		add(displayTextOne);
		add(displayTextTwo);
		//Setting the font and color of the text of the labels
		displayTextOne.setForeground(new Color(139, 90, 0));
		displayTextOne.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 13));
		displayTextTwo.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 13));
		//Adding mouse listeners to all the JLabels
		for (JLabel label : labels)
			label.addMouseListener(new mouseListener());
	}
	//Creating a private class that extends MouseAdapter class
	private static class mouseListener extends MouseAdapter {
		@Override
		//Overriding the mouseEntered method
		public void mouseEntered(MouseEvent e) {
			super.mouseEntered(e);
			//When the user hovers the mouse over the Jlabels, some details regarding
			//the respective labels are displayed in the helper window
			if (e.getSource() instanceof JLabel) {
				JLabel b = (JLabel)e.getSource();
				String labelText = b.getText();
				if (labelText.equals("First name")) {
					labels[0].setForeground(Color.red);
					displayTextOne.setText("Put your first name here");
				} else if (labelText.equals("Middle name")) {
					labels[9].setForeground(Color.red);
					displayTextOne.setText("Put your middle name here");
				} else if (labelText.equals("Age")) {
					labels[2].setForeground(Color.red);
					displayTextOne.setText("Type your current age here");
				} else if (labelText.equals("Last name")) {
					labels[1].setForeground(Color.red);
					displayTextOne.setText("Please type your last name here.");
				} else if (labelText.equals("Life expectancy")) {
					labels[3].setForeground(Color.red);
					displayTextOne.setText("An estimated year is needed to calculate the number of years for which compounding\n is to be done ");
				} else if (labelText.equals("Retirement age")) {
					labels[4].setForeground(Color.red);
					displayTextOne.setText("This is needed to ascertain how many daily or annual contributions will be made upto retirement");
				} else if (labelText.equals("Rate of Interest")) {
					labels[5].setForeground(Color.red);
					displayTextOne.setText("This is the annual rate of interest. This program will covert it into a daily rate.");
					displayTextTwo.setText(" This is the rate of return on the accumulated savings or the investments made with the savings. ");
				} else if (labelText.equals("Rate of Inflation")) {
					labels[6].setForeground(Color.red);
					displayTextOne.setText("This is the annual rate of Inflation.This program will covert it into a daily rate.");
					displayTextTwo.setText(" This rate of rise in price levels reduces the worth of money. Currently, it is within 1.5% to 2.0% range.");
				} else if (labelText.equals("Estimated daily savings")) {
					labels[7].setForeground(Color.red);
					displayTextOne.setText(" This is the amount you would like to save every day");
				} else if (labelText.equals("Initial Savings fund")) {
					labels[8].setForeground(Color.red);
					displayTextOne.setText(" This is the amount you start off with. It is called the Principal amount in financial terms.");
					displayTextTwo.setText(" This amount gets compounded along with the daily savings");
				} else if (labelText.equals("Major asset purchases")) {
					labels[10].setForeground(Color.red);
					displayTextOne.setText("This is the estimated total amount to be spent on new assets lke cars and house.");
					displayTextTwo.setText("You may add the value of any funds like College education to this total.");
				} else if (labelText.equals("Monthly expenses")) {
					labels[11].setForeground(Color.red);
					displayTextOne.setText("This is an estimate of the monthly expenses to be incurred during retirement.");
				}
			}
		}
		//Overriding the mouseExcited method
		@Override
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);
			//Setting the font color of all the labels
			for (JLabel label : labels)
				label.setForeground(Color.BLACK);
			//Initializing the labels
			displayTextOne.setText("Hover on the Label to know details");
			displayTextTwo.setText("");
		}
	}
}

