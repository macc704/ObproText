import obpro.turtle.Turtle;

/*
 * プログラム名： 2匹の亀 インスタンスの生成
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/17)
 */
public class MultiTurtle extends Turtle {
	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new MultiTurtle());
	}

	// タートルを動かす処理
	public void start() {
		hide();// 初期設定のタートルは使わないので隠す

		// 太郎を作る
		Turtle taro;
		taro = new Turtle();

		// 次郎を作る
		Turtle jiro;
		jiro = new Turtle();

		// 太郎が四角形を書く
		for (int i = 0; i < 4; i++) {
			taro.fd(50);
			taro.rt(90);
		}

		// 次郎が四角形を書く
		for (int i = 0; i < 4; i++) {
			jiro.fd(50);
			jiro.lt(90);
		}

		// 太郎と次郎が円を書く
		for (int i = 0; i < 36; i++) {
			taro.fd(3);
			taro.rt(10);
			jiro.fd(3);
			jiro.lt(10);
		}
	}
}
