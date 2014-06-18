import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * �e��\������N���X
 */
public class Bullet extends Character {

	//�萔
	private final int ALIVE = 1;
	private final int DEAD = 2;

	//���
	private int liveState = ALIVE;

	//�֘A�Q��
	private ShootingGame6 game;

	//����
	private Color color = new Color(0, 0, 255);

	/**
	 * �R���X�g���N�^
	 */
	public Bullet(int x, int y, int width, int height, ShootingGame6 game) {
		super(x, y, width, height);
		this.game = game;
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
	 * �e�����ł�����i����������j
	 */
	public void destroy() {
		if (liveState == ALIVE) {
			liveState = DEAD;
			game.removeBullet(this);
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