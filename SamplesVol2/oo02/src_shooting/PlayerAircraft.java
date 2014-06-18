import java.awt.Color;

import obpro.cui.Random;
import obpro.gui.BCanvas;

/**
 * ���@��\������N���X
 */
public class PlayerAircraft {

	//�萔
	private final int ALIVE = 1;
	private final int EXPLODING = 2;
	private final int DEAD = 3;

	private final int EXPLODING_ANIMATION_COUNT = 10;

	//���
	private int liveState = ALIVE;
	private int explodingCount = 0;

	//����
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * �R���X�g���N�^
	 */
	public PlayerAircraft(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * �������擾����
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * �����擾����
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * X���W���擾����
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Y���W���擾����
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * ������
	 */
	public void move(int moveX, int moveY) {
		if (liveState == ALIVE) {
			x = x + moveX;
			y = y + moveY;
		}
	}
	
	/**
	 * �P�R�}�̏������s��	 
	 */
	public void processOneStep(){
		if (liveState == EXPLODING) {
			processExplode();
		}
	}

	private void processExplode() {
		explodingCount++;
		if (explodingCount == EXPLODING_ANIMATION_COUNT) {
			liveState = DEAD;
		}
	}

	public void explode() {
		if (liveState == ALIVE) {
			liveState = EXPLODING;
			explodingCount = 0;
		}
	}

	/**
	 * �G�Ƃ̏Փ˔��������
	 */
	public boolean intersects(EnemyAircraft enemy) {
		int player_leftX = this.getX();
		int player_rightX = this.getX() + this.getWidth();
		int enemy_leftX = enemy.getX();
		int enemy_rightX = enemy.getX() + enemy.getWidth();
		int player_topY = this.getY();
		int player_bottomY = this.getY() + this.getHeight();
		int enemy_topY = enemy.getY();
		int enemy_bottomY = enemy.getY() + enemy.getHeight();

		return (enemy_leftX < player_rightX && enemy_rightX > player_leftX
				&& enemy_topY < player_bottomY && enemy_bottomY > player_topY);
	}

	/**
	 * �`��
	 */
	public void draw(BCanvas canvas) {
		if (liveState == ALIVE) {
			drawAircraft(canvas);
		} else if (liveState == EXPLODING) {
			drawAircraft(canvas);
			drawExplosion(canvas);
		}
	}

	/**
	 * ��s�@��`�悷��
	 */
	private void drawAircraft(BCanvas canvas) {
		//���W�����߂�
		//�R�b�N�s�b�g
		int headX = x + width * 11 / 13;
		int headY = y + height * 4 / 5;

		//�{��
		int bodyX = x + width / 13;
		int bodyY = y + height * 2 / 5;
		int bodyWidth = width * 10 / 13;
		int bodyHeight = height * 2 / 5;

		//��������
		int verticalWingX1 = x + width * 2 / 13;
		int verticalWingX2 = x + width * 7 / 13;

		//��������
		int tailWingY = y + height * 3 / 5;
		int tailWingWidth = width / 13;
		int tailWingHeight = height / 5;

		//�{�̂�`��
		drawFillRectangle(canvas, Color.BLUE, bodyX, bodyY, bodyWidth,
				bodyHeight);
		canvas.drawFillTriangle(Color.BLUE, headX, bodyY, headX, headY, x
				+ width, headY);

		//����������`��
		drawFillRectangle(canvas, Color.BLACK, x, tailWingY, tailWingWidth,
				tailWingHeight);

		//����������`��
		canvas.drawFillTriangle(Color.GRAY, verticalWingX1, y, verticalWingX1,
				bodyY, verticalWingX2, bodyY);

		//�嗃��`��
		canvas.drawFillTriangle(Color.CYAN, verticalWingX1, tailWingY,
				verticalWingX2, tailWingY, bodyX, y + height);
	}

	/**
	 * ������`�悷��
	 */
	private void drawExplosion(BCanvas canvas) {
		// �΂̋ʂ̐������߂�
		int fireCount = explodingCount * 4;// �J�E���g���̂S�{�i���X�ɑ�����j

		// �΂̋ʂ�`�悷��
		for (int i = 0; i < fireCount; i++) {
			int fireX = x + Random.getInt(width);
			int fireY = y + Random.getInt(height);
			drawFire(canvas, fireX, fireY);
		}
	}

	/**
	 * �΂̋ʂ�`�悷��
	 */
	private void drawFire(BCanvas canvas, int x, int y) {
		canvas.drawFillArc(Color.RED, x, y, 20, 20, 0, 360);
		canvas.drawFillArc(Color.MAGENTA, x + 2, y + 2, 16, 16, 0, 360);
		canvas.drawFillArc(Color.WHITE, x + 1, y + 1, 14, 14, 0, 360);
		canvas.drawFillArc(Color.RED, x + 8, y + 1, 3, 3, 0, 360);
		canvas.drawFillArc(Color.RED, x + 2, y + 8, 3, 3, 0, 360);
		canvas.drawFillArc(Color.RED, x + 10, y + 8, 2, 3, 0, 360);
		canvas.drawFillArc(Color.RED, x, y + 1, 2, 2, 0, 360);
		canvas.drawFillArc(Color.RED, x + 15, y + 18, 2, 2, 0, 360);
	}

	/**
	 * �l�p��`�悷��(�h��Ԃ�)
	 */
	private void drawFillRectangle(BCanvas canvas, Color color, int x, int y,
			int width, int height) {
		canvas.drawFillTriangle(color, x, y, x + width, y, x + width, y
				+ height);
		canvas.drawFillTriangle(color, x, y, x, y + height, x + width, y
				+ height);
	}

}