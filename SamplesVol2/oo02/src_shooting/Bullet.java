import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * �e��\������N���X
 */
public class Bullet {

	// �萔
	private final int ALIVE = 1;
	private final int DEAD = 2;

	// ���
	private int liveState = DEAD;

	// ����
	private Color color = new Color(0, 0, 255);
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * �R���X�g���N�^
	 */
	public Bullet(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * X���W���擾����
	 */
	public int getX() {
		return x;
	}

	/**
	 * Y���W���擾����
	 */
	public int getY() {
		return y;
	}

	/**
	 * ������
	 */
	public void move(int moveX, int moveY) {
		if (liveState == ALIVE) {
			x = x + moveX;
			y = y + moveY;
		}
	}

	/**
	 * �P�X�e�b�v�̏���������
	 */
	public void processOneStep(BCanvas canvas) {
		if (isLive()) {
			move(15, 0);// ������

			// ��ʊO�ɏo���ꍇ�̏���
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
			this.x = player.getX() + player.getWidth() / 2 - width / 2;
			this.y = player.getY() + player.getHeight() / 2 - height / 2;
			liveState = ALIVE;
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
	public boolean isLive() {
		return liveState == ALIVE;
	}

	/**
	 * �`��
	 */
	public void draw(BCanvas canvas) {
		if (liveState == ALIVE) {
			canvas.drawFillTriangle(color, x, y, x + width, y, x, y + height);
			canvas.drawFillTriangle(color, x, y + height, x + width,
					y + height, x + width, y);
		}
	}

}