import javax.swing.*;
import java.awt.*;
//Creating a main panel class thta extends JPanel
public class MyPanel extends JPanel {
	//Declaring instance variables
	FlowPanel flow;
	static BarPanel barChart;
	//Creating a contructor
	public MyPanel() {
		//Setting the layout to Border Layout
		setLayout(new BorderLayout());
		//Creating and adding a flow panel to the main panel
		flow = new FlowPanel();
		add(flow, BorderLayout.CENTER);
		//Creating and adding a bar chart panel to the main panel
		barChart = new BarPanel();
		add(barChart, BorderLayout.SOUTH);
	}
	//Creating a method that calls the a method in the BarPanel class
	public static void initBar() {
		barChart.make();
	}
}