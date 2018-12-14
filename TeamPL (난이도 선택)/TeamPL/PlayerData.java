package TeamPL;

import java.io.*;
import java.util.*;

//플레이어 정보 데이터를 파일로 저장하는 메서드 선언.
public class PlayerData{
	
	static ArrayList<Player> playerList = new ArrayList<>();
	
	static void saveData() {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("C:\\Users\\kang7\\OneDrive\\문서\\player.data");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(playerList);
			System.out.println("플레이어 데이터가 정상적으로 저장되었습니다.");
		}catch(Exception e) {
			System.out.println("파일 저장에 실패했습니다.");
		}finally {
			try {
				fos.close(); oos.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	//저장된 플레이어 데이터를 불러오는 메서드 선언.
	static void loadData() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("C:\\Users\\kang7\\OneDrive\\문서\\player.data");
			ois = new ObjectInputStream(fis);

			playerList = (ArrayList<Player>) ois.readObject();

		} catch (Exception e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} finally {
			try {
				fis.close(); ois.close();
			} catch (Exception e2) {}
		}
	}
}