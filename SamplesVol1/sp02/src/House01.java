import obpro.turtle.Turtle;

/*
 * House01.java ���t���̉Ƃ�`���v���O����(1)
 * 
 * @author �r�؁i���V�C���j
 * @version 2007/04/26 13:17:08
 */
public class House01 extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new House01());
	}

	// �Ƃ�`��
	public void start() {
		drawRoof(); // ������`��
		drawWall(); // �ǂ�`��
		drawWindow(); // ����`��
	}

	// ������`��
	void drawRoof() {
		drawTriangle(); // �O�p�`��`��
	}

	// �ǂ�`��
	void drawWall() {
		rt(90); // �����𒲐߂���
		drawRectangle();// �l�p�`��`��
		lt(90);// ������������ɖ߂�
	}

	// ����`��
	void drawWindow() {
		// ����`���ʒu�܂ňړ�����
		moveToWindowLocation();

		// ����`��
		rt(90);
		for (int i = 0; i < 4; i++) {
			drawSmallRectangle();
			fd(16 * 2 + 4);
			rt(90);
		}
		lt(90);
	}

	// �O�p�`��`��
	void drawTriangle() {
		// �����𒲐߂���
		rt(30);

		// �O�p�`��`��
		for (int i = 0; i < 3; i++) {
			fd(80);
			rt(120);
		}

		// ������������ɖ߂�
		lt(30);
	}

	// �l�p�`��`��
	void drawRectangle() {
		for (int i = 0; i < 4; i++) {
			fd(80);
			rt(90);
		}
	}

	// �������l�p�`��`��
	void drawSmallRectangle() {
		for (int i = 0; i < 4; i++) {
			fd(16);
			rt(90);
		}
	}

	// ����`���ʒu�܂ňړ�����
	void moveToWindowLocation() {
		// �O����
		up();

		// �E��22
		rt(90);
		fd(22);

		// ����22
		rt(90);
		fd(22);

		// �㏈��
		rt(180);
		down();
	}

}
