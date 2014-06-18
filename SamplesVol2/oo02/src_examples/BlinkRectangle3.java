import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * 四角形を表現するクラス（Enumバージョン）
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

	// 状態
	private SHOW_STATE showState = SHOW_STATE.ON;
	private BLINKING_STATE blinkingState = BLINKING_STATE.NOT_BLINKING;

	// 四角形の属性
	private Color color;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * コンストラクタ
	 */
	public BlinkRectangle3(Color color, int x, int y, int width, int height) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * 1コマの処理を行う
	 */
	public void processOneStep() {
		// 表示状態を変更する
		if (blinkingState == BLINKING_STATE.BLINKING) {
			changeShowState();
		}
	}

	/**
	 * 表示状態を変える
	 */
	private void changeShowState() {
		if (showState == SHOW_STATE.ON) {
			showState = SHOW_STATE.OFF;
		} else if (showState == SHOW_STATE.OFF) {
			showState = SHOW_STATE.ON;
		}
	}

	/**
	 * 点滅状態を変える
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
	 * 描く
	 */
	public void draw(BCanvas canvas) {
		if (showState == SHOW_STATE.ON) {
			canvas.drawLine(color, x, y, x + width, y);
			canvas.drawLine(color, x + width, y, x + width, y + height);
			canvas.drawLine(color, x + width, y + height, x, y + height);
			canvas.drawLine(color, x, y + height, x, y);
		}

		// デバッグ出力
		canvas.drawText(color, "showState=" + showState, x + width + 100, y
				+ height);
		canvas.drawText(color, "blinkingState=" + blinkingState, x + width
				+ 100, y + height + 50);
	}

}