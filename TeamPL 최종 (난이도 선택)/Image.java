package TeamPL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image{

	public Image() {
		JFrame frm = new JFrame("���� �̹���");
		ImageIcon ic = new ImageIcon("C:\\Users\\kang7\\OneDrive\\���� ȭ��\\2018�г⵵ ���� ����\\2�б�\\���α׷���������\\���α׷� ���� �����\\src\\TeamPL\\Github.png");
		JLabel lbimage1 = new JLabel(ic);

		frm.add(lbimage1);
		frm.setVisible(true);
		frm.setBounds(10,10,500,500);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}