import java.util.ArrayList;
import java.util.List;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;
import obpro.sound.BSound;

/**
 * シューティングゲームサンプル（その5　リスト導入，オプション導入）
 * 
 * @author macchan
 * @date 2005/06/22 オブプロ第11回
 * @version 1.0
 */
public class ShootingGame5 {

	public static void main(String[] args) {
		ShootingGame5 shootingGame = new ShootingGame5();
		shootingGame.main();
	}

	// ウインドウ
	private BWindow window;

	// アニメーションオブジェクトの集合
	private List<AnimationElement> elements = new ArrayList<AnimationElement>();

	// 種類別アニメーションオブジェクト
	private Background background;
	private PlayerAircraft player;
	private List<EnemyAircraft> enemies = new ArrayList<EnemyAircraft>();
	private List<Bullet> bullets = new ArrayList<Bullet>();

	// BGM
	private BSound bgm;

	private void main() {
		openWindow();
		doAnimation();
	}

	// ウインドウを開く
	private void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	// アニメーションする
	private void doAnimation() {
		// アニメーションの準備をする
		BCanvas canvas = window.getCanvas();
		initializeElements();
		initializeSounds();

		// アニメーションする
		bgm.loop();
		while (true) {
			{// １コマの処理を行う
				// ゲーム全体としての1コマの処理を行う
				processOneStepForGame(canvas);

				// 各オブジェクトの1コマの処理を行う
				for (int i = 0; i < elements.size(); i++) {
					AnimationElement element = (AnimationElement) elements
							.get(i);
					element.processOneStep(canvas);
				}
			}

			// 図形を描く
			canvas.clear();
			for (int i = 0; i < elements.size(); i++) {
				AnimationElement element = (AnimationElement) elements.get(i);
				element.draw(canvas);
			}
			canvas.update();

			// 眠る
			canvas.sleep(0.01);
		}
	}

	/**
	 * 各オブジェクトを初期化する
	 */
	private void initializeElements() {
		// 背景
		background = new Background();
		elements.add(background);

		// プレイヤー
		player = new PlayerAircraft(50, 50, this);
		elements.add(player);
	}

	/**
	 * サウンドを初期化する
	 */
	private void initializeSounds() {
		// BGM
		bgm = new BSound("sound/bgm.mp3");

		// 効果音はメモリ上に読み込む
		BSound.load("sound/explode_enemy.mp3");
		BSound.load("sound/explode_player.mp3");
		BSound.load("sound/fire.mp3");
		BSound.load("sound/optionvoice.mp3");
		BSound.load("sound/powerup.mp3");
	}

	/**
	 * ゲーム全体としての1ステップの処理を行う
	 */
	private void processOneStepForGame(BCanvas canvas) {
		// 敵を出す
		int randomNumber = (int) (Math.random() * 30);// 確率1/30コマの抽選
		if (randomNumber == 0) {
			int y = (int) (Math.random() * canvas.getCanvasHeight());// y座標決め抽選
			EnemyAircraft enemy = new EnemyAircraft(canvas.getCanvasWidth(), y,
					this);
			addEnemy(enemy);
		}

		// 自機と敵の当たり判定とあたった場合の処理を行う
		for (int i = 0; i < enemies.size(); i++) {
			EnemyAircraft enemy = (EnemyAircraft) enemies.get(i);
			if (enemy.isAlive() && player.intersects(enemy)) {
				player.explode();
			}
		}

		// 弾と敵の当たり判定とあたった場合の処理を行う
		for (int i = 0; i < enemies.size(); i++) {
			EnemyAircraft enemy = (EnemyAircraft) enemies.get(i);
			for (int j = 0; j < bullets.size(); j++) {
				Bullet bullet = (Bullet) bullets.get(j);
				if (bullet.isAlive() && enemy.isAlive()
						&& enemy.intersects(bullet)) {
					enemy.explode();
					bullet.destroy();
				}
			}
		}
	}

	/**
	 * 敵を追加する
	 */
	public void addEnemy(EnemyAircraft enemy) {
		enemies.add(enemy);
		elements.add(enemy);
	}

	/**
	 * 敵を削除する
	 */
	public void removeEnemy(EnemyAircraft enemy) {
		enemies.remove(enemy);
		elements.remove(enemy);
	}

	/**
	 * 弾を追加する
	 */
	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
		elements.add(bullet);
	}

	/**
	 * 弾を削除する
	 */
	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
		elements.remove(bullet);
	}

}