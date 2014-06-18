package trace_quiz.sp04;

import java.util.ArrayList;

import obpro.turtle.ImageTurtle;
import obpro.turtle.Turtle;

/*
 * トレース問題（参照）
 * ・下記プログラムには問題があるので，実行不能になったところでトレースを停止し，理由を考察せよ
 * ・但し，画像読み込み（46行目）には問題はないものとする
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/17)
 */
public class TraceQuizReference extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new TraceQuizReference());
	}

	// タートルを動かす処理
	public void start() {
		ArrayList<ImageTurtle> manImages = new ArrayList<ImageTurtle>();
		ImageTurtle man = null;// ImageTurtle man;

		// 初期化する
		hide();
		initialize(manImages);
		update();

		// アニメーションをする
		int counter = 0;
		while (true) {
			sleep(0.1);
			processOneStep(man, manImages, counter);
			update();
			counter++;
		}
	}

	// 画像を初期化する
	private void initialize(ArrayList<ImageTurtle> manImages) {
		// 画像を初期化する
		for (int i = 0; i < 2; i++) {
			ImageTurtle man = new ImageTurtle("man" + (i + 1) + ".gif");
			man.hide();
			manImages.add(man);
		}
	}

	// 一ステップの処理をする
	private void processOneStep(ImageTurtle man,
			ArrayList<ImageTurtle> manImages, int counter) {
		int imgNum = counter % 2;
		ImageTurtle img = manImages.get(imgNum);
		man.looks(img);
	}

}