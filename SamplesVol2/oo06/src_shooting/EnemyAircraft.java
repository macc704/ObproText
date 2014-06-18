import obpro.gui.BCanvas;
import obpro.sound.BSound;

/**
 * �G�@��\������N���X
 */
public class EnemyAircraft extends Character {

	//�萔
	private final int ALIVE = 1;
	private final int EXPLODING = 2;
	private final int DEAD = 3;

	private final int EXPLODING_ANIMATION_SIZE = 11;

	//���
	private int liveState = ALIVE;
	private int explodingCount = 0;

	//�֘A�Q��
	private ShootingGame6 game;

	/**
	 * �R���X�g���N�^
	 */
	public EnemyAircraft(int x, int y, ShootingGame6 game) {
		super(x, y, 100, 50);
		this.game = game;
	}

	/**
	 * 1�X�e�b�v�̏���������(�I�[�o�[���C�h)
	 */
	public void processOneStep(BCanvas canvas) {
		if (liveState == ALIVE) {
			//����
			move(-5, 0);

			//��ʁi���j�O�ɏo�������
			if (getX() < -100) {
				destroy();
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
	 * ���ł���
	 */
	public void destroy() {
		game.removeEnemy(this);
		liveState = DEAD;
	}

	/**
	 * �����̏���������
	 */
	private void processExplode() {
		explodingCount++;
		if (explodingCount >= EXPLODING_ANIMATION_SIZE) {
			destroy();
		}
	}

	/**
	 * ��������i������ԂɑJ�ڂ���j
	 */
	public void explode() {
		if (liveState == ALIVE) {
			liveState = EXPLODING;
			explodingCount = 0;
			BSound.play("sound/explode_enemy.mp3");
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
		canvas.drawImage("img/enemy.png", getX(), getY(), getWidth(),
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