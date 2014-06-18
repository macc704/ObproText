import java.util.ArrayList;
import java.util.List;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;
import obpro.sound.BSound;

/**
 * �V���[�e�B���O�Q�[���T���v���i����5�@���X�g�����C�I�v�V���������j
 * 
 * @author macchan
 * @date 2005/06/22 �I�u�v����11��
 * @version 1.0
 */
public class ShootingGame5 {

	public static void main(String[] args) {
		ShootingGame5 shootingGame = new ShootingGame5();
		shootingGame.main();
	}

	// �E�C���h�E
	private BWindow window;

	// �A�j���[�V�����I�u�W�F�N�g�̏W��
	private List<AnimationElement> elements = new ArrayList<AnimationElement>();

	// ��ޕʃA�j���[�V�����I�u�W�F�N�g
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

	// �E�C���h�E���J��
	private void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	// �A�j���[�V��������
	private void doAnimation() {
		// �A�j���[�V�����̏���������
		BCanvas canvas = window.getCanvas();
		initializeElements();
		initializeSounds();

		// �A�j���[�V��������
		bgm.loop();
		while (true) {
			{// �P�R�}�̏������s��
				// �Q�[���S�̂Ƃ��Ă�1�R�}�̏������s��
				processOneStepForGame(canvas);

				// �e�I�u�W�F�N�g��1�R�}�̏������s��
				for (int i = 0; i < elements.size(); i++) {
					AnimationElement element = (AnimationElement) elements
							.get(i);
					element.processOneStep(canvas);
				}
			}

			// �}�`��`��
			canvas.clear();
			for (int i = 0; i < elements.size(); i++) {
				AnimationElement element = (AnimationElement) elements.get(i);
				element.draw(canvas);
			}
			canvas.update();

			// ����
			canvas.sleep(0.01);
		}
	}

	/**
	 * �e�I�u�W�F�N�g������������
	 */
	private void initializeElements() {
		// �w�i
		background = new Background();
		elements.add(background);

		// �v���C���[
		player = new PlayerAircraft(50, 50, this);
		elements.add(player);
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
	private void processOneStepForGame(BCanvas canvas) {
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
				}
			}
		}
	}

	/**
	 * �G��ǉ�����
	 */
	public void addEnemy(EnemyAircraft enemy) {
		enemies.add(enemy);
		elements.add(enemy);
	}

	/**
	 * �G���폜����
	 */
	public void removeEnemy(EnemyAircraft enemy) {
		enemies.remove(enemy);
		elements.remove(enemy);
	}

	/**
	 * �e��ǉ�����
	 */
	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
		elements.add(bullet);
	}

	/**
	 * �e���폜����
	 */
	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
		elements.remove(bullet);
	}

}