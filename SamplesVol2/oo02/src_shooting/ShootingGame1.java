import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * �V���[�e�B���O�Q�[���T���v���i���̂P�@�����Q�[�j 
 * 
 * @author macchan
 * @date 2005/06/08 �I�u�v����8�� 2006/05/26�C��
 * @version 1.0
 */
public class ShootingGame1 {

	public static void main(String[] args) {
		ShootingGame1 shootingGame = new ShootingGame1();
		shootingGame.main();
	}

	BWindow window;
	
	PlayerAircraft player;
	EnemyAircraft enemy;

	void main() {
		openWindow();
		doAnimation();
	}

	//�E�C���h�E���J��
	void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	//�A�j���[�V��������
	void doAnimation() {
		BCanvas canvas = window.getCanvas();//�L�����o�X���擾����
		initializeObjects();//�I�u�W�F�N�g������������

		//�A�j���[�V��������
		while (true) {
			//�P�R�}�̏������s��
			processOneStep(canvas);

			//�}�`��`��
			canvas.clear();
			draw(canvas);
			canvas.update();

			//����
			canvas.sleep(0.05);
		}
	}

	//�I�u�W�F�N�g������������
	private void initializeObjects() {
		player = new PlayerAircraft(50, 50, 100, 50);
		enemy = new EnemyAircraft(400, 50, 100, 50);
	}

	// �P�R�}�̏������s��
	private void processOneStep(BCanvas canvas) {
		// (�L�[���͂ɂ����)���@�𑀍삷��
		if (canvas.isKeyDown()) {
			int keyCode = canvas.getKeyCode();
			if (keyCode == 37) {// ���L�[
				player.move(-5, 0);
			} else if (keyCode == 38) {// ��L�[
				player.move(0, -5);
			} else if (keyCode == 39) {// �E�L�[
				player.move(5, 0);
			} else if (keyCode == 40) {// ���L�[
				player.move(0, 5);
			}
		}

		// �e�I�u�W�F�N�g��1�R�}�̏������s��
		player.processOneStep();
		enemy.processOneStep();

		// �����蔻����s��
		if (player.intersects(enemy)) {
			player.explode();
		}
	}

	// �}�`��`��
	private void draw(BCanvas canvas) {
		player.draw(canvas);
		enemy.draw(canvas);
	}

}