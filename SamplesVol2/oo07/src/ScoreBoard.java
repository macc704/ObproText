import java.awt.Color;
import java.awt.Font;

import obpro.gui.BCanvas;

/**
 * スコア掲示板を表現するクラス
 */
public class ScoreBoard extends Component {

	private Font font = new Font("Dialog", Font.PLAIN, 24);
	private Color color = new Color(255, 255, 255);
	private int score;

	/**
	 * コンストラクタ
	 */
	public ScoreBoard(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * 得点を加える
	 */
	public void addScore(int score) {
		this.score += score;
	}

	/**
	 * 得点を消去する(現在は使われていない)
	 */
	public void resetScore() {
		this.score = 0;
	}

	/**
	 * 描画する
	 */
	public void draw(BCanvas canvas) {
		canvas.drawText(color, "SCORE  " + score, getX(), getY(), font);
	}

}