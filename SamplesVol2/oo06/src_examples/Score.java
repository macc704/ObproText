/**
 * 成績を表現するクラス
 * 
 * @author Yoshiaki Matsuzawa
 * @version 1.0
 */
public class Score {

	private int score;
	private String name;

	/**
	 * コンストラクタ
	 */
	public Score(int score, String name) {
		this.score = score;
		this.name = name;
	}

	/**
	 * 名前を取得する 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 点数を取得する 
	 */
	public int getScore() {
		return this.score;
	}
}