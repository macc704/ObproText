import java.util.ArrayList;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * �V���[�e�B���O�Q�[���T���v�� �i����3 ���̃N���X�͂���2�ƕύX�Ȃ��j
 * 
 * @author macchan
 * @date 2005/06/08 �I�u�v����8�� 2006/05/26�C��
 * @date 2007/06/27 �R���N�V����(ArrayList)���g���悤�ɏC��
 * @version 1.0
 */
public class ShootingGame3 {

	public static void main(String[] args) {
		ShootingGame3 shootingGame = new ShootingGame3();
		shootingGame.main();
	}

	BWindow window;

	PlayerAircraft player;
	EnemyAircraft enemy;
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();

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
		for (int i = 0; i < 3; i++) {
			bullets.add(new Bullet(-1, -1, 20, 10));
		}
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
				for (Bullet bullet : bullets) {
					if (bullet.isAlive() == false) {
						bullet.fire(player);
						break;
					}
				}
			}
		}

		// �e�I�u�W�F�N�g��1�R�}�̏������s��
		player.processOneStep();
		enemy.processOneStep();
		for (Bullet bullet : bullets) {
			bullet.processOneStep(canvas);
		}

		// �����蔻����s��
		if (player.intersects(enemy)) {
			player.explode();
		}
	}

	// �}�`��`��
	private void draw(BCanvas canvas) {
		player.draw(canvas);
		enemy.draw(canvas);
		for (Bullet bullet : bullets) {
			bullet.draw(canvas);
		}
	}
}