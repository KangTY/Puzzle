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
 * 1. 그림퍼즐에 들어갈 그림 선택
 * 2. 시작할 떄 난이도를 입력받아서 버튼 수를 다르게 설정 (selectLevel.java 이용)(완료)
 * 3. 시간 and 카운트 계산 (완료)
 * 4. 버튼을 만들어서 원본 그림을 볼 수 있도록 설정 (image.java 이용)
 * 5. 프로그램 종료시 시스템 종료가 될 수 있도록 설정 (exit(0) 사용)
 */

//버튼을 이용한 그림퍼즐
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

	//원본 그림 읽기
	public void Puzzle() {
		
		MediaTracker tracker = new MediaTracker(this);
		original = Toolkit.getDefaultToolkit().getImage("C:\\Users\\kang7\\OneDrive\\바탕 화면\\2018학년도 수강 과목\\2학기\\프로그램설계방법론\\프로그램 설계 방법론\\src\\TeamPL\\Github.png");
		tracker.addImage(original, 0);
		
		try {
			tracker.waitForAll();
		} catch(InterruptedException e) {;}
		
		int width = original.getWidth(this)/size;
		int height = original.getHeight(this)/size;
		setSize(new Dimension(width*size,height*size));
		
		//이미지를 잘라 넣자
		img = new BufferedImage[size*size];
		int cnt=0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				img[cnt] = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g = img[cnt].getGraphics();
				//원본이미지에서 필요한 부분만 잘라서 그리기
				g.drawImage(original, 0, 0, width, height, j*width, i*height, (j+1)*width, (i+1)*height, this);
				cnt++;
			}
		}
		
		//게임배열
		game = new int[size*size];
		
		//버튼을 만들기
		btn = new JButton[size*size];
		
		for(int i=0;i<size*size;i++) {
			btn[i] = new JButton();
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		
		//숫자 섞고 버튼에 이미지 입히기
		shuffle();
		setLayout(new GridLayout(size, size));
		
		setResizable(false);
		setVisible(true);
		
		start = System.currentTimeMillis(); //시작 시간 측정
	}
	
	//숫자 섞고 버튼에 이미지 입히기
	private void shuffle() {
		Random rnd = new Random();
		
		do {
			for(int i=0; i<size*size; i++) 
				game[i]=0;
			
			//배열의 중복값 없이 넣기
			for(int i=0; i<size*size; i++) {
				int temp=0;
				do {
					temp = rnd.nextInt(size*size);
				}while(game[temp] != 0);
				game[temp] = i;
			}
		}while(endGame()); //섞이지 않았을 때 다시 섞어라!!
		
		//배열값으로 이미지를 선택해서 버튼에 부여
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
		
		//첫번째 클릭이면
		if(clickCount==0) {
			count++;
			clickCount++;
			oldNum = curNum;
		} else {
			
			//두번째 클릭이면
			if(oldNum != curNum) { //이전 것과 같지 않다면
				count++;
				
				//이미지 변경
				btn[oldNum].setIcon(new ImageIcon(img[game[curNum]]));
				btn[curNum].setIcon(new ImageIcon(img[game[oldNum]]));
				
				//배열값 변경
				int t = game[oldNum];
				game[oldNum] = game[curNum];
				game[curNum] = t;
				
				//여기서 게임 종료 확인
				if(endGame()) {
					end = System.currentTimeMillis(); //종료 시간 측정
					time = (end - start)/(long)1000.0;
					JOptionPane.showMessageDialog(this, "퍼즐 완성까지 "+ (count/2) + "회 이동, " + (end-start)/(long)1000+ "초 소요!");
					
					//게임 재시작을 확인
					int reStart = JOptionPane.showConfirmDialog(this, "한 번 더?", "프로그램 종료?", JOptionPane.YES_NO_OPTION);
					if(reStart == JOptionPane.YES_OPTION) {
						shuffle(); //배열 다시 섞기
						repaint(); //다시 그리기
						start = System.currentTimeMillis(); //시작 시간 측정
						System.out.println(start);
					}else {
						System.exit(0);
					}
				}
			}
			clickCount = 0;
		}
	}
	
	//게임 종료를 확인하는 메소드
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
