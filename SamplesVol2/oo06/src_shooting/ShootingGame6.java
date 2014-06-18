import java.util.ArrayList;
import java.util.List;

import obpro.gui.BCanvas;
import obpro.sound.BSound;

/**
 * シューティングゲームサンプル（その６　フレームワークのコンポーネントとする）
 * 
 * @author macchan
 * @date 2005/07/7 オブプロ第12回
 * @version 1.0
 */
public class ShootingGame6 extends AbstractGUIAnimationApplication {

	public static void main(String[] args) {
		GUIAnimationApplicationEngine game = new GUIAnimationApplicationEngine(
				new ShootingGame6());
		game.run();
	}

	// 種類別アニメーションオブジェクト
	private Background background;
	private ScoreBoard scoreBoard;
	private PlayerAircraft player;
	private List<EnemyAircraft> enemies = new ArrayList<EnemyAircraft>();
	private List<Bullet> bullets = new ArrayList<Bullet>();

	// BGM
	BSound bgm;

	/**
	 * 各オブジェクトを初期化する
	 */
	public void prepareAnimationStart() {
		// ステップの間隔を設定する
		getEngine().setStepInterval(0.01);

		// BGM
		initializeSounds();
		bgm.loop();

		// 背景
		background = new Background();
		getEngine().addElement(background);

		// 得点板
		scoreBoard = new ScoreBoard(100, 30, 0, 0);
		getEngine().addElement(scoreBoard);

		// プレイヤー
		player = new PlayerAircraft(50, 50, this);
		getEngine().addElement(player);
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
	public void processOneStepForApplication(BCanvas canvas) {
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
					scoreBoard.addScore(100);
				}
			}
		}
	}

	/**
	 * 敵を追加する
	 */
	public void addEnemy(EnemyAircraft enemy) {
		enemies.add(enemy);
		getEngine().addElement(enemy);
	}

	/**
	 * 敵を削除する
	 */
	public void removeEnemy(EnemyAircraft enemy) {
		enemies.remove(enemy);
		getEngine().removeElement(enemy);
	}

	/**
	 * 弾を追加する
	 */
	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
		getEngine().addElement(bullet);
	}

	/**
	 * 弾を削除する
	 */
	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
		getEngine().removeElement(bullet);
	}

}