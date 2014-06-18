import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * 四角形を表現するクラス（点滅機能付 その２）
 */
public class BlinkRectangle2 {
	// 定数
	private final int ON = 1;
	private final int OFF = 2;

	private final int BLINKING = 1;
	private final int NOT_BLINKING = 2;

	// 状態
	private int showState = ON;
	private int blinkingState = NOT_BLINKING;

	// 四角形の属性
	private Color color;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * コンストラクタ
	 */
	public BlinkRectangle2(Color color, int x, int y, int width, int height) {
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
		if (blinkingState == BLINKING) {
			changeShowState();
		}
	}

	/**
	 * 表示状態を変える
	 */
	private void changeShowState() {
		if (showState == ON) {
			showState = OFF;
		} else if (showState == OFF) {
			showState = ON;
		}
	}

	/**
	 * 点滅状態を変える
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
	 * 描く
	 */
	public void draw(BCanvas canvas) {
		if (showState == ON) {
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