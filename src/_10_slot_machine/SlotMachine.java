package _10_slot_machine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SlotMachine implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton spinButton = new JButton("SPIN");
	JLabel label1, label2, label3;
	
	String [] images = {"Octane_Body_icon.png", "Fennec_Body_icon.png", "Breakout_Body_icon.png", "Octane_ZSR_body_icon.png" };
	
	public void setup() throws MalformedURLException {
		
		frame.setLayout(new FlowLayout());
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label1 = createLabelImage(images[0]);		
		label2 = createLabelImage(images[0]);		
		label3 = createLabelImage(images[0]);
		
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		
		spinButton.setPreferredSize(new Dimension(100,250));
		frame.add(spinButton);
		
		frame.pack();
		
		frame.getContentPane().setBackground( Color.black );
		
		spinButton.addActionListener(this);
		
	}
	
	public static void main(String[] args) throws MalformedURLException {
		new SlotMachine().setup();
	}

	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null){
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int r1 = new Random().nextInt(4);
		int r2 = new Random().nextInt(4);
		int r3 = new Random().nextInt(4);

		frame.remove(label1);
		frame.remove(label2);
		frame.remove(label3);
		frame.remove(spinButton);
			
		try {
			label1 =  createLabelImage(images[r1]);
			label2 =  createLabelImage(images[r2]);
			label3 =  createLabelImage(images[r3]);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		
		frame.add(spinButton);
		
		frame.pack();
		
		if ( r1 == r2 && r1 == r3 ) {
			JOptionPane.showMessageDialog(null, ":) YOU WIN! :)");
		}
	}
}
