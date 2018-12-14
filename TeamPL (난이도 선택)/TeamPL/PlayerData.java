package TeamPL;

import java.io.*;
import java.util.*;

//�÷��̾� ���� �����͸� ���Ϸ� �����ϴ� �޼��� ����.
public class PlayerData{
	
	static ArrayList<Player> playerList = new ArrayList<>();
	
	static void saveData() {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("C:\\Users\\kang7\\OneDrive\\����\\player.data");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(playerList);
			System.out.println("�÷��̾� �����Ͱ� ���������� ����Ǿ����ϴ�.");
		}catch(Exception e) {
			System.out.println("���� ���忡 �����߽��ϴ�.");
		}finally {
			try {
				fos.close(); oos.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	//����� �÷��̾� �����͸� �ҷ����� �޼��� ����.
	static void loadData() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("C:\\Users\\kang7\\OneDrive\\����\\player.data");
			ois = new ObjectInputStream(fis);

			playerList = (ArrayList<Player>) ois.readObject();

		} catch (Exception e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} finally {
			try {
				fis.close(); ois.close();
			} catch (Exception e2) {}
		}
	}
}