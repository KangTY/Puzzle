package TeamPL;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Text extends JFrame{

	public Text() {
		Dimension dim = new Dimension(350,150);

		JFrame frame = new JFrame("난이도 선택");
		frame.setLocation(200,400);
		frame.setPreferredSize(dim);

		JTextField textfield = new JTextField();

		JLabel label = new JLabel("난이도 입력 (상 or 중 or 하)");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);

		JButton button = new JButton("확인");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Level lev = new Level();
				int size = lev.LevelDist(textfield.getText());
				SlidePuzzleBoard board = new SlidePuzzleBoard(size);
				PuzzleFrame puzzle = new PuzzleFrame(size, board);
			} 
		});

		frame.add(textfield, BorderLayout.CENTER);
		frame.add(label, BorderLayout.NORTH);
		frame.add(button, BorderLayout.SOUTH);

		frame.pack();
		frame.setVisible(true);
	}
}