import obpro.gui.BCanvas;
import obpro.gui.BWindow;
import obpro.sound.BSound;

/**
 * シューティングゲームサンプル（その４　ポリモーフィズム） 
 * 
 * @author macchan
 * @date 2005/06/22 オブプロ第10回
 * @version 1.0
 */
public class ShootingGame4 {

	public static void main(String[] args) {
		ShootingGame4 shootingGame = new ShootingGame4();
		shootingGame.main();
	}

	//ウインドウ
	private BWindow window;

	//アニメーションオブジェクトの集合
	private AnimationElement[] elements = new AnimationElement[1000];
	private int elementSize = 0;

	//種類別アニメーションオブジェクト
	private Background background;
	private PlayerAircraft player;
	private EnemyAircraft[] enemies = new EnemyAircraft[100];
	private Bullet[] bullets = new Bullet[20];

	//BGM
	private BSound bgm;

	private void main() {
		openWindow();
		doAnimation();
	}

	//ウインドウを開く
	private void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	//アニメーションする
	void doAnimation() {
		BCanvas canvas = window.getCanvas();//キャンバスを取得する
		initializeElements();//オブジェクトを初期化する
		initializeSounds();//サウンドを初期化する

		//アニメーションする
		bgm.loop();
		while (true) {
			//１コマの処理を行う
			processOneStepForGame(canvas);
			processOneStepForElements(canvas);

			//図形を描く
			canvas.clear();
			draw(canvas);
			canvas.update();

			//眠る
			canvas.sleep(0.01);
		}
	}

	/**
	 * 各オブジェクトを初期化する
	 */
	private void initializeElements() {
		//背景
		background = new Background();
		addElement(background);

		//プレイヤー
		player = new PlayerAircraft(50, 50, 100, 50);
		addElement(player);

		//敵		
		for (int i = 0; i < enemies.length; i++) {
			enemies[i] = new EnemyAircraft(-100, -100, 100, 50);
			addElement(enemies[i]);
		}

		//弾
		for (int i = 0; i < bullets.length; i++) {
			bullets[i] = new Bullet(-1, -1, 20, 10);
			addElement(bullets[i]);
		}
	}

	/**
	 * サウンドを初期化する
	 */
	private void initializeSounds() {
		//BGM
		bgm = new BSound("sound/bgm.mp3");

		//効果音はメモリ上に読み込む
		BSound.load("sound/explode_enemy.mp3");
		BSound.load("sound/explode_player.mp3");
		BSound.load("sound/fire.mp3");
	}

	/**
	 * ゲーム全体としての1ステップの処理を行う
	 */
	private void processOneStepForGame(BCanvas canvas) {
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
		if (canvas.isKeyDown() && player.isAlive()) {
			int keyCode = canvas.getKeyCode();
			if (keyCode == 70) {// fキー
				// （有効でない弾を探して）弾を発射する
				for (int i = 0; i < bullets.length; i++) {
					if (bullets[i].isAlive() == false) {
						bullets[i].fire(player);
						break;
					}
				}
			}
		}

		// 敵を出す
		int rnd = (int) (Math.random() * 30);// 確率1/30コマの抽選
		if (rnd == 0) {
			int i = (int) (Math.random() * 100);// 敵の添字決め抽選
			int y = (int) (Math.random() * canvas.getCanvasHeight());// y座標決め抽選
			enemies[i].show(canvas.getCanvasWidth(), y);
		}

		// 自機と敵の当たり判定とあたった場合の処理を行う
		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i].isAlive() && player.intersects(enemies[i])) {
				player.explode();
			}
		}

		// 弾と敵の当たり判定とあたった場合の処理を行う
		for (int i = 0; i < enemies.length; i++) {
			for (int j = 0; j < bullets.length; j++) {
				if (bullets[j].isAlive() && enemies[i].isAlive()
						&& enemies[i].intersects(bullets[j])) {
					enemies[i].explode();
					bullets[j].destroy();
				}
			}
		}
	}

	/**
	 * すべてのアニメーションオブジェクトにstep命令を送る
	 */
	private void processOneStepForElements(BCanvas canvas) {
		for (int i = 0; i < elementSize; i++) {
			elements[i].processOneStep(canvas);
		}
	}

	/**
	 * アニメーションオブジェクトを描画する
	 */
	private void draw(BCanvas canvas) {
		for (int i = 0; i < elementSize; i++) {
			elements[i].draw(canvas);
		}
	}

	/**
	 * アニメーションオブジェクトを追加する
	 */
	private void addElement(AnimationElement element) {
		elements[elementSize] = element;
		elementSize++;
	}
}