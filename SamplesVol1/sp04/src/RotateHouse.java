import obpro.turtle.Turtle;

/*
 * プログラム名： はじめてのアニメーション
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/17)
 */
public class RotateHouse extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new RotateHouse());
	}

	// タートルを動かす処理
	public void start() {
		hide();

		// 初期化する
		House myHouse = new House();
		update();

		// アニメーションをする
		while (true) {
			// まつ
			sleep(0.025);

			// 動かす処理をする
			myHouse.fd(5);
			myHouse.rt(5);

			// 更新する
			update();
		}
	}

}
