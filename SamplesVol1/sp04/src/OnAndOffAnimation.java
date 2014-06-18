import obpro.turtle.ImageTurtle;
import obpro.turtle.Turtle;

/*
 * プログラム名： 点滅
 * 画像をおいているフォルダは「プロジェクトのフォルダ」が基点となります．適宜変更してください
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/17)
 */
public class OnAndOffAnimation extends Turtle {
	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new OnAndOffAnimation());
	}

	ImageTurtle man;

	// タートルを動かす処理
	public void start() {
		hide();

		// 初期化する
		initialize();
		update();

		// アニメーションをする
		int counter = 0;
		while (true) {
			sleep(0.5);
			processOneStep(counter);
			update();
			counter++;
		}
	}

	// 家を初期化する
	private void initialize() {
		man = new ImageTurtle("src/img/man1.gif");
	}

	// 一ステップの処理をする
	private void processOneStep(int counter) {
		if (counter % 2 == 0) {
			man.hide();
		} else {
			man.show();
		}
	}
}
