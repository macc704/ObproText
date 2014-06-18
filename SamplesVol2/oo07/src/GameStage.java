import java.util.ArrayList;
import java.util.List;

import obpro.gui.BCanvas;
import obpro.sound.BSound;

/*
 * GameStage.java
 * Created on 2011/07/28
 * Copyright(c) 2011 Yoshiaki Matsuzawa, Shizuoka University. All rights reserved.
 */

/**
 * @author macchan
 */
public class GameStage extends Container {

	private ShootingGame game;

	// 種類別アニメーションオブジェクト
	private Background background;
	private ScoreBoard scoreBoard;
	private PlayerAircraft player;
	private List<EnemyAircraft> enemies = new ArrayList<EnemyAircraft>();
	private List<Bullet> bullets = new ArrayList<Bullet>();
	// BGM
	private BSound bgm;

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public GameStage(ShootingGame game) {
		super(game.getX(), game.getY(), game.getWidth(), game.getHeight());
		this.game = game;

		// BGM
		initializeSounds();
		bgm.loop();

		// 背景
		background = new Background();
		addChild(background);

		// 得点板
		scoreBoard = new ScoreBoard(100, 30, 0, 0);
		addChild(scoreBoard);

		// プレイヤー
		player = new PlayerAircraft(50, 50, this);
		addChild(player);
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

	public void processOneStep(BCanvas canvas) {
		super.processOneStep(canvas);
		processOneStepForApplication(canvas);
	}

	/**
	 * ゲーム全体としての1ステップの処理を行う
	 */
	private void processOneStepForApplication(BCanvas canvas) {
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
				bgm.stop();
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

		if (canvas.getKeyCode() == 10 && !player.isAlive()) {
			game.handleGameFinished();
		}
	}

	/**
	 * 敵を追加する
	 */
	public void addEnemy(EnemyAircraft enemy) {
		enemies.add(enemy);
		addChild(enemy);
	}

	/**
	 * 敵を削除する
	 */
	public void removeEnemy(EnemyAircraft enemy) {
		enemies.remove(enemy);
		removeChild(enemy);
	}

	/**
	 * 弾を追加する
	 */
	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
		addChild(bullet);
	}

	/**
	 * 弾を削除する
	 */
	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
		removeChild(bullet);
	}

}
