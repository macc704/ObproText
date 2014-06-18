import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * 四角形を表現するクラス（点滅機能付 その１）
 */
public class BlinkRectangle1 {

	// 定数
	private final int ON = 1;
	private final int OFF = 2;

	// 状態
	private int showState = ON;

	// 四角形の属性
	private Color color;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * コンストラクタ
	 */
	public BlinkRectangle1(Color color, int x, int y, int width, int height) {
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
		changeShowState();
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
	}

}