import java.awt.Color;
import java.awt.Font;

import obpro.gui.BCanvas;

/**
 * �X�R�A�f����\������N���X
 */
public class ScoreBoard extends Component {

	private Font font = new Font("Dialog", Font.PLAIN, 24);
	private Color color = new Color(255, 255, 255);
	private int score;

	/**
	 * �R���X�g���N�^
	 */
	public ScoreBoard(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * ���_��������
	 */
	public void addScore(int score) {
		this.score += score;
	}

	/**
	 * ���_����������(���݂͎g���Ă��Ȃ�)
	 */
	public void resetScore() {
		this.score = 0;
	}

	/**
	 * �`�悷��
	 */
	public void draw(BCanvas canvas) {
		canvas.drawText(color, "SCORE  " + score, getX(), getY(), font);
	}

}