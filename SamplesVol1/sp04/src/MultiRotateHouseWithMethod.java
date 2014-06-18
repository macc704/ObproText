import java.util.ArrayList;

import obpro.turtle.Turtle;

/*
 * プログラム名： たくさんの家 メソッドを作って構造化する
 * 
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/17)
 */
public class MultiRotateHouseWithMethod extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new MultiRotateHouseWithMethod());
	}

	// タートルを動かす処理
	public void start() {
		hide();

		// 初期化する
		ArrayList<House> houses = initializeHouses();
		update();

		// アニメーションをする
		while (true) {
			sleep(0.025);
			processOneStep(houses);
			update();
		}
	}

	// 家を初期化する
	private ArrayList<House> initializeHouses() {
		ArrayList<House> houses = new ArrayList<House>();
		for (int i = 0; i < 10; i++) {
			houses.add(new House());
		}
		for (House house : houses) {
			house.warp(random(300), random(300));
			house.size(random(100), random(150));
		}
		return houses;
	}

	// 一ステップの処理をする
	private void processOneStep(ArrayList<House> houses) {
		for (House house : houses) {
			house.fd(3);
			house.rt(3);
		}
	}

}
