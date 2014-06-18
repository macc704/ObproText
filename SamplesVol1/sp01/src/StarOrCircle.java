import obpro.turtle.Turtle;

/*
 * プログラム名: 例題２ 星，もしくは円を書くプログラム
 * StarOrCircle.java
 * 
 * @author Yoshiaki Matsuzawa 
 * @date 2007/04/19
 */
public class StarOrCircle extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new StarOrCircle());
	}

	public void start() {

		// 星か円を選んでもらう
		print("星は1, 円は2を入力してください．");
		int kind = input();

		// 大きさ（長さ）を選んでもらう
		print("大きさ(長さ)を入力してください．");
		int length = input();

		// 星または円を書く
		if (kind == 1) {
			// 星を書く
			rt(18);
			for (int i = 0; i < 5; i++) {
				fd(length);
				rt(144);
			}
			lt(18);
		} else if (kind == 2) {
			// 円を書く
			for (int i = 0; i < 72; i++) {
				fd(length);
				rt(5);
			}
		} else {
			// エラー処理
			print("1または2を入力してください．");
		}
	}
}
