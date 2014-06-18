import obpro.turtle.Turtle;


/*
 * KeyboardMissed.java
 * Created on 2007/04/23 by macchan
 * Copyright(c) 2007 CreW Project
 */

/**
 * KeyboardMissed
 */
public class MissedKeyboardResolve2 extends Turtle {

	public static void main(String[] args) {
		Turtle.startTurtle(new MissedKeyboardResolve2());
	}

	class KeyCounter {
		int count = 0;
	}

	public void start() {
		KeyCounter keyCounter = new KeyCounter();

		// �P�O�~�R�̃L�[������
		for (int i = 0; i < 3; i++) {
			drawKeyLine(keyCounter);// �L�[�{�[�h�̉�����`��
			move(180, 30);// ���̈ʒu�Ɉړ�����
		}
	}

	// �L�[�{�[�h�̉�����`��
	void drawKeyLine(KeyCounter keyCounter) {
		// ������`��
		for (int i = 0; i < 10; i++) {
			// ��̃L�[��`��
			drawPolygon(4, 20);
			if (keyCounter.count == 13 || keyCounter.count == 16) {
				drawMark();
			}
			keyCounter.count++;

			// ���̈ʒu�Ɉړ�����
			move(90, 30);
		}

		// �n�܂����ʒu�ɖ߂�
		move(-90, 30 * 10);
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
