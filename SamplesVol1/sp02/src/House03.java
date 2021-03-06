import obpro.turtle.Turtle;

/*
 * House03.java 窓付きの家を描くプログラム（３）
 * 
 * @author 荒木（松澤修正）
 * @version 2007/04/26 13:17:08
 */
public class House03 extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new House03());
	}

	// 家を描く
	public void start() {
		drawRoof(); // 屋根を描く
		drawWall(); // 壁を描く
		drawWindow(); // 窓を描く
	}

	// 屋根を描く
	void drawRoof() {
		drawRegularPolygon(3, 80); // 三角形を描く
	}

	// 壁を描く
	void drawWall() {
		rt(90); // 向きを調節する
		drawRegularPolygon(4, 80);// 四角形を描く
		lt(90);// 向きを上向きに戻す
	}

	// 窓を描く
	void drawWindow() {
		// 窓を描く位置まで移動する
		moveToWindowLocation(22);

		// 窓を描く
		rt(90);
		for (int i = 0; i < 4; i++) {
			drawRegularPolygon(4, 16);
			fd(16 * 2 + 4);
			rt(90);
		}
		lt(90);
	}

	// 指定された角数の正多角形を描く
	void drawRegularPolygon(int n, int size) {
		// 向きを調節する
		double angle = 360d / (double) n;
		rt(angle - 90);

		// 多角形を描く
		for (int i = 0; i < n; i++) {
			fd(size);
			rt(angle);
		}

		// 向きを上向きに戻す
		lt(angle - 90);
	}

	// 窓を描く位置まで移動する
	void moveToWindowLocation(int length) {
		moveTurtle(90, 22);// 右へ
		moveTurtle(180, 22);// 下へ
	}

	// 指定された方向に（ペンを上げて）移動する
	void moveTurtle(double direction, int distance) {
		up();
		rt(direction);
		fd(distance);
		lt(direction);
		down();
	}

}
