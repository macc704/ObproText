import java.util.ArrayList;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * �V���[�e�B���O�Q�[���T���v�� �i���̂Q �e�o�� & �X���[�X�Ȏ��@����j
 * 
 * @author macchan
 * @date 2005/06/08 �I�u�v����8��
 * @date 2007/06/21 �R���N�V����(ArrayList)���g���悤�ɏC��
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
	// ArrayList�o�[�W����
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	// �z��o�[�W����
	// Bullet[] bullets = new Bullet[3];

	void main() {
		openWindow();
		doAnimation();
	}

	// �E�C���h�E���J��
	void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	// �A�j���[�V��������
	void doAnimation() {
		BCanvas canvas = window.getCanvas();// �L�����o�X���擾����
		initializeObjects();// �I�u�W�F�N�g������������

		// �A�j���[�V��������
		while (true) {
			// �P�R�}�̏������s��
			processOneStep(canvas);

			// �}�`��`��
			canvas.clear();
			draw(canvas);
			canvas.update();

			// ����
			canvas.sleep(0.05);
		}
	}

	// �I�u�W�F�N�g������������
	private void initializeObjects() {
		player = new PlayerAircraft(50, 50, 100, 50);
		enemy = new EnemyAircraft(400, 50, 100, 50);
		// ArrayList�o�[�W����
		for (int i = 0; i < 3; i++) {
			bullets.add(new Bullet(-1, -1, 20, 10));
		}
		// �z��o�[�W����
		// for (int i = 0; i < bullets.length; i++) {
		// bullets[i] = new Bullet(-1, -1, 20, 10);
		// }
	}

	// �P�R�}�̏������s��
	private void processOneStep(BCanvas canvas) {
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
		if (canvas.isKeyDown()) {
			int keyCode = canvas.getKeyCode();
			if (keyCode == 70) {// f�L�[
				// �i�L���łȂ��e��T���āj�e�𔭎˂���
				// ArrayList�o�[�W����
				for (Bullet bullet : bullets) {
					if (bullet.isLive() == false) {
						bullet.fire(player);
						break;
					}
				}
				// �z��o�[�W����
				// for (int i = 0; i < bullets.length; i++) {
				// if (bullets[i].isLive() == false) {
				// bullets[i].fire(player);
				// break;
				// }
				// }
			}
		}

		// �e�I�u�W�F�N�g��1�R�}�̏������s��
		player.processOneStep();
		enemy.processOneStep();
		// ArrayList�o�[�W����
		for (Bullet bullet : bullets) {
			bullet.processOneStep(canvas);
		}
		// �z��o�[�W����
		// for (int i = 0; i < bullets.length; i++) {
		// bullets[i].processOneStep(canvas);
		// }

		// �����蔻����s��
		if (player.intersects(enemy)) {
			player.explode();
		}
	}

	// �}�`��`��
	private void draw(BCanvas canvas) {
		player.draw(canvas);
		enemy.draw(canvas);
		// ArrayList�o�[�W����
		for (Bullet bullet : bullets) {
			bullet.draw(canvas);
		}
		// �z��o�[�W����
		// for (int i = 0; i < bullets.length; i++) {
		// bullets[i].draw(canvas);
		// }
	}
}