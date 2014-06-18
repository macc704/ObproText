import obpro.turtle.Turtle;

/*
 * KeyboardMissed.java
 * キーボードを書くプログラム（意図通り動かないもの）
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
		// １０×３のキーを書く
		for (int i = 0; i < 3; i++) {
			drawKeyLine();// キーボードの横一列を描く
			moveTurtle(180, 30);// 次の位置に移動する
		}
	}

	// キーボードの横一列を描く
	public void drawKeyLine() {
		// 横一列を描く
		for (int i = 0; i < 10; i++) {
			// 一つのキーを描く
			drawPolygon(4, 20);
			if (keyCounter == 13 || keyCounter == 16) {
				drawMark();
			}
			keyCounter++;

			// 次の位置に移動する
			moveTurtle(90, 30);
		}

		// 始まった位置に戻す
		moveTurtle(-90, 30 * 10);
	}

	// マークを書く
	public void drawMark() {
		moveTurtle(0, 5);
		moveTurtle(90, 5);
		rt(90);
		fd(10);
		lt(90);
		moveTurtle(180, 5);
		moveTurtle(-90, 15);
	}

	// 指定された方向に（ペンを上げて）移動する
	public void moveTurtle(double direction, int distance) {
		up();
		rt(direction);
		fd(distance);
		lt(direction);
		down();
	}

	// 指定された角数の正多角形を描く
	public void drawPolygon(int n, int size) {
		double angle = 360d / (double) n;
		for (int i = 0; i < n; i++) {
			fd(size);
			rt(angle);
		}
	}
}
