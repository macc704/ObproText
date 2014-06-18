import obpro.turtle.Turtle;

/*
 * KeyboardMissed.java
 * Created on 2007/04/23 by macchan
 * Copyright(c) 2007 CreW Project
 */

/**
 * KeyboardMissed
 */
public class MissedKeyboardResolve1 extends Turtle {

	public static void main(String[] args) {
		Turtle.startTurtle(new MissedKeyboardResolve1());
	}

	public void start() {
		int keyCounter = 0;

		// �P�O�~�R�̃L�[������
		for (int i = 0; i < 3; i++) {
			keyCounter = drawKeyLine(keyCounter);// �L�[�{�[�h�̉�����`��
			move(180, 30);// ���̈ʒu�Ɉړ�����
		}
	}

	// �L�[�{�[�h�̉�����`��
	int drawKeyLine(int keyCounter) {
		// ������`��
		for (int i = 0; i < 10; i++) {
			// ��̃L�[��`��
			drawPolygon(4, 20);
			if (keyCounter == 13 || keyCounter == 16) {
				drawMark();
			}
			keyCounter++;

			// ���̈ʒu�Ɉړ�����
			move(90, 30);
		}

		// �n�܂����ʒu�ɖ߂�
		move(-90, 30 * 10);

		return keyCounter;
	}

	void drawMark() {
		move(0, 5);
		move(90, 5);
		rt(90);
		fd(10);
		lt(90);
		move(180, 5);
		move(-90, 15);
	}

	// �w�肳�ꂽ�����Ɂi�y�����グ�āj�ړ�����
	void move(double direction, int distance) {
		up();
		rt(direction);
		fd(distance);
		lt(direction);
		down();
	}

	// �w�肳�ꂽ�p���̐����p�`��`��
	void drawPolygon(int n, int size) {
		double angle = 360d / (double) n;
		for (int i = 0; i < n; i++) {
			fd(size);
			rt(angle);
		}
	}
}
