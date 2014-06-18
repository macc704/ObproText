import java.util.ArrayList;
import obpro.turtle.Turtle;

/*
 * プログラム名： たくさんの家
 * オブジェクトのリストを使う
 * 
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/17)
 */
public class MultiRotateHouse extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new MultiRotateHouse());
	}

	// タートルを動かす処理
	public void start() {
		hide();

		// 初期化する
		ArrayList<House> houses = new ArrayList<House>();
		for (int i = 0; i < 10; i++) {
			houses.add(new House());
		}
		for (House house : houses) {
			house.warp(random(300), random(300));
			house.size(random(100), random(150));
		}
		update();

		// アニメーションをする
		while (true) {
			// まつ
			sleep(0.025);

			// 動かす処理をする
			for (House house : houses) {
				house.fd(3);
				house.rt(3);
			}

			// 更新する
			update();
		}
	}

}
