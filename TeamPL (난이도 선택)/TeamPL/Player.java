package TeamPL;

public class Player {
	
	private String name;
	private String email;
	private int count;
	private int rank;
	
	public Player(String name, String email, int count, int rank) {
		this.name = name;
		this.email = email;
		this.count = count;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
