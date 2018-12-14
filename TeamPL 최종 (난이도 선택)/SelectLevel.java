package TeamPL;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SelectLevel{
	
	public SelectLevel() {
		
		Dimension dim = new Dimension(400, 150);
		
		JFrame frame = new JFrame("Select Level");
		frame.setLocation(300,300);
		frame.setPreferredSize(dim);
		
		JButton button1 = new JButton("highLevel");
		button1.setText("High Level");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePuzzle puzzle = new ImagePuzzle();
				puzzle.setSize(5);
				puzzle.Puzzle();
				frame.dispose();
			}
		});
		
		JButton button2 = new JButton("midLevel");
		button2.setText("Mid Level");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePuzzle puzzle = new ImagePuzzle();
				puzzle.setSize(4);
				puzzle.Puzzle();
				frame.dispose();
			}
		});
		
		JButton button3 = new JButton("lowLevel");
		button3.setText("Low Level");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImagePuzzle puzzle = new ImagePuzzle();
				puzzle.setSize(3);
				puzzle.Puzzle();
				frame.dispose();
			}
		});
		
		frame.add(button1, BorderLayout.EAST);
		frame.add(button2, BorderLayout.CENTER);
		frame.add(button3, BorderLayout.WEST);
		frame.pack();
		frame.setVisible(true);
	
	}
	
}