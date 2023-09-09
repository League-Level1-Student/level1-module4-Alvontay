package _11_lights_out;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * Lights Out is a puzzle game with a grid of lights that are either on (light
 * gray) or off (white). Pressing any light will toggle it and its adjacent
 * lights. The goal of the game is to switch all the lights off.
 * 
 * Follow the instructions below to create your own version of Lights Out
 * 
 * 
 */
public class LightsOut implements MouseListener {

	JPanel gamePanel = new JPanel();
	JFrame frame = new JFrame();

	public static void main(String[] args) {
		new LightsOut();
	}
	
	public LightsOut() {
		

		/** PART 1. CREATE YOUR LIGHT BOARD **/
		//1. Make your gamePanel a 5x5 grid with setLayout(new GridLayout(5, 5));
		gamePanel.setLayout(new GridLayout(9,9));
		
			//2. Add 25 JLabels to your gamePanel (these are your lights)
			for (int i = 0 ; i < 81; i++) {
				Random r = new Random();
				JLabel label = new JLabel();
				label.setText(String.valueOf(i));
				if (r.nextInt(2) == 1) {
					label.setBackground(new Color(10, 20,30));
					label.setForeground(new Color(10, 20,30));
				} else {
					label.setBackground(Color.WHITE);
					label.setForeground(Color.WHITE);
				}
				label.setOpaque(true);
				gamePanel.add(label);
				label.addMouseListener(this);
			}
			//3. Use setText() to add a position number to each light (0-24).

			//4. Set the background of each light to LIGHT_GRAY
			// - you will also have to set the background to opaque.
			// - Use light.setOpaque(true);

			//5. Add a mouseListener to each light
		
		
		//6. Add your panel to a frame
			frame.add(gamePanel);
		//7. Set the size of the frame
			frame.setSize(500,500);
			frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int score = 0;
		/** PART 2: TOGGLE NEIGHBORING LIGHTS **/
		// 1. Get the light that was clicked on `(JLabel) e.getSource`
		JLabel light  = (JLabel) e.getSource();
		// 2. Get the number (position) of the light
		String pos = light.getText();
		// 3. Now use the makeMove method to code which lights turn on and off.
		makeMove(Integer.parseInt(pos));
		// 4.Check if the player has won (e.g. all the lights are off)
		// ---- HINT: use `getLightAtPosition` to get the light at each position
		// ---------- use 'getBackground' to get the light color
		for (int i = 0; i < 81; i++ ) {
			if (getLightAtPosition(i).getBackground().equals(new Color(10, 20,30))) {
				score++;
			}
			if (score == 81) {
				JOptionPane.showMessageDialog(null, "YOU WON");
			}
		}
		/** PART 3: RANDOMIZE YOUR BOARD **/
		// Now that your game works can you make the game start with some lights on?

	}

	void makeMove(int pos) {
		toggle((JLabel) gamePanel.getComponent(pos));
		if (pos >= 9) {
			toggle((JLabel) gamePanel.getComponent(pos - 9));
		}
		if ((pos + 1) % 9 != 0) {
			toggle((JLabel) gamePanel.getComponent(pos + 1));
		}
		if (pos % 9 != 0) {
			toggle((JLabel) gamePanel.getComponent(pos - 1));
		}
		if (pos + 9 <= 80) {
			toggle((JLabel) gamePanel.getComponent(pos + 9));
		}
	}

	JLabel getLightAtPosition(int lightPosition) {
		return (JLabel) gamePanel.getComponent(lightPosition);
	}

	void toggle(JLabel label) {
		if (label.getBackground() == Color.WHITE) {
			label.setBackground(new Color(10, 20,30));
			label.setForeground(new Color(10, 20,30));

		} else {
			label.setBackground(Color.WHITE);
			label.setForeground(Color.WHITE);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}
}
