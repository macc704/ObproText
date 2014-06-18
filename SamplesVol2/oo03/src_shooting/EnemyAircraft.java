import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * �G�@��\������N���X
 */
public class EnemyAircraft extends ShootingCharacter {

	/**
	 * �R���X�g���N�^
	 */
	public EnemyAircraft(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * �P�X�e�b�v�̏���������
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
		int bodyHeight = getHeight() * 2 / 5;
		int bodyY = getY() + bodyHeight;
		int bodyWidth = getWidth() * 10 / 11;

		// ��������
		int verticalWingX = getX() + getWidth() * 5 / 11;

		// ��������
		int tailWingX = getX() + getWidth() * 10 / 11;
		int tailWingY = getY() + getHeight() * 3 / 5;
		int tailWingWidth = getWidth() / 11;
		int tailWingHeight = getHeight() / 5;

		// �R�b�N�s�b�g
		int cockpitX = getX() + tailWingWidth;
		int cockpitY = bodyY - tailWingWidth;
		int cockpitWidth = getWidth() * 2 / 11;

		// �嗃
		int mainWingX1 = getX() + getWidth() * 3 / 11;
		int mainWingX2 = getX() + getWidth() * 8 / 11;

		// �{�̂�`��
		drawFillRectangle(canvas, Color.BLACK, getX(), bodyY, bodyWidth,
				bodyHeight);
		canvas.drawFillArc(Color.GRAY, cockpitX, cockpitY, cockpitWidth,
				cockpitWidth, 0, 180);// �R�b�N�s�b�g

		// ����������`��
		drawFillRectangle(canvas, Color.BLUE, tailWingX, tailWingY,
				tailWingWidth, tailWingHeight);

		// ����������`��
		canvas.drawFillTriangle(Color.RED, verticalWingX, bodyY, tailWingX,
				getY(), tailWingX, bodyY);

		// �嗃��`��
		canvas.drawFillTriangle(Color.CYAN, mainWingX1, tailWingY, mainWingX2,
				tailWingY, tailWingX, getY() + getHeight());
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