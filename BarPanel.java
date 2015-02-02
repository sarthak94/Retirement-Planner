import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
//Creates a Panel that will contain the bar chart
public class BarPanel extends JPanel {
	//Declaring all instance variables
	double [] values;
	int size;
	boolean isMade = false;
	//Creates a contructor
	public BarPanel() {
		//Setting the color and the size of the panel
		setBackground(Color.white);
		setPreferredSize(new Dimension(400, 400));
		//Adding a JtextFiled and JLabel that will display the accumulated savings
		//They have been made invisible so that the user does not see them before the bar chart is displayed
		FlowPanel.labels[12].setVisible(false);
		add(FlowPanel.labels[12]);
		FlowPanel.fields[12].setVisible(false);
		add(FlowPanel.fields[12]);
	}
	//A method that makes the necessary calculations needed for making the
	//bar chart
	public void make() {
		//The boolean isMade changes to true whenever this method is called
		isMade = true;
		//The previously created label and text fields are made visible now
		FlowPanel.labels[12].setVisible(true);
		FlowPanel.fields[12].setVisible(true);
		//Setting the background color
		setBackground(Color.white);
		//This refers to the number of columns in the bar chart
		//It is the difference between the current age and the retirement age of the user
		size = Integer.parseInt(FlowPanel.fields[4].getText()) -
			   Integer.parseInt(FlowPanel.fields[2].getText());
		//Formatting the figure for accumulated savings
		DecimalFormat df3 = new DecimalFormat("$#,###,###,###.##");
		FlowPanel.fields[12].setText(df3.format(
										 FlowPanel.accumulatedIncomeAtRetirement));
		//Setting up the values for Y axis of the bar chart
		//These are the values for iaccumulated savings at the end of each year
		values = new double [FlowPanel.totalIncome.length];
		if (Double.parseDouble(FlowPanel.fields[6].getText()) <
				Double.parseDouble(FlowPanel.fields[5].getText()))
			for (int i = 0 ; i < values.length; i++)
				values[i] = (Math.abs(FlowPanel.totalIncome[i]));
		else if (Double.parseDouble(FlowPanel.fields[5].getText()) <=
				 Double.parseDouble(FlowPanel.fields[6].getText()))
			for (int i = 0 ; i < values.length; i++)
				values[i] = -1 * (Math.abs(FlowPanel.totalIncome[i]));
		//Repainting the bar graph everytime the user changes any values
		repaint();
	}
	// These are helper methods that help compute the needful figures for the bar chart
	private double getMin(double [] a) {
		double r = a[0];
		for (int i = 0 ; i < values.length; i++)
			r = ((r > a[i]) ? a[i] : r);
		return r;
	}
	private double getMax(double [] a) {
		double r = a[0];
		for (int i = 0 ; i < values.length; i++)
			r = ((r < a[i]) ? a[i] : r);
		return r;
	}
	// This method actually paints the bar chart on the panel
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		//The bar gets painted only if isMade is true
		if (isMade) {
			//Whenever the bar chart is made, the display labels in the helper window display the following
			HelperPanel.displayTextOne.setText("Your Accumulated Retirement has been calculated based off your inputs.");
			HelperPanel.displayTextTwo.setText("X axis of the  Bar chart refers to the years of savings. Y axis displays income at the end of each year.");
			int w = this.getWidth();
			int h = this.getHeight();
			int mid = h / 2;
			int bwidth = w / size;
			double min = getMin(values);
			double max = getMax(values);
			double factor = mid / Math.max(Math.abs(min), Math.abs(max));
			//If the Inflation rate is lower than the Interest rate, the bar chart is positive
			for (int i = 0 ; i < values.length ; i++) {
				int bhieght = (int)Math.floor(factor * values[i]);
				if (values[i] >= 0) {
					page.setColor(Color.green);
					page.fillRect(i * bwidth, mid - bhieght, bwidth, bhieght);
					page.setColor(Color.black);
					page.drawRect(i * bwidth, mid - bhieght, bwidth, bhieght);
				} else  {
					//If the Interest rate is lower than the Inflation rate, the bar chart is negative
					page.setColor(Color.red);
					page.fillRect(i * bwidth, mid , bwidth, -bhieght);
					page.setColor(Color.black);
					page.drawRect(i * bwidth, mid , bwidth, -bhieght);
				}
			}
		}

	}
}



