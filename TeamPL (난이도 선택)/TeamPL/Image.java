package TeamPL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image{
	public static void main(String[] args) {
		JFrame frm = new JFrame("정답");
		ImageIcon ic = new ImageIcon("C:\\Users\\kang7\\OneDrive\\바탕 화면\\2018학년도 수강 과목\\2학기\\프로그램설계방법론\\프로그램 설계 방법론\\src\\TeamPL\\Github.png");
		JLabel lbimage1 = new JLabel(ic);
		
		frm.add(lbimage1);
		frm.setVisible(true);
		frm.setBounds(10,10,800,600);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}