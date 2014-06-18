import obpro.gui.BCanvas;
import obpro.sound.BSound;

/**
 * 敵機を表現するクラス
 */
public class EnemyAircraft extends ShootingCharacter {

	// 定数
	private final int ALIVE = 1;
	private final int EXPLODING = 2;
	private final int DEAD = 3;

	private final int EXPLODING_ANIMATION_SIZE = 11;

	// 状態
	private int liveState = DEAD;
	private int explodingCount = 0;

	/**
	 * コンストラクタ
	 */
	public EnemyAircraft(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * 1ステップの処理をする(オーバーライド)
	 */
	public void processOneStep(BCanvas canvas) {
		if (liveState == ALIVE) {
			move(-5, 0);
		} else if (liveState == EXPLODING) {
			processExplode();
		}
	}

	/**
	 * 活きているかどうか調べる
	 */
	public boolean isAlive() {
		return liveState == ALIVE;
	}

	/**
	 * 出現させる
	 */
	public void show(int x, int y) {
		if (liveState == DEAD) {
			setLocation(x, y);
			liveState = ALIVE;
		}
	}

	/**
	 * 爆発の処理をする
	 */
	private void processExplode() {
		explodingCount++;
		if (explodingCount >= EXPLODING_ANIMATION_SIZE) {
			liveState = DEAD;
		}
	}

	/**
	 * 爆発する（爆発状態に遷移する）
	 */
	public void explode() {
		if (liveState == ALIVE) {
			liveState = EXPLODING;
			explodingCount = 0;
			BSound.play("sound/explode_enemy.mp3");
		}
	}

	/**
	 * 描画する（オーバーライド）
	 */
	public void draw(BCanvas canvas) {
		if (liveState == ALIVE) {
			drawAircraft(canvas);
		} else if (liveState == EXPLODING) {
			drawExplosion(canvas);
		}
	}

	/**
	 * 飛行機を描画する
	 */
	private void drawAircraft(BCanvas canvas) {
		canvas.drawImage("img/enemy.png", getX(), getY(), getWidth(),
				getHeight());
	}

	/**
	 * 爆発を描画する
	 */
	private void drawExplosion(BCanvas canvas) {
		canvas.drawImage("img/explode" + (explodingCount + 1) + ".gif", getX(),
				getY(), getWidth(), getHeight());
	}

}