import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * �l�p�`��\������N���X�i�_�ŋ@�\�t ���̂Q�j
 */
public class BlinkRectangle2 {
	// �萔
	private final int ON = 1;
	private final int OFF = 2;

	private final int BLINKING = 1;
	private final int NOT_BLINKING = 2;

	// ���
	private int showState = ON;
	private int blinkingState = NOT_BLINKING;

	// �l�p�`�̑���
	private Color color;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * �R���X�g���N�^
	 */
	public BlinkRectangle2(Color color, int x, int y, int width, int height) {
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
		// �\����Ԃ�ύX����
		if (blinkingState == BLINKING) {
			changeShowState();
		}
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
	 * �_�ŏ�Ԃ�ς���
	 */
	public void changeBlinkingState() {
		if (blinkingState == NOT_BLINKING) {
			blinkingState = BLINKING;
			showState = ON;
		} else if (blinkingState == BLINKING) {
			blinkingState = NOT_BLINKING;
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
		canvas.drawText(color, "blinkingState=" + blinkingState, x + width
				+ 100, y + height + 50);
	}

}