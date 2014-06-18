import java.util.ArrayList;

import obpro.turtle.Turtle;

/*
 * プログラム名： たくさんの家
 * グローバルでもOK.でも，本当に全体で使うものしかグローバルにしてはいけません．
 * 引数，戻り値が基本です．濫用は減点です．
 * 
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/17)
 */
public class MultiRotateHouseWithGlobal extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new MultiRotateHouseWithGlobal());
	}

	ArrayList<House> houses;

	// タートルを動かす処理
	public void start() {
		hide();

		// 初期化する
		initialize();
		update();

		// アニメーションをする
		while (true) {
			sleep(0.025);
			processOneStep();
			update();
		}
	}

	// 家を初期化する
	private void initialize() {
		houses = new ArrayList<House>();
		for (int i = 0; i < 10; i++) {
			houses.add(new House());
		}
		for (House house : houses) {
			house.warp(random(300), random(300));
			house.size(random(100), random(150));
		}
	}

	// 一ステップの処理をする
	private void processOneStep() {
		for (House house : houses) {
			house.fd(3);
			house.rt(3);
		}
	}

}
