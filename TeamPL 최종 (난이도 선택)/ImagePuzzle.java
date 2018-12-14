package TeamPL;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * 1. �׸����� �� �׸� ����
 * 2. ������ �� ���̵��� �Է¹޾Ƽ� ��ư ���� �ٸ��� ���� (selectLevel.java �̿�)(�Ϸ�)
 * 3. �ð� or ī��Ʈ�� ���� ���� (�Ϸ�)
 * 4. ��ư�� ���� ���� �׸��� �� �� �ֵ��� ���� (image.java �̿�)
 * 5. ���α׷� ����� �ý��� ���ᰡ �� �� �ֵ��� ���� (exit(0) ���)
 */

//��ư�� �̿��� �׸�����
public class ImagePuzzle extends JFrame implements ActionListener {
	
	JButton []btn;
	int count=0, game[], size;
	int clickCount, oldNum, curNum;
	Image original;
	BufferedImage img[];
	long start, end, time;
	
	public void setSize(int size) {
		this.size = size;
	}

	//���� �׸� �б�
	public void Puzzle() {
		
		MediaTracker tracker = new MediaTracker(this);
		original = Toolkit.getDefaultToolkit().getImage("C:\\Users\\kang7\\OneDrive\\���� ȭ��\\2018�г⵵ ���� ����\\2�б�\\���α׷���������\\���α׷� ���� �����\\src\\TeamPL\\Github.png");
		tracker.addImage(original, 0);
		
		try {
			tracker.waitForAll();
		} catch(InterruptedException e) {;}
		
		int width = original.getWidth(this)/size;
		int height = original.getHeight(this)/size;
		setSize(new Dimension(width*size,height*size));
		
		//�̹����� �߶� ����
		img = new BufferedImage[size*size];
		int cnt=0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				img[cnt] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g = img[cnt].getGraphics();
				//�����̹������� �ʿ��� �κи� �߶� �׸���
				g.drawImage(original, 0, 0, width, height, j*width, i*height, (j+1)*width, (i+1)*height, this);
				cnt++;
			}
		}
		
		//���ӹ迭
		game = new int[size*size];
		
		//��ư�� �����
		btn = new JButton[size*size];
		
		for(int i=0;i<size*size;i++) {
			btn[i] = new JButton();
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		
		//���� ���� ��ư�� �̹��� ������
		shuffle();
		setLayout(new GridLayout(size, size));
		
		setResizable(false);
		setVisible(true);
		
		start = System.currentTimeMillis(); //���� �ð� ����
	}
	
	//���� ���� ��ư�� �̹��� ������
	private void shuffle() {
		Random rnd = new Random();
		
		do {
			for(int i=0; i<size*size; i++) 
				game[i]=0;
			
			//�迭�� �ߺ��� ���� �ֱ�
			for(int i=0; i<size*size; i++) {
				int temp=0;
				do {
					temp = rnd.nextInt(size*size);
				}while(game[temp] != 0);
				game[temp] = i;
			}
		}while(endGame()); //������ �ʾ��� �� �ٽ� �����!!
		
		//�迭������ �̹����� �����ؼ� ��ư�� �ο�
		for(int i=0; i<size*size; i++) {
			btn[i].setIcon(new ImageIcon(img[game[i]]));
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton curBtn = (JButton)e.getSource();
		
		for(int i=0; i<btn.length; i++) {
			if(curBtn.getIcon().equals(btn[i].getIcon())) {
				curNum = i;
				break;
			}
		}
		
		//ù��° Ŭ���̸�
		if(clickCount==0) {
			clickCount++;
			oldNum = curNum;
		} else {
			
			//�ι�° Ŭ���̸�
			if(oldNum != curNum) { //���� �Ͱ� ���� �ʴٸ�
				
				//�̹��� ����
				btn[oldNum].setIcon(new ImageIcon(img[game[curNum]]));
				btn[curNum].setIcon(new ImageIcon(img[game[oldNum]]));
				
				//�迭�� ����
				int t = game[oldNum];
				game[oldNum] = game[curNum];
				game[curNum] = t;
				
				//���⼭ ���� ���� Ȯ��
				if(endGame()) {
					end = System.currentTimeMillis(); //���� �ð� ����
					time = (end - start)/(long)1000.0;
					JOptionPane.showMessageDialog(this, "���� �ϼ����� "+ (end-start)/(long)1000+ "�� �ҿ�!");
					
					//���� ������� Ȯ��
					int reStart = JOptionPane.showConfirmDialog(this, "�� �� ��?", "���α׷� ����?", JOptionPane.YES_NO_OPTION);
					if(reStart == JOptionPane.YES_OPTION) {
						shuffle(); //�迭 �ٽ� ����
						repaint(); //�ٽ� �׸���
						start = System.currentTimeMillis(); //���� �ð� ����
						System.out.println(start);
					}else {
						System.exit(0);
					}
				}
			}
			clickCount = 0;
		}
	}
	
	//���� ���Ḧ Ȯ���ϴ� �޼ҵ�
	private boolean endGame() {
		boolean endGame = true;
		
		for(int i=0;i<game.length; i++) {
			if(i != game[i]) {
				endGame = false;
			}
		}
		
		return endGame;
	}
}
