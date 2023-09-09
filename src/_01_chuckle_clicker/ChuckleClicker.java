package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	
	JButton jokeButton, punchlineButton;
	
	public static void main(String[] args) {
		new ChuckleClicker().makeButtons();
	}
	
	void makeButtons() {
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		jokeButton = new JButton("Joke");
		punchlineButton = new JButton("Punchline");
		
		panel.add(jokeButton);
		panel.add(punchlineButton);
		frame.add(panel);

		frame.pack();
		
		jokeButton.addActionListener(this);
		punchlineButton.addActionListener(this);
		
		
	}


	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == jokeButton) {
			JOptionPane.showMessageDialog(null, "Hi");
			JOptionPane.showMessageDialog(null, "What do chickens grow on?");
		} else {
			JOptionPane.showMessageDialog(null, "Eggplants...");
			JOptionPane.showMessageDialog(null, "Chickens come from eggs, therefore EGG-plants");
		}
		
	}
	
}
