package _06_calculator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator implements ActionListener {
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("0");
	JPanel panel = new JPanel();
	JButton addButton = new JButton("+");
	JButton subtractButton = new JButton("-");
	JButton multiplyButton = new JButton("x");
	JButton divideButton = new JButton("\u00F7");
	JTextArea num1 = new JTextArea("", 1, 10);
	JTextArea num2 = new JTextArea("", 1, 10 );
	
	void setup() {
		
		panel.add(num1);
		panel.add(num2);
		panel.add(addButton);
		panel.add(subtractButton);
		panel.add(multiplyButton);
		panel.add(divideButton);
		panel.add(label);
		
		label.setFont(label.getFont().deriveFont(28.0f));
		
		frame.add(panel);

		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		addButton.addActionListener(this);
		subtractButton.addActionListener(this);
		multiplyButton.addActionListener(this);
		divideButton.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new Calculator().setup();
	}
	
	public double add(double num1, double num2) {
		return num1 + num2;
	}
	
	public double subtract(double num1, double num2) {
		return num1 - num2;
	}
	
	public double multiply(double num1, double num2) {
		return num1 * num2;
	}
	
	public double divide(double num1, double num2) {
		return num1 / num2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		double answer = 0;

		
		if (!num1.getText().isEmpty() && !num2.getText().isEmpty()) {
			
			double input1 = Double.parseDouble(num1.getText());
			double input2 = Double.parseDouble(num2.getText());
			
			if (e.getSource() == addButton) {
				answer = add(input1, input2);
			} else if (e.getSource() == subtractButton) {
				answer = subtract(input1, input2);
			} else if (e.getSource() == multiplyButton) {
				answer = multiply(input1, input2);
			}  else if (e.getSource() == divideButton) {
				answer = divide(input1, input2);
			}
			
			label.setText(String.valueOf(answer));
			frame.pack();
		}
	
	}
}
