import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * �l�p�`��\������N���X�i�_�ŋ@�\�t ���̂P�j
 */
public class BlinkRectangle1 {

	// �萔
	private final int ON = 1;
	private final int OFF = 2;

	// ���
	private int showState = ON;

	// �l�p�`�̑���
	private Color color;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * �R���X�g���N�^
	 */
	public BlinkRectangle1(Color color, int x, int y, int width, int height) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * 1�R�}�̏������s��
	 */
	public void processOneStep() {
		changeShowState();
	}

	/**
	 * �\����Ԃ�ς���
	 */
	private void changeShowState() {
		if (showState == ON) {
			showState = OFF;
		} else if (showState == OFF) {
			showState = ON;
		}
	}

	/**
	 * �`��
	 */
	public void draw(BCanvas canvas) {
		if (showState == ON) {
			canvas.drawLine(color, x, y, x + width, y);
			canvas.drawLine(color, x + width, y, x + width, y + height);
			canvas.drawLine(color, x + width, y + height, x, y + height);
			canvas.drawLine(color, x, y + height, x, y);
		}

		// �f�o�b�O�o��
		canvas.drawText(color, "showState=" + showState, x + width + 100, y
				+ height);
	}

}