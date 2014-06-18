import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * 弾を表現するクラス
 */
public class Bullet {

	// 定数
	private final int ALIVE = 1;
	private final int DEAD = 2;

	// 状態
	private int liveState = DEAD;

	// 属性
	private Color color = new Color(0, 0, 255);
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * コンストラクタ
	 */
	public Bullet(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * X座標を取得する
	 */
	public int getX() {
		return x;
	}

	/**
	 * Y座標を取得する
	 */
	public int getY() {
		return y;
	}

	/**
	 * 動かす
	 */
	public void move(int moveX, int moveY) {
		if (liveState == ALIVE) {
			x = x + moveX;
			y = y + moveY;
		}
	}

	/**
	 * １ステップの処理をする
	 */
	public void processOneStep(BCanvas canvas) {
		if (isLive()) {
			move(15, 0);// 動かす

			// 画面外に出た場合の処理
			if (getX() > canvas.getCanvasWidth()) {
				destroy();
			}
		}
	}

	/**
	 * 弾を発射する（有効化する）
	 */
	public void fire(PlayerAircraft player) {
		if (liveState == DEAD) {
			this.x = player.getX() + player.getWidth() / 2 - width / 2;
			this.y = player.getY() + player.getHeight() / 2 - height / 2;
			liveState = ALIVE;
		}
	}

	/**
	 * 弾を消滅させる（無効化する）
	 */
	public void destroy() {
		if (liveState == ALIVE) {
			liveState = DEAD;
		}
	}

	/**
	 * 弾が有効かどうか調べる
	 */
	public boolean isLive() {
		return liveState == ALIVE;
	}

	/**
	 * 描く
	 */
	public void draw(BCanvas canvas) {
		if (liveState == ALIVE) {
			canvas.drawFillTriangle(color, x, y, x + width, y, x, y + height);
			canvas.drawFillTriangle(color, x, y + height, x + width,
					y + height, x + width, y);
		}
	}

}