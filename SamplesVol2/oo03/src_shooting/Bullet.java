import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * 弾を表現するクラス
 */
public class Bullet extends ShootingCharacter {

	//定数
	private final int LIVE = 1;
	private final int DEAD = 2;

	//状態
	private int liveState = DEAD;

	//属性
	private Color color = new Color(0, 0, 255);

	/**
	 * コンストラクタ
	 */
	public Bullet(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * １ステップの処理をする
	 */
	public void processOneStep(BCanvas canvas) {
		if (liveState == LIVE) {
			//動かす
			move(15, 0);

			//画面外に出た場合の処理
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
			int x = player.getX() + player.getWidth() / 2 - getWidth() / 2;
			int y = player.getY() + player.getHeight() / 2 - getHeight() / 2;
			setLocation(x, y);
			liveState = LIVE;
		}
	}

	/**
	 * 弾を消滅させる（無効化する）
	 */
	public void destroy() {
		if (liveState == LIVE) {
			liveState = DEAD;
		}
	}

	/**
	 * 弾が有効かどうか調べる
	 */
	public boolean isAlive() {
		return liveState == LIVE;
	}

	/**
	 * 描く
	 */
	public void draw(BCanvas canvas) {
		if (isAlive()) {
			canvas.drawFillTriangle(color, getX(), getY(), getX() + getWidth(),
					getY(), getX(), getY() + getHeight());
			canvas.drawFillTriangle(color, getX(), getY() + getHeight(), getX()
					+ getWidth(), getY() + getHeight(), getX() + getWidth(),
					getY());
		}
	}

}