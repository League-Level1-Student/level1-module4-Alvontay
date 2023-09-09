package _09_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {

	
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JButton moleButton;
	int score, turns, misses = 0;
	
	void setup() {
		drawButtons();
		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400,300);
	}
	
	void drawButtons() {
		
		int random = new Random().nextInt(24);
		
		for (int i = 0; i < 24; i++) {
			
			JButton button = new JButton("                        ");
			
			if (i == random) {
				button.setText("      MOLE!      "); 
                moleButton = button;
			}
			
			panel.add(button);
			button.addActionListener(this);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		new WhackAMole().setup();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getSource());
		
		JButton jbutton = (JButton) e.getSource();
		
//		if (jbutton.getText().equals("      MOLE!      ")) {
//			
//		}
		
		if (jbutton == moleButton) {
			score++;
		} else {
			//speak("You missed");
			misses++;
			switch (misses) {
			case 1: System.out.println("You Missed!");
			break;				
			case 2: System.out.println("You Missed Again! :(");
			break;				
			case 3: System.out.println("Miss Number " + misses);
			break;							
			case 4: System.out.println("That was your last miss");
			break;
			}

		}
		
		turns++;
		
		if (turns == 10) {
			if (score > 6) {
				JOptionPane.showMessageDialog(null, ":)  Game Over  :) - Your score is: " + score + "/10  :)");
			} else {
				JOptionPane.showMessageDialog(null, "GAME OVER - Your score is: " + score + "/10  :(");
			}

			System.exit(0);
		} else if (misses == 5) {
			System.out.println(":(");
			JOptionPane.showMessageDialog(null, "YOU LOSE!");
			System.exit(0);
		} else {
			panel.removeAll();
			setup();
		}

	}
	
//    static void speak(String words) {
//        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
//            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
//                    + words + "');\"";
//            try {
//                Runtime.getRuntime().exec( cmd ).waitFor();
//            } catch( Exception e ) {
//                e.printStackTrace();
//            }
//        } else {
//            try {
//                Runtime.getRuntime().exec( "say " + words ).waitFor();
//            } catch( Exception e ) {
//                e.printStackTrace();
//            }
//        }
//    }

}
