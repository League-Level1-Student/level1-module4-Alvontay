package _03_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label;
	char currentLetter;

	void setup(){
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		currentLetter = generateRandomLetter();
		
		label = new JLabel(String.valueOf(currentLetter));
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		frame.addKeyListener(this);
		
		panel.add(label);
		frame.add(panel);
		
		frame.pack();
		
	}
	
	public static void main(String[] args) {
			
		new TypingTutor().setup();
		
	}
	
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println("You typed: " + e.getKeyChar());
		
		if ( e.getKeyChar() == currentLetter) {
			panel.setBackground(Color.green);
		} else {
			panel.setBackground(Color.red);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		currentLetter = generateRandomLetter();
		label.setText(String.valueOf(currentLetter));
		
	}
	
}
