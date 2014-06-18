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

	// ��ޕʃA�j���[�V�����I�u�W�F�N�g
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

		// �w�i
		background = new Background();
		addChild(background);

		// ���_��
		scoreBoard = new ScoreBoard(100, 30, 0, 0);
		addChild(scoreBoard);

		// �v���C���[
		player = new PlayerAircraft(50, 50, this);
		addChild(player);
	}

	/**
	 * �T�E���h������������
	 */
	private void initializeSounds() {
		// BGM
		bgm = new BSound("sound/bgm.mp3");

		// ���ʉ��̓�������ɓǂݍ���
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
	 * �Q�[���S�̂Ƃ��Ă�1�X�e�b�v�̏������s��
	 */
	private void processOneStepForApplication(BCanvas canvas) {
		// �G���o��
		int randomNumber = (int) (Math.random() * 30);// �m��1/30�R�}�̒��I
		if (randomNumber == 0) {
			int y = (int) (Math.random() * canvas.getCanvasHeight());// y���W���ߒ��I
			EnemyAircraft enemy = new EnemyAircraft(canvas.getCanvasWidth(), y,
					this);
			addEnemy(enemy);
		}

		// ���@�ƓG�̓����蔻��Ƃ��������ꍇ�̏������s��
		for (int i = 0; i < enemies.size(); i++) {
			EnemyAircraft enemy = (EnemyAircraft) enemies.get(i);
			if (enemy.isAlive() && player.intersects(enemy)) {
				player.explode();
				bgm.stop();
			}
		}

		// �e�ƓG�̓����蔻��Ƃ��������ꍇ�̏������s��
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
	 * �G��ǉ�����
	 */
	public void addEnemy(EnemyAircraft enemy) {
		enemies.add(enemy);
		addChild(enemy);
	}

	/**
	 * �G���폜����
	 */
	public void removeEnemy(EnemyAircraft enemy) {
		enemies.remove(enemy);
		removeChild(enemy);
	}

	/**
	 * �e��ǉ�����
	 */
	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
		addChild(bullet);
	}

	/**
	 * �e���폜����
	 */
	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
		removeChild(bullet);
	}

}
