import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * 敵機を表現するクラス
 */
public class EnemyAircraft extends ShootingCharacter {

	/**
	 * コンストラクタ
	 */
	public EnemyAircraft(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * １ステップの処理をする
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
		int bodyHeight = getHeight() * 2 / 5;
		int bodyY = getY() + bodyHeight;
		int bodyWidth = getWidth() * 10 / 11;

		// 垂直尾翼
		int verticalWingX = getX() + getWidth() * 5 / 11;

		// 水平尾翼
		int tailWingX = getX() + getWidth() * 10 / 11;
		int tailWingY = getY() + getHeight() * 3 / 5;
		int tailWingWidth = getWidth() / 11;
		int tailWingHeight = getHeight() / 5;

		// コックピット
		int cockpitX = getX() + tailWingWidth;
		int cockpitY = bodyY - tailWingWidth;
		int cockpitWidth = getWidth() * 2 / 11;

		// 主翼
		int mainWingX1 = getX() + getWidth() * 3 / 11;
		int mainWingX2 = getX() + getWidth() * 8 / 11;

		// 本体を描く
		drawFillRectangle(canvas, Color.BLACK, getX(), bodyY, bodyWidth,
				bodyHeight);
		canvas.drawFillArc(Color.GRAY, cockpitX, cockpitY, cockpitWidth,
				cockpitWidth, 0, 180);// コックピット

		// 水平尾翼を描く
		drawFillRectangle(canvas, Color.BLUE, tailWingX, tailWingY,
				tailWingWidth, tailWingHeight);

		// 垂直尾翼を描く
		canvas.drawFillTriangle(Color.RED, verticalWingX, bodyY, tailWingX,
				getY(), tailWingX, bodyY);

		// 主翼を描く
		canvas.drawFillTriangle(Color.CYAN, mainWingX1, tailWingY, mainWingX2,
				tailWingY, tailWingX, getY() + getHeight());
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