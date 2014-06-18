import obpro.gui.BCanvas;
import obpro.gui.BWindow;
import obpro.sound.BSound;

/**
 * �V���[�e�B���O�Q�[���T���v���i���̂S�@�|�����[�t�B�Y���j 
 * 
 * @author macchan
 * @date 2005/06/22 �I�u�v����10��
 * @version 1.0
 */
public class ShootingGame4 {

	public static void main(String[] args) {
		ShootingGame4 shootingGame = new ShootingGame4();
		shootingGame.main();
	}

	//�E�C���h�E
	private BWindow window;

	//�A�j���[�V�����I�u�W�F�N�g�̏W��
	private AnimationElement[] elements = new AnimationElement[1000];
	private int elementSize = 0;

	//��ޕʃA�j���[�V�����I�u�W�F�N�g
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

	//�E�C���h�E���J��
	private void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	//�A�j���[�V��������
	void doAnimation() {
		BCanvas canvas = window.getCanvas();//�L�����o�X���擾����
		initializeElements();//�I�u�W�F�N�g������������
		initializeSounds();//�T�E���h������������

		//�A�j���[�V��������
		bgm.loop();
		while (true) {
			//�P�R�}�̏������s��
			processOneStepForGame(canvas);
			processOneStepForElements(canvas);

			//�}�`��`��
			canvas.clear();
			draw(canvas);
			canvas.update();

			//����
			canvas.sleep(0.01);
		}
	}

	/**
	 * �e�I�u�W�F�N�g������������
	 */
	private void initializeElements() {
		//�w�i
		background = new Background();
		addElement(background);

		//�v���C���[
		player = new PlayerAircraft(50, 50, 100, 50);
		addElement(player);

		//�G		
		for (int i = 0; i < enemies.length; i++) {
			enemies[i] = new EnemyAircraft(-100, -100, 100, 50);
			addElement(enemies[i]);
		}

		//�e
		for (int i = 0; i < bullets.length; i++) {
			bullets[i] = new Bullet(-1, -1, 20, 10);
			addElement(bullets[i]);
		}
	}

	/**
	 * �T�E���h������������
	 */
	private void initializeSounds() {
		//BGM
		bgm = new BSound("sound/bgm.mp3");

		//���ʉ��̓�������ɓǂݍ���
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
				for (int i = 0; i < bullets.length; i++) {
					if (bullets[i].isAlive() == false) {
						bullets[i].fire(player);
						break;
					}
				}
			}
		}

		// �G���o��
		int rnd = (int) (Math.random() * 30);// �m��1/30�R�}�̒��I
		if (rnd == 0) {
			int i = (int) (Math.random() * 100);// �G�̓Y�����ߒ��I
			int y = (int) (Math.random() * canvas.getCanvasHeight());// y���W���ߒ��I
			enemies[i].show(canvas.getCanvasWidth(), y);
		}

		// ���@�ƓG�̓����蔻��Ƃ��������ꍇ�̏������s��
		for (int i = 0; i < enemies.length; i++) {
			if (enemies[i].isAlive() && player.intersects(enemies[i])) {
				player.explode();
			}
		}

		// �e�ƓG�̓����蔻��Ƃ��������ꍇ�̏������s��
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
	 * ���ׂẴA�j���[�V�����I�u�W�F�N�g��step���߂𑗂�
	 */
	private void processOneStepForElements(BCanvas canvas) {
		for (int i = 0; i < elementSize; i++) {
			elements[i].processOneStep(canvas);
		}
	}

	/**
	 * �A�j���[�V�����I�u�W�F�N�g��`�悷��
	 */
	private void draw(BCanvas canvas) {
		for (int i = 0; i < elementSize; i++) {
			elements[i].draw(canvas);
		}
	}

	/**
	 * �A�j���[�V�����I�u�W�F�N�g��ǉ�����
	 */
	private void addElement(AnimationElement element) {
		elements[elementSize] = element;
		elementSize++;
	}
}