import obpro.turtle.Turtle;

/*
 * プログラム名:コッホ曲線を描くプログラム
 * 
 * author 佐藤TA
 * version $Id: Koch.java,v 1.3 2007/05/10 13:43:55 camei Exp $
 */
public class Koch extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new Koch());
	}

	// コッホ曲線を描く
	public void start() {
		// 前処理
		window.size(500, 200);// ウインドウサイズを設定
		window.setKameSpeed("very fast");// 亀の速度を設定

		// コッホ曲線を描く
		rt(90);// 初期描画位置に移動
		drawKoch(3, 200);
	}

	// （再帰的に）コッホ曲線を描く
	private void drawKoch(int level, int length) {
		// 再帰の終わり
		if (level == 0) {
			fd(length);
			return;
		}

		// 再帰的にコッホ曲線を描く
		drawKoch(level - 1, length / 3);
		lt(60);
		drawKoch(level - 1, length / 3);
		rt(120);
		drawKoch(level - 1, length / 3);
		lt(60);
		drawKoch(level - 1, length / 3);
	}
}
