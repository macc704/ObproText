/**
 * �V���[�e�B���O�Q�[���̃L�����N�^�[��\������N���X
 */
public class ShootingCharacter {

	// ����
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * �R���X�g���N�^
	 */
	public ShootingCharacter(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * �������擾����
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * �����擾����
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * X���W���擾����
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Y���W���擾����
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * �ʒu���Đݒ肷��
	 */
	public void setLocation(int newX, int newY) {
		x = newX;
		y = newY;
	}

	/**
	 * ������
	 */
	public void move(int moveX, int moveY) {
		x = x + moveX;
		y = y + moveY;
	}
}