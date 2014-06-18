import obpro.turtle.Turtle;

/*
 * House02.java ���t���̉Ƃ�`���v���O�����i2�j (�������j
 * 
 * @author �r�؁i���V�C���j
 * @version 2007/04/26 13:17:08
 */
public class House02 extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new House02());
	}

	// �Ƃ�`��
	public void start() {
		drawRoof(); // ������`��
		drawWall(); // �ǂ�`��
		drawWindow(); // ����`��
	}

	// ������`��
	void drawRoof() {
		drawTriangle(80); // �O�p�`��`��
	}

	// �ǂ�`��
	void drawWall() {
		rt(90); // �����𒲐߂���
		drawRectangle(80);// �l�p�`��`��
		lt(90);// ������������ɖ߂�
	}

	// ����`��
	void drawWindow() {
		// ����`���ʒu�܂ňړ�����
		moveToWindowLocation(22);

		// ����`��
		rt(90);
		for (int i = 0; i < 4; i++) {
			drawRectangle(16);
			fd(16 * 2 + 4);
			rt(90);
		}
		lt(90);
	}

	// �O�p�`��`��
	void drawTriangle(int size) {
		// �����𒲐߂���
		rt(30);

		// �O�p�`��`��
		for (int i = 0; i < 3; i++) {
			fd(size);
			rt(120);
		}

		// ������������ɖ߂�
		lt(30);
	}

	// �l�p�`��`��
	void drawRectangle(int size) {
		for (int i = 0; i < 4; i++) {
			fd(size);
			rt(90);
		}
	}

	// ����`���ʒu�܂ňړ�����
	void moveToWindowLocation(int length) {
		// �O����
		up();

		// �E��
		rt(90);
		fd(length);

		// ����
		rt(90);
		fd(length);

		// �㏈��
		rt(180);
		down();
	}

}
