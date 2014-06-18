import obpro.turtle.Turtle;

/*
 * KeyboardMissed.java
 * �L�[�{�[�h�������v���O�����i�Ӑ}�ʂ蓮���Ȃ����́j
 * 
 * Created on 2007/04/23 by macchan
 * Copyright(c) 2007 CreW Project
 */
public class KeyboardMissed extends Turtle {

	public static void main(String[] args) {
		Turtle.startTurtle(new KeyboardMissed());
	}
	int keyCounter = 0;
	public void start() {
		// �P�O�~�R�̃L�[������
		for (int i = 0; i < 3; i++) {
			drawKeyLine();// �L�[�{�[�h�̉�����`��
			moveTurtle(180, 30);// ���̈ʒu�Ɉړ�����
		}
	}

	// �L�[�{�[�h�̉�����`��
	public void drawKeyLine() {
		// ������`��
		for (int i = 0; i < 10; i++) {
			// ��̃L�[��`��
			drawPolygon(4, 20);
			if (keyCounter == 13 || keyCounter == 16) {
				drawMark();
			}
			keyCounter++;

			// ���̈ʒu�Ɉړ�����
			moveTurtle(90, 30);
		}

		// �n�܂����ʒu�ɖ߂�
		moveTurtle(-90, 30 * 10);
	}

	// �}�[�N������
	public void drawMark() {
		moveTurtle(0, 5);
		moveTurtle(90, 5);
		rt(90);
		fd(10);
		lt(90);
		moveTurtle(180, 5);
		moveTurtle(-90, 15);
	}

	// �w�肳�ꂽ�����Ɂi�y�����グ�āj�ړ�����
	public void moveTurtle(double direction, int distance) {
		up();
		rt(direction);
		fd(distance);
		lt(direction);
		down();
	}

	// �w�肳�ꂽ�p���̐����p�`��`��
	public void drawPolygon(int n, int size) {
		double angle = 360d / (double) n;
		for (int i = 0; i < n; i++) {
			fd(size);
			rt(angle);
		}
	}
}
