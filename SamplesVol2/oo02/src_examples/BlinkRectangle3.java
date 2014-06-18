import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * �l�p�`��\������N���X�iEnum�o�[�W�����j
 */
public class BlinkRectangle3 {
	private enum SHOW_STATE {
		ON,
		OFF
	}
	
	private enum BLINKING_STATE {
		BLINKING,
		NOT_BLINKING
	}

	// ���
	private SHOW_STATE showState = SHOW_STATE.ON;
	private BLINKING_STATE blinkingState = BLINKING_STATE.NOT_BLINKING;

	// �l�p�`�̑���
	private Color color;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * �R���X�g���N�^
	 */
	public BlinkRectangle3(Color color, int x, int y, int width, int height) {
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
		if (blinkingState == BLINKING_STATE.BLINKING) {
			changeShowState();
		}
	}

	/**
	 * �\����Ԃ�ς���
	 */
	private void changeShowState() {
		if (showState == SHOW_STATE.ON) {
			showState = SHOW_STATE.OFF;
		} else if (showState == SHOW_STATE.OFF) {
			showState = SHOW_STATE.ON;
		}
	}

	/**
	 * �_�ŏ�Ԃ�ς���
	 */
	public void changeBlinkingState() {
		if (blinkingState == BLINKING_STATE.NOT_BLINKING) {
			blinkingState = BLINKING_STATE.BLINKING;
			showState = SHOW_STATE.ON;
		} else if (blinkingState == BLINKING_STATE.BLINKING) {
			blinkingState = BLINKING_STATE.NOT_BLINKING;
			showState = SHOW_STATE.ON;
		}
	}

	/**
	 * �`��
	 */
	public void draw(BCanvas canvas) {
		if (showState == SHOW_STATE.ON) {
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