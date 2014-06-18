import java.util.ArrayList;
import java.util.List;

import obpro.gui.BCanvas;
import obpro.sound.BSound;

/**
 * ���@��\������N���X
 */
public class PlayerAircraft extends ShootingCharacter {

	// �萔
	private final int ALIVE = 1;
	private final int EXPLODING = 2;
	private final int DEAD = 3;

	private final int EXPLODING_ANIMATION_SIZE = 11;

	// ���
	private int liveState = ALIVE;
	private int explodingCount = 0;

	// �֘A�Q��
	private ShootingGame5 game;
	private List<Option> options = new ArrayList<Option>();

	/**
	 * �R���X�g���N�^
	 */
	public PlayerAircraft(int x, int y, ShootingGame5 game) {
		super(x, y, 100, 50);
		this.game = game;
	}

	/**
	 * ����
	 */
	public void move(int moveX, int moveY) {
		// ���@�𓮂���
		super.move(moveX, moveY);

		// �I�v�V�����𓮂���
		for (int i = 0; i < options.size(); i++) {
			Option option = (Option) options.get(i);
			option.move(moveX, moveY);
		}
	}

	/**
	 * 1�X�e�b�v�̏���������(�I�[�o�[���C�h)
	 */
	public void processOneStep(BCanvas canvas) {
		if (liveState == ALIVE) {
			// ���L�[���͂ɂ���Ď��@�𑀍삷��
			if (canvas.isKeyPressing(37)) {// ���L�[
				move(-5, 0);
			}
			if (canvas.isKeyPressing(38)) {// ��L�[
				move(0, -5);
			}
			if (canvas.isKeyPressing(39)) {// �E�L�[
				move(5, 0);
			}
			if (canvas.isKeyPressing(40)) {// ���L�[
				move(0, 5);
			}

			// F�L�[���͂ɂ���Ēe���o��
			if (canvas.isKeyDown()) {
				int keyCode = canvas.getKeyCode();
				if (keyCode == 70) {// f�L�[
					fire();
				}
			}

			// G�L�[���͂ɂ���ăI�v�V�������o��
			if (canvas.isKeyDown()) {
				int keyCode = canvas.getKeyCode();
				if (keyCode == 71) {// g�L�[
					BSound.play("sound/optionvoice.mp3", 100);
					BSound.play("sound/powerup.mp3");
					options.add(new Option(getX(), getY(), getWidth(),
							getHeight(), options.size() + 1));
				}
			}

			// �I�v�V������1�X�e�b�v�̏������s�Ȃ�
			for (int i = 0; i < options.size(); i++) {
				Option option = (Option) options.get(i);
				option.processOneStep(canvas);
			}
		} else if (liveState == EXPLODING) {
			processExplode();
		}
	}

	/**
	 * �����Ă��邩�ǂ������ׂ�
	 */
	public boolean isAlive() {
		return liveState == ALIVE;
	}

	/**
	 * �����̏���������
	 */
	private void processExplode() {
		explodingCount++;
		if (explodingCount >= EXPLODING_ANIMATION_SIZE) {
			liveState = DEAD;
		}
	}

	/**
	 * ��������i������ԂɑJ�ڂ���j
	 */
	public void explode() {
		if (liveState == ALIVE) {
			liveState = EXPLODING;
			explodingCount = 0;
			BSound.play("sound/explode_player.mp3");
		}
	}

	/**
	 * �`�悷��i�I�[�o�[���C�h�j
	 */
	public void draw(BCanvas canvas) {
		if (liveState == ALIVE) {
			// ���@������
			drawAircraft(canvas);

			// �I�v�V����������
			for (int i = 0; i < options.size(); i++) {
				Option option = (Option) options.get(i);
				option.draw(canvas);
			}
		} else if (liveState == EXPLODING) {
			drawExplosion(canvas);
		}
	}

	/**
	 * ��s�@��`�悷��
	 */
	private void drawAircraft(BCanvas canvas) {
		canvas.drawImage("img/player.png", getX(), getY(), getWidth(),
				getHeight());
	}

	/**
	 * ������`�悷��
	 */
	private void drawExplosion(BCanvas canvas) {
		canvas.drawImage("img/explode" + (explodingCount + 1) + ".gif", getX(),
				getY(), getWidth(), getHeight());
	}

	/**
	 * �e���o��
	 */
	private void fire() {
		if (liveState == ALIVE) {
			BSound.play("sound/fire.mp3");

			// ���@�̒e���o��
			fire(this);

			// �I�v�V�����̒e���o��
			for (int i = 0; i < options.size(); i++) {
				Option option = (Option) options.get(i);
				fire(option);
			}
		}
	}

	/**
	 * �i�I�v�V��������Ƃ́j�e���o��
	 */
	private void fire(ShootingCharacter shooter) {
		Bullet bullet = new Bullet(0, 0, 20, 10, game);
		int x = shooter.getX() + shooter.getWidth() / 2 - bullet.getWidth() / 2;
		int y = shooter.getY() + shooter.getHeight() / 2 - bullet.getHeight()
				/ 2;
		bullet.setLocation(x, y);
		game.addBullet(bullet);
	}
}