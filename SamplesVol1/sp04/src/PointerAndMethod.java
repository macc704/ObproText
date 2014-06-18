import obpro.turtle.Turtle;

/*
 * プログラム名： 参照をメソッドの引数にする
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/17)
 */
public class PointerAndMethod extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new PointerAndMethod());
	}

	// タートルを動かす処理
	public void start() {
		hide();

		// 太郎と次郎を作る
		Turtle taro = new Turtle();
		Turtle jiro = new Turtle();
		jiro.bk(100);

		// 二つの五角形を描く
		drawRegularPolygon(taro, 5, 20);// 太郎が五角形を書く
		drawRegularPolygon(jiro, 5, 20);// 次郎が五角形を書く
	}

	// 指定されたタートルが，指定された角数の正多角形を描く
	public void drawRegularPolygon(Turtle t, int n, int size) {
		// 向きを調節する
		double angle = 360d / (double) n;
		rt(angle - 90);

		// 多角形を描く
		for (int i = 0; i < n; i++) {
			t.fd(size);
			t.rt(angle);
		}

		// 向きを上向きに戻す
		lt(angle - 90);
	}

}
