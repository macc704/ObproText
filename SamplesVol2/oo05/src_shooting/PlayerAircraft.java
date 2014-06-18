import java.util.ArrayList;
import java.util.List;

import obpro.gui.BCanvas;
import obpro.sound.BSound;

/**
 * 自機を表現するクラス
 */
public class PlayerAircraft extends ShootingCharacter {

	// 定数
	private final int ALIVE = 1;
	private final int EXPLODING = 2;
	private final int DEAD = 3;

	private final int EXPLODING_ANIMATION_SIZE = 11;

	// 状態
	private int liveState = ALIVE;
	private int explodingCount = 0;

	// 関連参照
	private ShootingGame5 game;
	private List<Option> options = new ArrayList<Option>();

	/**
	 * コンストラクタ
	 */
	public PlayerAircraft(int x, int y, ShootingGame5 game) {
		super(x, y, 100, 50);
		this.game = game;
	}

	/**
	 * 動く
	 */
	public void move(int moveX, int moveY) {
		// 自機を動かす
		super.move(moveX, moveY);

		// オプションを動かす
		for (int i = 0; i < options.size(); i++) {
			Option option = (Option) options.get(i);
			option.move(moveX, moveY);
		}
	}

	/**
	 * 1ステップの処理をする(オーバーライド)
	 */
	public void processOneStep(BCanvas canvas) {
		if (liveState == ALIVE) {
			// 矢印キー入力によって自機を操作する
			if (canvas.isKeyPressing(37)) {// 左キー
				move(-5, 0);
			}
			if (canvas.isKeyPressing(38)) {// 上キー
				move(0, -5);
			}
			if (canvas.isKeyPressing(39)) {// 右キー
				move(5, 0);
			}
			if (canvas.isKeyPressing(40)) {// 下キー
				move(0, 5);
			}

			// Fキー入力によって弾を出す
			if (canvas.isKeyDown()) {
				int keyCode = canvas.getKeyCode();
				if (keyCode == 70) {// fキー
					fire();
				}
			}

			// Gキー入力によってオプションを出す
			if (canvas.isKeyDown()) {
				int keyCode = canvas.getKeyCode();
				if (keyCode == 71) {// gキー
					BSound.play("sound/optionvoice.mp3", 100);
					BSound.play("sound/powerup.mp3");
					options.add(new Option(getX(), getY(), getWidth(),
							getHeight(), options.size() + 1));
				}
			}

			// オプションの1ステップの処理を行なう
			for (int i = 0; i < options.size(); i++) {
				Option option = (Option) options.get(i);
				option.processOneStep(canvas);
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
			BSound.play("sound/explode_player.mp3");
		}
	}

	/**
	 * 描画する（オーバーライド）
	 */
	public void draw(BCanvas canvas) {
		if (liveState == ALIVE) {
			// 自機を書く
			drawAircraft(canvas);

			// オプションを書く
			for (int i = 0; i < options.size(); i++) {
				Option option = (Option) options.get(i);
				option.draw(canvas);
			}
		} else if (liveState == EXPLODING) {
			drawExplosion(canvas);
		}
	}

	/**
	 * 飛行機を描画する
	 */
	private void drawAircraft(BCanvas canvas) {
		canvas.drawImage("img/player.png", getX(), getY(), getWidth(),
				getHeight());
	}

	/**
	 * 爆発を描画する
	 */
	private void drawExplosion(BCanvas canvas) {
		canvas.drawImage("img/explode" + (explodingCount + 1) + ".gif", getX(),
				getY(), getWidth(), getHeight());
	}

	/**
	 * 弾を出す
	 */
	private void fire() {
		if (liveState == ALIVE) {
			BSound.play("sound/fire.mp3");

			// 自機の弾を出す
			fire(this);

			// オプションの弾を出す
			for (int i = 0; i < options.size(); i++) {
				Option option = (Option) options.get(i);
				fire(option);
			}
		}
	}

	/**
	 * （オプション一つごとの）弾を出す
	 */
	private void fire(ShootingCharacter shooter) {
		Bullet bullet = new Bullet(0, 0, 20, 10, game);
		int x = shooter.getX() + shooter.getWidth() / 2 - bullet.getWidth() / 2;
		int y = shooter.getY() + shooter.getHeight() / 2 - bullet.getHeight()
				/ 2;
		bullet.setLocation(x, y);
		game.addBullet(bullet);
	}
}