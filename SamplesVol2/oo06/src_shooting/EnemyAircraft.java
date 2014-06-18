import obpro.gui.BCanvas;
import obpro.sound.BSound;

/**
 * 敵機を表現するクラス
 */
public class EnemyAircraft extends Character {

	//定数
	private final int ALIVE = 1;
	private final int EXPLODING = 2;
	private final int DEAD = 3;

	private final int EXPLODING_ANIMATION_SIZE = 11;

	//状態
	private int liveState = ALIVE;
	private int explodingCount = 0;

	//関連参照
	private ShootingGame6 game;

	/**
	 * コンストラクタ
	 */
	public EnemyAircraft(int x, int y, ShootingGame6 game) {
		super(x, y, 100, 50);
		this.game = game;
	}

	/**
	 * 1ステップの処理をする(オーバーライド)
	 */
	public void processOneStep(BCanvas canvas) {
		if (liveState == ALIVE) {
			//動く
			move(-5, 0);

			//画面（左）外に出たら消滅
			if (getX() < -100) {
				destroy();
			}
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
	 * 消滅する
	 */
	public void destroy() {
		game.removeEnemy(this);
		liveState = DEAD;
	}

	/**
	 * 爆発の処理をする
	 */
	private void processExplode() {
		explodingCount++;
		if (explodingCount >= EXPLODING_ANIMATION_SIZE) {
			destroy();
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
		canvas.drawImage("img/explode" + (explodingCount + 1) + ".gif",
				getX(), getY(), getWidth(), getHeight());
	}

}