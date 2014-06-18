import java.util.ArrayList;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;
import obpro.sound.BSound;

/**
 * �V���[�e�B���O�Q�[���T���v���i���̂S �|�����[�t�B�Y���j �i���X�g�Ŏ����j
 * 
 * @author macchan
 * @date 2005/06/22 �I�u�v����10��
 * @date 2007/07/21 �i���X�g�Ŏ����j
 * @version 1.0
 */
public class ShootingGame4ByList {

	public static void main(String[] args) {
		ShootingGame4ByList shootingGame = new ShootingGame4ByList();
		shootingGame.main();
	}

	// �E�C���h�E
	private BWindow window;

	// �A�j���[�V�����I�u�W�F�N�g�̏W��
	private ArrayList<AnimationElement> elements = new ArrayList<AnimationElement>();

	// ��ޕʃA�j���[�V�����I�u�W�F�N�g
	private Background background;
	private PlayerAircraft player;
	private ArrayList<EnemyAircraft> enemies = new ArrayList<EnemyAircraft>();
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	private final int ENEMY_COUNT = 10;
	private final int BULLET_COUNT = 10;

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
	void doAnimation() {
		BCanvas canvas = window.getCanvas();// �L�����o�X���擾����
		initializeElements();// �I�u�W�F�N�g������������
		initializeSounds();// �T�E���h������������

		// �A�j���[�V��������
		bgm.loop();
		while (true) {
			// �P�R�}�̏������s��
			processOneStepForGame(canvas);
			processOneStepForElements(canvas);

			// �}�`��`��
			canvas.clear();
			draw(canvas);
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
		player = new PlayerAircraft(50, 50, 100, 50);
		elements.add(player);

		// �G
		for (int i = 0; i < ENEMY_COUNT; i++) {
			EnemyAircraft enemy = new EnemyAircraft(-100, -100, 100, 50);
			enemies.add(enemy);
			elements.add(enemy);
		}

		// �e
		for (int i = 0; i < BULLET_COUNT; i++) {
			Bullet bullet = new Bullet(-1, -1, 20, 10);
			bullets.add(bullet);
			elements.add(bullet);
		}
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
	}

	/**
	 * �Q�[���S�̂Ƃ��Ă�1�X�e�b�v�̏������s��
	 */
	private void processOneStepForGame(BCanvas canvas) {
		// (�L�[���͂ɂ����)���@�𑀍삷��
		if (canvas.isKeyPressing(37)) {// ���L�[
			player.move(-5, 0);
		}
		if (canvas.isKeyPressing(38)) {// ��L�[
			player.move(0, -5);
		}
		if (canvas.isKeyPressing(39)) {// �E�L�[
			player.move(5, 0);
		}
		if (canvas.isKeyPressing(40)) {// ���L�[
			player.move(0, 5);
		}

		// �L�[���͂ɂ���Ēe���o��
		if (canvas.isKeyDown() && player.isAlive()) {
			int keyCode = canvas.getKeyCode();
			if (keyCode == 70) {// f�L�[
				// �i�L���łȂ��e��T���āj�e�𔭎˂���
				for (Bullet bullet : bullets) {
					if (bullet.isAlive() == false) {
						bullet.fire(player);
						break;
					}
				}
			}
		}

		// �G���o��
		int rnd = (int) (Math.random() * 30);// �m��1/30�R�}�̒��I
		if (rnd == 0) {
			int i = (int) (Math.random() * ENEMY_COUNT);// �G�̓Y�����ߒ��I
			int y = (int) (Math.random() * canvas.getCanvasHeight());// y���W���ߒ��I
			enemies.get(i).show(canvas.getCanvasWidth(), y);
		}

		// ���@�ƓG�̓����蔻��Ƃ��������ꍇ�̏������s��
		for (EnemyAircraft enemy : enemies) {
			if (enemy.isAlive() && player.intersects(enemy)) {
				player.explode();
			}
		}

		// �e�ƓG�̓����蔻��Ƃ��������ꍇ�̏������s��
		for (EnemyAircraft enemy : enemies) {
			for (Bullet bullet : bullets) {
				if (bullet.isAlive() && enemy.isAlive()
						&& enemy.intersects(bullet)) {
					enemy.explode();
					bullet.destroy();
				}
			}
		}
	}

	/**
	 * ���ׂẴA�j���[�V�����I�u�W�F�N�g��step���߂𑗂�
	 */
	private void processOneStepForElements(BCanvas canvas) {
		for (AnimationElement element : elements) {
			element.processOneStep(canvas);
		}
	}

	/**
	 * �A�j���[�V�����I�u�W�F�N�g��`�悷��
	 */
	private void draw(BCanvas canvas) {
		for (AnimationElement element : elements) {
			element.draw(canvas);
		}
	}

}