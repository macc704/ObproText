/**
 * ���т�\������N���X
 * 
 * @author Yoshiaki Matsuzawa
 * @version 1.0
 */
public class Score {

	private int score;
	private String name;

	/**
	 * �R���X�g���N�^
	 */
	public Score(int score, String name) {
		this.score = score;
		this.name = name;
	}

	/**
	 * ���O���擾���� 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * �_�����擾���� 
	 */
	public int getScore() {
		return this.score;
	}
}