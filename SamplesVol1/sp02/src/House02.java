import obpro.turtle.Turtle;

/*
 * House02.java 窓付きの家を描くプログラム（2） (引数つき）
 * 
 * @author 荒木（松澤修正）
 * @version 2007/04/26 13:17:08
 */
public class House02 extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new House02());
	}

	// 家を描く
	public void start() {
		drawRoof(); // 屋根を描く
		drawWall(); // 壁を描く
		drawWindow(); // 窓を描く
	}

	// 屋根を描く
	void drawRoof() {
		drawTriangle(80); // 三角形を描く
	}

	// 壁を描く
	void drawWall() {
		rt(90); // 向きを調節する
		drawRectangle(80);// 四角形を描く
		lt(90);// 向きを上向きに戻す
	}

	// 窓を描く
	void drawWindow() {
		// 窓を描く位置まで移動する
		moveToWindowLocation(22);

		// 窓を描く
		rt(90);
		for (int i = 0; i < 4; i++) {
			drawRectangle(16);
			fd(16 * 2 + 4);
			rt(90);
		}
		lt(90);
	}

	// 三角形を描く
	void drawTriangle(int size) {
		// 向きを調節する
		rt(30);

		// 三角形を描く
		for (int i = 0; i < 3; i++) {
			fd(size);
			rt(120);
		}

		// 向きを上向きに戻す
		lt(30);
	}

	// 四角形を描く
	void drawRectangle(int size) {
		for (int i = 0; i < 4; i++) {
			fd(size);
			rt(90);
		}
	}

	// 窓を描く位置まで移動する
	void moveToWindowLocation(int length) {
		// 前処理
		up();

		// 右へ
		rt(90);
		fd(length);

		// 下へ
		rt(90);
		fd(length);

		// 後処理
		rt(180);
		down();
	}

}
