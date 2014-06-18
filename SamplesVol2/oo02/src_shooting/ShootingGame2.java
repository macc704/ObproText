import java.util.ArrayList;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * シューティングゲームサンプル （その２ 弾出し & スムースな自機操作）
 * 
 * @author macchan
 * @date 2005/06/08 オブプロ第8回
 * @date 2007/06/21 コレクション(ArrayList)を使うように修正
 * @version 1.1
 */
public class ShootingGame2 {

	public static void main(String[] args) {
		ShootingGame2 shootingGame = new ShootingGame2();
		shootingGame.main();
	}

	BWindow window;

	PlayerAircraft player;
	EnemyAircraft enemy;
	// ArrayListバージョン
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	// 配列バージョン
	// Bullet[] bullets = new Bullet[3];

	void main() {
		openWindow();
		doAnimation();
	}

	// ウインドウを開く
	void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	// アニメーションする
	void doAnimation() {
		BCanvas canvas = window.getCanvas();// キャンバスを取得する
		initializeObjects();// オブジェクトを初期化する

		// アニメーションする
		while (true) {
			// １コマの処理を行う
			processOneStep(canvas);

			// 図形を描く
			canvas.clear();
			draw(canvas);
			canvas.update();

			// 眠る
			canvas.sleep(0.05);
		}
	}

	// オブジェクトを初期化する
	private void initializeObjects() {
		player = new PlayerAircraft(50, 50, 100, 50);
		enemy = new EnemyAircraft(400, 50, 100, 50);
		// ArrayListバージョン
		for (int i = 0; i < 3; i++) {
			bullets.add(new Bullet(-1, -1, 20, 10));
		}
		// 配列バージョン
		// for (int i = 0; i < bullets.length; i++) {
		// bullets[i] = new Bullet(-1, -1, 20, 10);
		// }
	}

	// １コマの処理を行う
	private void processOneStep(BCanvas canvas) {
		// (キー入力によって)自機を操作する
		if (canvas.isKeyPressing(37)) {// 左キー
			player.move(-5, 0);
		}
		if (canvas.isKeyPressing(38)) {// 上キー
			player.move(0, -5);
		}
		if (canvas.isKeyPressing(39)) {// 右キー
			player.move(5, 0);
		}
		if (canvas.isKeyPressing(40)) {// 下キー
			player.move(0, 5);
		}

		// キー入力によって弾を出す
		if (canvas.isKeyDown()) {
			int keyCode = canvas.getKeyCode();
			if (keyCode == 70) {// fキー
				// （有効でない弾を探して）弾を発射する
				// ArrayListバージョン
				for (Bullet bullet : bullets) {
					if (bullet.isLive() == false) {
						bullet.fire(player);
						break;
					}
				}
				// 配列バージョン
				// for (int i = 0; i < bullets.length; i++) {
				// if (bullets[i].isLive() == false) {
				// bullets[i].fire(player);
				// break;
				// }
				// }
			}
		}

		// 各オブジェクトの1コマの処理を行う
		player.processOneStep();
		enemy.processOneStep();
		// ArrayListバージョン
		for (Bullet bullet : bullets) {
			bullet.processOneStep(canvas);
		}
		// 配列バージョン
		// for (int i = 0; i < bullets.length; i++) {
		// bullets[i].processOneStep(canvas);
		// }

		// 当たり判定を行う
		if (player.intersects(enemy)) {
			player.explode();
		}
	}

	// 図形を描く
	private void draw(BCanvas canvas) {
		player.draw(canvas);
		enemy.draw(canvas);
		// ArrayListバージョン
		for (Bullet bullet : bullets) {
			bullet.draw(canvas);
		}
		// 配列バージョン
		// for (int i = 0; i < bullets.length; i++) {
		// bullets[i].draw(canvas);
		// }
	}
}