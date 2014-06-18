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

		// １０×３のキーを書く
		for (int i = 0; i < 3; i++) {
			keyCounter = drawKeyLine(keyCounter);// キーボードの横一列を描く
			move(180, 30);// 次の位置に移動する
		}
	}

	// キーボードの横一列を描く
	int drawKeyLine(int keyCounter) {
		// 横一列を描く
		for (int i = 0; i < 10; i++) {
			// 一つのキーを描く
			drawPolygon(4, 20);
			if (keyCounter == 13 || keyCounter == 16) {
				drawMark();
			}
			keyCounter++;

			// 次の位置に移動する
			move(90, 30);
		}

		// 始まった位置に戻す
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

	// 指定された方向に（ペンを上げて）移動する
	void move(double direction, int distance) {
		up();
		rt(direction);
		fd(distance);
		lt(direction);
		down();
	}

	// 指定された角数の正多角形を描く
	void drawPolygon(int n, int size) {
		double angle = 360d / (double) n;
		for (int i = 0; i < n; i++) {
			fd(size);
			rt(angle);
		}
	}
}
