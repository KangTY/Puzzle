package TeamPL;

import java.util.Scanner;

public class Level {
	private String difficulty;
	private int level;
	private int highLevel = 5;
	private int midLevel = 4;
	private int lowLevel = 3;

	public int LevelDist(String difficulty) {
		this.difficulty = difficulty;
		
		switch(difficulty) {
		case "��":
			level = lowLevel;
			break;
		case "��":
			level = midLevel;
			break;
		case "��":
			level = highLevel;
			break;
		}
		return level;
	}
}

