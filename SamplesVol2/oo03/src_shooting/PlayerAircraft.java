import java.awt.Color;

import obpro.cui.Random;
import obpro.gui.BCanvas;

/**
 * 自機を表現するクラス
 */
public class PlayerAircraft extends ShootingCharacter {

	//定数
	private final int ALIVE = 1;
	private final int EXPLODING = 2;
	private final int DEAD = 3;

	private final int EXPLODING_ANIMATION_SIZE = 10;

	//状態
	private int liveState = ALIVE;
	private int explodingCount = 0;

	/**
	 * コンストラクタ
	 */
	public PlayerAircraft(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * 動かす(オーバーライドによる再定義)
	 */
	public void move(int moveX, int moveY) {
		if (liveState == ALIVE) {
			super.move(moveX, moveY);
		}
	}

	/**
	 * １ステップの処理をする
	 */
	public void processOneStep() {
		processExplore();
	}

	/**
	 * 爆発の処理をする
	 */
	private void processExplore() {
		if (liveState == EXPLODING) {
			explodingCount++;
			if (explodingCount == EXPLODING_ANIMATION_SIZE) {
				liveState = DEAD;
			}
		}
	}

	/**
	 * 爆発する（爆発状態に遷移する）
	 */
	public void explode() {
		if (liveState == ALIVE) {
			liveState = EXPLODING;
			explodingCount = 0;
		}
	}

	/**
	 * 敵との衝突判定をする
	 */
	public boolean intersects(EnemyAircraft enemy) {
		int player_leftX = this.getX();
		int player_rightX = this.getX() + this.getWidth();
		int enemy_leftX = enemy.getX();
		int enemy_rightX = enemy.getX() + enemy.getWidth();
		int player_topY = this.getY();
		int player_bottomY = this.getY() + this.getHeight();
		int enemy_topY = enemy.getY();
		int enemy_bottomY = enemy.getY() + enemy.getHeight();

		return (enemy_leftX < player_rightX && enemy_rightX > player_leftX
				&& enemy_topY < player_bottomY && enemy_bottomY > player_topY);
	}

	/**
	 * 描く
	 */
	public void draw(BCanvas canvas) {
		if (liveState == ALIVE) {
			drawAircraft(canvas);
		} else if (liveState == EXPLODING) {
			drawAircraft(canvas);
			drawExplosion(canvas);
		}
	}

	/**
	 * 飛行機を描画する
	 */
	private void drawAircraft(BCanvas canvas) {
		//座標を決める
		//コックピット
		int headX = getX() + getWidth() * 11 / 13;
		int headY = getY() + getHeight() * 4 / 5;

		//本体
		int bodyX = getX() + getWidth() / 13;
		int bodyY = getY() + getHeight() * 2 / 5;
		int bodyWidth = getWidth() * 10 / 13;
		int bodyHeight = getHeight() * 2 / 5;

		//垂直尾翼
		int verticalWingX1 = getX() + getWidth() * 2 / 13;
		int verticalWingX2 = getX() + getWidth() * 7 / 13;

		//水平尾翼
		int tailWingY = getY() + getHeight() * 3 / 5;
		int tailWingWidth = getWidth() / 13;
		int tailWingHeight = getHeight() / 5;

		//本体を描く
		drawFillRectangle(canvas, Color.BLUE, bodyX, bodyY, bodyWidth,
				bodyHeight);
		canvas.drawFillTriangle(Color.BLUE, headX, bodyY, headX, headY, getX()
				+ getWidth(), headY);

		//水平尾翼を描く
		drawFillRectangle(canvas, Color.BLACK, getX(), tailWingY,
				tailWingWidth, tailWingHeight);

		//垂直尾翼を描く
		canvas.drawFillTriangle(Color.GRAY, verticalWingX1, getY(),
				verticalWingX1, bodyY, verticalWingX2, bodyY);

		//主翼を描く
		canvas.drawFillTriangle(Color.CYAN, verticalWingX1, tailWingY,
				verticalWingX2, tailWingY, bodyX, getY() + getHeight());
	}

	/**
	 * 爆発を描画する
	 */
	private void drawExplosion(BCanvas canvas) {
		// 火の玉の数を決める
		int fireCount = explodingCount * 4;// カウント数の４倍（徐々に増える）

		// 火の玉を描画する
		for (int i = 0; i < fireCount; i++) {
			int fireX = getX() + Random.getInt(getWidth());
			int fireY = getY() + Random.getInt(getHeight());
			drawFire(canvas, fireX, fireY);
		}
	}

	/**
	 * 火の玉を描画する
	 */
	private void drawFire(BCanvas canvas, int x, int y) {
		canvas.drawFillArc(Color.RED, x, y, 20, 20, 0, 360);
		canvas.drawFillArc(Color.MAGENTA, x + 2, y + 2, 16, 16, 0, 360);
		canvas.drawFillArc(Color.WHITE, x + 1, y + 1, 14, 14, 0, 360);
		canvas.drawFillArc(Color.RED, x + 8, y + 1, 3, 3, 0, 360);
		canvas.drawFillArc(Color.RED, x + 2, y + 8, 3, 3, 0, 360);
		canvas.drawFillArc(Color.RED, x + 10, y + 8, 2, 3, 0, 360);
		canvas.drawFillArc(Color.RED, x, y + 1, 2, 2, 0, 360);
		canvas.drawFillArc(Color.RED, x + 15, y + 18, 2, 2, 0, 360);
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