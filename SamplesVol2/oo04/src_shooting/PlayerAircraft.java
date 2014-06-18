import obpro.gui.BCanvas;
import obpro.sound.BSound;

/**
 * ���@��\������N���X
 */
public class PlayerAircraft extends ShootingCharacter {

	//�萔
	private final int ALIVE = 1;
	private final int EXPLODING = 2;
	private final int DEAD = 3;

	private final int EXPLODING_ANIMATION_SIZE = 11;

	//���
	private int liveState = ALIVE;
	private int explodingCount = 0;

	/**
	 * �R���X�g���N�^
	 */
	public PlayerAircraft(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * 1�X�e�b�v�̏���������(�I�[�o�[���C�h)
	 */
	public void processOneStep(BCanvas canvas) {
		if (liveState == EXPLODING) {
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
			drawAircraft(canvas);
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
		canvas.drawImage("img/explode" + (explodingCount + 1) + ".gif",
				getX(), getY(), getWidth(), getHeight());
	}
}