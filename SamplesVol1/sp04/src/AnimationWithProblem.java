import java.util.ArrayList;

import obpro.turtle.ImageTurtle;
import obpro.turtle.Turtle;

/*
 * プログラム名: 問題ありアニメーション
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/17)
 */
public class AnimationWithProblem extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new AnimationWithProblem());
	}

	final String IMG_FOLDER = "lectures/lecture05/src/img/";

	ImageTurtle man = new ImageTurtle();

	ArrayList<ImageTurtle> manImages = new ArrayList<ImageTurtle>();

	// タートルを動かす処理
	public void start() {
		hide();

		// 初期化する
		initialize();
		update();

		// アニメーションをする
		int counter = 0;
		while (true) {
			sleep(0.1);
			processOneStep(counter);
			update();
			counter++;
		}
	}

	// 画像を初期化する
	private void initialize() {
		// 画像を初期化する
		for (int i = 1; i <= 8; i++) {
			ImageTurtle manImage = new ImageTurtle(IMG_FOLDER + "man" + i
					+ ".gif");
			manImage.hide();
			manImages.add(manImage);
		}
	}

	// 一ステップの処理をする
	private void processOneStep(int counter) {
		man.looks(manImages.get(counter % 8));
	}

}
