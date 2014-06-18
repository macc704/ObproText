import java.util.ArrayList;

import obpro.turtle.ImageTurtle;
import obpro.turtle.Turtle;

/*
 * プログラム名：歩くアニメーション
 * looks命令はSqueakの「見た目を変える」方法を参考に作られています．
 * 
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/17)
 */
public class Animation extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new Animation());
	}

	ImageTurtle man;
	ArrayList<ImageTurtle> manImages;

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
		// アニメーションする人
		man = new ImageTurtle("src/img/man1.gif");

		// 画像を初期化する
		manImages = new ArrayList<ImageTurtle>();
		for (int i = 0; i < 8; i++) {
			manImages.add(new ImageTurtle("src/img/man" + (i + 1) + ".gif"));// 入れ物の添字は0から始まることに注意する
		}
		// 隠しておく
		for (ImageTurtle manImage : manImages) {
			manImage.hide();
		}
	}

	// 一ステップの処理をする
	private void processOneStep(int counter) {
		// 次の画像に変える
		int nextImageIndex = counter % 8;
		ImageTurtle nextImage = manImages.get(nextImageIndex);
		man.looks(nextImage);

		// man.looks(manImages.get(counter % 8));だと一行で書ける．
	}

}
