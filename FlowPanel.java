import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
//Creats a new JPanel class that extends JPanel
public class FlowPanel extends JPanel {
	//Creating static instance variables
	static JTextField[] fields = new JTextField[13];
	static JLabel[] labels = new JLabel[13];
	static DecimalFormat df, df2;
	static int code;
	static double accumulatedIncomeAtRetirement;
	static double [] totalIncome;
	//Creating a constructor
	public FlowPanel() {
		//Setting general characteristics of the JPanel
		setLayout(new FlowLayout());
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		//Creating several JTextFields of varying lengths
		fields[0] = new JTextField(14);
		fields[1] = new JTextField(14);
		fields[2] = new JTextField(4);
		fields[3] = new JTextField(4);
		fields[4] = new JTextField(4);
		fields[5] = new JTextField(4);
		fields[6] = new JTextField(4);
		fields[7] = new JTextField(10);
		fields[8] = new JTextField(10);
		fields[9] = new JTextField(14);
		fields[10] = new JTextField(10);
		fields[11] = new JTextField(10);
		fields[12] = new JTextField(10);
		//Adding Key Listeners to all the text fields using a loop
		for (JTextField field : fields)
			field.addKeyListener(new keyListener());
		//Initializing all the JLabels
		labels[0] = new JLabel("First name");
		labels[1] = new JLabel("Last name");
		labels[2] = new JLabel("Age");
		labels[3] = new JLabel("Life expectancy");
		labels[4] = new JLabel("Retirement age");
		labels[5] = new JLabel("Rate of Interest");
		labels[6] = new JLabel("Rate of Inflation");
		labels[7] = new JLabel("Estimated daily savings");
		labels[8] = new JLabel("Initial Savings fund");
		labels[9] = new JLabel("Middle name");
		labels[10] = new JLabel("Major asset purchases");
		labels[11] = new JLabel("Monthly expenses");
		labels[12] = new
		JLabel("Accumulated Retirement Income at the year of Retirement");
		JLabel SPACE1 = new JLabel("                       ");
		JLabel SPACE2 = new JLabel("                       ");
		//Setting the font of all the labels using a loop
		for (JLabel elements : labels) {
			elements.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 13));
		}
		//Adding all the text fields and labels to the Panel

		add(labels[0]);
		add(fields[0]);
		add(labels[9]);
		add(fields[9]);
		add(labels[1]);
		add(fields[1]);
		add(labels[2]);
		add(fields[2]);
		add(labels[3]);
		add(fields[3]);
		add(labels[4]);
		add(fields[4]);
		add(labels[5]);
		add(fields[5]);
		add(labels[6]);
		add(fields[6]);
		add(SPACE2);
		add(labels[7]);
		add(fields[7]);
		add(labels[8]);
		add(fields[8]);
		add(SPACE1);
		add(labels[10]);
		add(fields[10]);
		add(labels[11]);
		add(fields[11]);
		add(labels[12]);
		add(fields[12]);


	}

	//Creating a keyListener class that extends KeyAdapter class
	public class keyListener extends KeyAdapter {
		//Overriding the keyPressed method
		@Override
		public void keyPressed(KeyEvent e) {
			//The following code gets executed when the user fill out all the details
			//and hits the Enter key
			code = e.getKeyCode();
			if (code == KeyEvent.VK_ENTER) {
				// All the financial computations take place within the Try block
				try {
					//If the retirement age is lesser than the current age, an error
					//message pops up to let the user know about it
					if (Double.parseDouble(fields[2].getText()) > Double.parseDouble(
								fields[4].getText())) {
						JOptionPane.showMessageDialog(null,
													  "An error ocurred during computations.\nPlease check your current age and retirement age",
													  "ERROR",
													  JOptionPane.ERROR_MESSAGE);
						return;
					}
					//If current age is higher than the life expectancy, the
					//following error message pops upp
					if (Double.parseDouble(fields[2].getText()) > Double.parseDouble(
								fields[3].getText())) {
						JOptionPane.showMessageDialog(null,
													  "An error ocurred during computations.\nPlease check your current age and life expectancy",
													  "ERROR",
													  JOptionPane.ERROR_MESSAGE);
						return;
					}
					//If your retirement age is higher than the life expectancy, the
					//following error message pops upp
					if (Double.parseDouble(fields[4].getText()) > Double.parseDouble(
								fields[3].getText())) {
						JOptionPane.showMessageDialog(null,
													  "Your retirement age cannot be higher than your life expectancy",
													  "ERROR",
													  JOptionPane.ERROR_MESSAGE);
						return;
					}
					//If life expectancy is not filled out, the following message pops up
					if (fields[3].getText().length() == 0) {
						JOptionPane.showMessageDialog(null,
													  "An error ocurred during computations.\nPlease fill out your life expectancy based off your medical records",
													  "ERROR",
													  JOptionPane.ERROR_MESSAGE);
						return;
					}
					//If the last name is not filled out, the following message pops up
					if (fields[1].getText().length() == 0) {
						JOptionPane.showMessageDialog(null,
													  "Please type your Last Name",
													  "ERROR",
													  JOptionPane.ERROR_MESSAGE);
						return;
					}

					//If the monthly expenses are not filled out, the following message pops up
					if (fields[11].getText().length() == 0) {
						JOptionPane.showMessageDialog(null,
													  "Please type in your estimated monthly expenses during retirement",
													  "ERROR",
													  JOptionPane.ERROR_MESSAGE);
						return;
					}
					//If the last name is not filled out, the following message pops up
					if (fields[10].getText().length() == 0) {
						JOptionPane.showMessageDialog(null,
													  "Please type your estimated major asset purchases",
													  "ERROR",
													  JOptionPane.ERROR_MESSAGE);
						return;
					}
					//If the first name is not filled out, the following message pops up
					if (fields[0].getText().length() == 0) {
						JOptionPane.showMessageDialog(null,
													  "Please fill out your First Name",
													  "ERROR",
													  JOptionPane.ERROR_MESSAGE);
						return;
					}
					//If the middle name is not filled out, the following message pops up
					if (fields[9].getText().length() == 0) {
						JOptionPane.showMessageDialog(null,
													  "Please type in your Middle Name",
													  "ERROR",
													  JOptionPane.ERROR_MESSAGE);
						return;
					}
					//initializing instances of Decimal Format Class
					df = new DecimalFormat("#.######");
					df2 = new DecimalFormat("#.########");
					//Calculating the annual real rate of return based off the annual savings and annual inflation rates
					//typed in by the user
					double annualRealRateOfReturn = ((1 + Double.parseDouble(
														  fields[5].getText()) / 100.0) / (1 + Double.parseDouble(
																  fields[6].getText()) / 100.0)) - (1);
					//Formatting annual rate of return
					annualRealRateOfReturn = Double.valueOf(df.format(annualRealRateOfReturn));
					//coverting the annual rate to daily real rate of return
					double dailyRealRateOfReturn = (1 + annualRealRateOfReturn);
					dailyRealRateOfReturn = Math.pow(dailyRealRateOfReturn, (1 / 365.0));
					dailyRealRateOfReturn = dailyRealRateOfReturn - 1.0;
					dailyRealRateOfReturn = Double.valueOf(df2.format(dailyRealRateOfReturn));
					//Calculating the difference between the current age and the retirement age typed in by the user
					int numberOfYearsUntilRetirement = Integer.parseInt(
														   fields[4].getText()) - Integer.parseInt(fields[2].getText());
					//initializing the total income array that is used as Y axis for the bar chart
					totalIncome = new double[numberOfYearsUntilRetirement ];
					double dailySavings = (Double.parseDouble(fields[7].getText()));
					totalIncome[0] =  Double.parseDouble(fields[7].getText());
					for (int i = 0; i < totalIncome.length ; i++) {
						double partOne = Math.pow((1 + dailyRealRateOfReturn), (i * 365));
						totalIncome[i] = dailySavings * i * 365 * partOne;
						totalIncome[i] = Double.valueOf(df2.format(totalIncome[i]));

					}
					//Calculating the future value of the initial savings fund or the principal typed in by the user
					double futureValueOfSavings = (Double.parseDouble(
													   fields[8].getText()) * Math.pow((1 + dailyRealRateOfReturn),
															   numberOfYearsUntilRetirement * 365));
					//Applying the formula for future value of annuity wherein the annuity is the daily amount of savings
					double partOne = Math.pow((1 + dailyRealRateOfReturn),
											  (numberOfYearsUntilRetirement * 365));
					partOne = partOne / dailyRealRateOfReturn;
					double futureValueOfAnnuity = (Double.parseDouble(fields[7].getText())) *
												  (partOne);
					// Finding the accumulated savings fund at the time of retirement
					accumulatedIncomeAtRetirement = futureValueOfAnnuity +
													futureValueOfSavings;
					//Formating accumulated retirement income
					accumulatedIncomeAtRetirement = Double.valueOf(df2.format(
														accumulatedIncomeAtRetirement));

					//Calling a method in MyPanel class
					MyPanel.initBar();
					//In case there is any problem during computations, the followings pops up
				} catch (NumberFormatException problem) {
					JOptionPane.showMessageDialog(null,
												  "There was a problem during Computations.\nPlease fill out all the details or check if you have typed in Strings instead of numbers or vice versa",
												  "Error",
												  JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}