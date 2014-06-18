import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * 四角形を表現するクラス
 */
public class Rectangle {

	private Color color;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * コンストラクタ
	 */
	public Rectangle(Color color, int x, int y, int width, int height) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * 動かす
	 */
	public void move(int moveX, int moveY) {
		x = x + moveX;
		y = y + moveY;
	}

	/**
	 * 描く
	 */
	public void draw(BCanvas canvas) {
		canvas.drawLine(color, x, y, x + width, y);
		canvas.drawLine(color, x + width, y, x + width, y + height);
		canvas.drawLine(color, x + width, y + height, x, y + height);
		canvas.drawLine(color, x, y + height, x, y);
	}
}