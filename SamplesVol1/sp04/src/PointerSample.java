import obpro.turtle.Turtle;

/*
 * プログラム名： ニックネームをつける 参照を理解するための例題
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/18)
 */
public class PointerSample extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new PointerSample());
	}

	// タートルを動かす処理
	public void start() {
		hide();

		// 亀太郎を作る
		Turtle kametaro;
		kametaro = new Turtle();

		// 太郎という別名をつける
		Turtle taro;
		taro = kametaro;

		// tという別名をつける
		Turtle t;
		t = taro;

		// 亀太郎が円弧を描く
		for (int i = 0; i < 60; i++) {
			kametaro.rt(2);
			kametaro.fd(2);
		}

		// 太郎が四角形を書く（亀太郎が動く）
		for (int i = 0; i < 4; i++) {
			taro.fd(50);
			taro.rt(90);
		}

		// tが三角形を書く（亀太郎が動く）
		for (int i = 0; i < 3; i++) {
			t.fd(100);
			t.rt(120);
		}
	}
}
