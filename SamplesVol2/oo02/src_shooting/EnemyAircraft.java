import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * 敵機を表現するクラス
 */
public class EnemyAircraft {

	// 属性
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * コンストラクタ
	 */
	public EnemyAircraft(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * 高さを取得する
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * 幅を取得する
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * X座標を取得する
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Y座標を取得する
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * 動かす
	 */
	public void move(int moveX, int moveY) {
		x = x + moveX;
		y = y + moveY;
	}

	/**
	 * 1コマの処理を行う
	 */
	public void processOneStep() {
		move(-5, 0);
	}

	/**
	 * 描く
	 */
	public void draw(BCanvas canvas) {
		// 座標を決める
		// 本体
		int bodyHeight = height * 2 / 5;
		int bodyY = y + bodyHeight;
		int bodyWidth = width * 10 / 11;

		// 垂直尾翼
		int verticalWingX = x + width * 5 / 11;

		// 水平尾翼
		int tailWingX = x + width * 10 / 11;
		int tailWingY = y + height * 3 / 5;
		int tailWingWidth = width / 11;
		int tailWingHeight = height / 5;

		// コックピット
		int cockpitX = x + tailWingWidth;
		int cockpitY = bodyY - tailWingWidth;
		int cockpitWidth = width * 2 / 11;

		// 主翼
		int mainWingX1 = x + width * 3 / 11;
		int mainWingX2 = x + width * 8 / 11;

		// 本体を描く
		drawFillRectangle(canvas, Color.BLACK, x, bodyY, bodyWidth, bodyHeight);
		canvas.drawFillArc(Color.GRAY, cockpitX, cockpitY, cockpitWidth,
				cockpitWidth, 0, 180);// コックピット

		// 水平尾翼を描く
		drawFillRectangle(canvas, Color.BLUE, tailWingX, tailWingY,
				tailWingWidth, tailWingHeight);

		// 垂直尾翼を描く
		canvas.drawFillTriangle(Color.RED, verticalWingX, bodyY, tailWingX, y,
				tailWingX, bodyY);

		// 主翼を描く
		canvas.drawFillTriangle(Color.CYAN, mainWingX1, tailWingY, mainWingX2,
				tailWingY, tailWingX, y + height);
	}

	/**
	 * 四角を描画する(塗りつぶし)
	 */
	private void drawFillRectangle(BCanvas canvas, Color color, int x, int y,
			int width, int height) {
		canvas.drawFillTriangle(color, x, y, x + width, y, x + width, y
				+ height);
		canvas.drawFillTriangle(color, x, y, x, y + height, x + width, y
				+ height);
	}

}