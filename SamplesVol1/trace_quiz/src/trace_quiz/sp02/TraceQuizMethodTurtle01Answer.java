package trace_quiz.sp02;

import obpro.turtle.Turtle;

/**
 * @プログラム名： 貝殻を描くプログラム
 * @作成： こうのにな (2008/5/22)
 * @修正： 松澤芳昭(macchan)(2008/5/23)
 */
public class TraceQuizMethodTurtle01Answer extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new TraceQuizMethodTurtle01Answer());
	}

	// 貝殻を描く
	public void start() {
		// 下向きの貝殻にする
		rt(90);

		// 貝殻を描く
		for (int i = 3; i < 6; i++) {
			methodA(i, 200 / i);
		}
	}

	// 正多角形を描く
	void methodA(int param1, int param2) {
		// 下向きになるように角度を調節する
		rt(180 / param1);

		// 正多角形を描く
		for (int i = 0; i < param1; i++) {
			fd(param2);
			rt(360 / param1);
		}

		// 角度を戻す
		lt(180 / param1);
	}
}
