import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.sound.BSound;

/**
 * �e��\������N���X
 */
public class Bullet extends ShootingCharacter {

	//�萔
	private final int ALIVE = 1;
	private final int DEAD = 2;

	//���
	private int liveState = DEAD;

	//����
	private Color color = new Color(0, 0, 255);

	/**
	 * �R���X�g���N�^
	 */
	public Bullet(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * �P�X�e�b�v�̏���������(�I�[�o�[���C�h)
	 */
	public void processOneStep(BCanvas canvas) {
		if (liveState == ALIVE) {
			//������
			move(15, 0);

			//��ʊO�ɏo���ꍇ�̏���
			if (getX() > canvas.getCanvasWidth()) {
				destroy();
			}
		}
	}

	/**
	 * �e�𔭎˂���i�L��������j
	 */
	public void fire(PlayerAircraft player) {
		if (liveState == DEAD) {
			int x = player.getX() + player.getWidth() / 2 - getWidth() / 2;
			int y = player.getY() + player.getHeight() / 2 - getHeight() / 2;
			setLocation(x, y);
			liveState = ALIVE;
			BSound.play("sound/fire.mp3");
		}
	}

	/**
	 * �e�����ł�����i����������j
	 */
	public void destroy() {
		if (liveState == ALIVE) {
			liveState = DEAD;
		}
	}

	/**
	 * �e���L�����ǂ������ׂ�
	 */
	public boolean isAlive() {
		return liveState == ALIVE;
	}

	/**
	 * �`�悷��(�I�[�o�[���C�h)
	 */
	public void draw(BCanvas canvas) {
		if (liveState == ALIVE) {
			canvas.drawFillTriangle(color, getX(), getY(), getX() + getWidth(),
					getY(), getX(), getY() + getHeight());
			canvas.drawFillTriangle(color, getX(), getY() + getHeight(), getX()
					+ getWidth(), getY() + getHeight(), getX() + getWidth(),
					getY());
		}
	}

}