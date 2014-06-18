package trace_quiz.sp02;

import obpro.turtle.Turtle;

/**
 * @プログラム名： 
 * @作成： 
 */
public class TraceQuizMethodTurtle01 extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new TraceQuizMethodTurtle01());
	}

	// 
	public void start() {
		// 
		rt(90);

		// 
		for (int i = 3; i < 6; i++) {
			methodA(i, 200 / i);
		}
	}

	// 
	void methodA(int param1, int param2) {
		// 
		rt(180 / param1);

		// 
		for (int i = 0; i < param1; i++) {
			fd(param2);
			rt(360 / param1);
		}

		// 
		lt(180 / param1);
	}
}
