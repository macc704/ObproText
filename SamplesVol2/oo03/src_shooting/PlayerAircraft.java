import java.awt.Color;

import obpro.cui.Random;
import obpro.gui.BCanvas;

/**
 * ���@��\������N���X
 */
public class PlayerAircraft extends ShootingCharacter {

	//�萔
	private final int ALIVE = 1;
	private final int EXPLODING = 2;
	private final int DEAD = 3;

	private final int EXPLODING_ANIMATION_SIZE = 10;

	//���
	private int liveState = ALIVE;
	private int explodingCount = 0;

	/**
	 * �R���X�g���N�^
	 */
	public PlayerAircraft(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * ������(�I�[�o�[���C�h�ɂ��Ē�`)
	 */
	public void move(int moveX, int moveY) {
		if (liveState == ALIVE) {
			super.move(moveX, moveY);
		}
	}

	/**
	 * �P�X�e�b�v�̏���������
	 */
	public void processOneStep() {
		processExplore();
	}

	/**
	 * �����̏���������
	 */
	private void processExplore() {
		if (liveState == EXPLODING) {
			explodingCount++;
			if (explodingCount == EXPLODING_ANIMATION_SIZE) {
				liveState = DEAD;
			}
		}
	}

	/**
	 * ��������i������ԂɑJ�ڂ���j
	 */
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
		int headX = getX() + getWidth() * 11 / 13;
		int headY = getY() + getHeight() * 4 / 5;

		//�{��
		int bodyX = getX() + getWidth() / 13;
		int bodyY = getY() + getHeight() * 2 / 5;
		int bodyWidth = getWidth() * 10 / 13;
		int bodyHeight = getHeight() * 2 / 5;

		//��������
		int verticalWingX1 = getX() + getWidth() * 2 / 13;
		int verticalWingX2 = getX() + getWidth() * 7 / 13;

		//��������
		int tailWingY = getY() + getHeight() * 3 / 5;
		int tailWingWidth = getWidth() / 13;
		int tailWingHeight = getHeight() / 5;

		//�{�̂�`��
		drawFillRectangle(canvas, Color.BLUE, bodyX, bodyY, bodyWidth,
				bodyHeight);
		canvas.drawFillTriangle(Color.BLUE, headX, bodyY, headX, headY, getX()
				+ getWidth(), headY);

		//����������`��
		drawFillRectangle(canvas, Color.BLACK, getX(), tailWingY,
				tailWingWidth, tailWingHeight);

		//����������`��
		canvas.drawFillTriangle(Color.GRAY, verticalWingX1, getY(),
				verticalWingX1, bodyY, verticalWingX2, bodyY);

		//�嗃��`��
		canvas.drawFillTriangle(Color.CYAN, verticalWingX1, tailWingY,
				verticalWingX2, tailWingY, bodyX, getY() + getHeight());
	}

	/**
	 * ������`�悷��
	 */
	private void drawExplosion(BCanvas canvas) {
		// �΂̋ʂ̐������߂�
		int fireCount = explodingCount * 4;// �J�E���g���̂S�{�i���X�ɑ�����j

		// �΂̋ʂ�`�悷��
		for (int i = 0; i < fireCount; i++) {
			int fireX = getX() + Random.getInt(getWidth());
			int fireY = getY() + Random.getInt(getHeight());
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