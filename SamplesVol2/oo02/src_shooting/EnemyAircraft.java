import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * �G�@��\������N���X
 */
public class EnemyAircraft {

	// ����
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * �R���X�g���N�^
	 */
	public EnemyAircraft(int x, int y, int width, int height) {
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
		x = x + moveX;
		y = y + moveY;
	}

	/**
	 * 1�R�}�̏������s��
	 */
	public void processOneStep() {
		move(-5, 0);
	}

	/**
	 * �`��
	 */
	public void draw(BCanvas canvas) {
		// ���W�����߂�
		// �{��
		int bodyHeight = height * 2 / 5;
		int bodyY = y + bodyHeight;
		int bodyWidth = width * 10 / 11;

		// ��������
		int verticalWingX = x + width * 5 / 11;

		// ��������
		int tailWingX = x + width * 10 / 11;
		int tailWingY = y + height * 3 / 5;
		int tailWingWidth = width / 11;
		int tailWingHeight = height / 5;

		// �R�b�N�s�b�g
		int cockpitX = x + tailWingWidth;
		int cockpitY = bodyY - tailWingWidth;
		int cockpitWidth = width * 2 / 11;

		// �嗃
		int mainWingX1 = x + width * 3 / 11;
		int mainWingX2 = x + width * 8 / 11;

		// �{�̂�`��
		drawFillRectangle(canvas, Color.BLACK, x, bodyY, bodyWidth, bodyHeight);
		canvas.drawFillArc(Color.GRAY, cockpitX, cockpitY, cockpitWidth,
				cockpitWidth, 0, 180);// �R�b�N�s�b�g

		// ����������`��
		drawFillRectangle(canvas, Color.BLUE, tailWingX, tailWingY,
				tailWingWidth, tailWingHeight);

		// ����������`��
		canvas.drawFillTriangle(Color.RED, verticalWingX, bodyY, tailWingX, y,
				tailWingX, bodyY);

		// �嗃��`��
		canvas.drawFillTriangle(Color.CYAN, mainWingX1, tailWingY, mainWingX2,
				tailWingY, tailWingX, y + height);
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