import java.util.ArrayList;
import java.util.List;

import obpro.gui.BCanvas;
import obpro.sound.BSound;

/**
 * �V���[�e�B���O�Q�[���T���v���i���̂U�@�t���[�����[�N�̃R���|�[�l���g�Ƃ���j
 * 
 * @author macchan
 * @date 2005/07/7 �I�u�v����12��
 * @version 1.0
 */
public class ShootingGame6 extends AbstractGUIAnimationApplication {

	public static void main(String[] args) {
		GUIAnimationApplicationEngine game = new GUIAnimationApplicationEngine(
				new ShootingGame6());
		game.run();
	}

	// ��ޕʃA�j���[�V�����I�u�W�F�N�g
	private Background background;
	private ScoreBoard scoreBoard;
	private PlayerAircraft player;
	private List<EnemyAircraft> enemies = new ArrayList<EnemyAircraft>();
	private List<Bullet> bullets = new ArrayList<Bullet>();

	// BGM
	BSound bgm;

	/**
	 * �e�I�u�W�F�N�g������������
	 */
	public void prepareAnimationStart() {
		// �X�e�b�v�̊Ԋu��ݒ肷��
		getEngine().setStepInterval(0.01);

		// BGM
		initializeSounds();
		bgm.loop();

		// �w�i
		background = new Background();
		getEngine().addElement(background);

		// ���_��
		scoreBoard = new ScoreBoard(100, 30, 0, 0);
		getEngine().addElement(scoreBoard);

		// �v���C���[
		player = new PlayerAircraft(50, 50, this);
		getEngine().addElement(player);
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

	/**
	 * �Q�[���S�̂Ƃ��Ă�1�X�e�b�v�̏������s��
	 */
	public void processOneStepForApplication(BCanvas canvas) {
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
	}

	/**
	 * �G��ǉ�����
	 */
	public void addEnemy(EnemyAircraft enemy) {
		enemies.add(enemy);
		getEngine().addElement(enemy);
	}

	/**
	 * �G���폜����
	 */
	public void removeEnemy(EnemyAircraft enemy) {
		enemies.remove(enemy);
		getEngine().removeElement(enemy);
	}

	/**
	 * �e��ǉ�����
	 */
	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
		getEngine().addElement(bullet);
	}

	/**
	 * �e���폜����
	 */
	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
		getEngine().removeElement(bullet);
	}

}