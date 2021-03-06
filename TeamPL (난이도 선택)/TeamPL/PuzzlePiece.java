package TeamPL;

/** PuzzlePiece  defines of a puzzle playing piece */
public class PuzzlePiece {
	private int face_value;  // 퍼즐 조각의 표면에 쓰여진 번호

	/** Constructor PuzzlePiece creates a piece
	 * @param value - the value that appears on the face of the piece */
	public PuzzlePiece(int value) {
		face_value = value;
	}

	/** valueOf returns the face value of the piece */
	public int valueOf() {
		return face_value;
	}
}