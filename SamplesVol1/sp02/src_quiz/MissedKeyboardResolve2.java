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

		// １０×３のキーを書く
		for (int i = 0; i < 3; i++) {
			drawKeyLine(keyCounter);// キーボードの横一列を描く
			move(180, 30);// 次の位置に移動する
		}
	}

	// キーボードの横一列を描く
	void drawKeyLine(KeyCounter keyCounter) {
		// 横一列を描く
		for (int i = 0; i < 10; i++) {
			// 一つのキーを描く
			drawPolygon(4, 20);
			if (keyCounter.count == 13 || keyCounter.count == 16) {
				drawMark();
			}
			keyCounter.count++;

			// 次の位置に移動する
			move(90, 30);
		}

		// 始まった位置に戻す
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
