package trace_quiz.sp01;

import obpro.turtle.Turtle;

/**
 * @プログラム名：　
 * @作成者：
 */
public class TraceQuizTurtle01 extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new TraceQuizTurtle01());
	}

	// タートルを動かす処理
	public void start() {

		//
		for (int i = 0; i < 2; i++) {

			//
			for (int j = 0; j < 2; j++) {

				//
				for (int k = 0; k < 4; k++) {
					down();
					fd(20);
					rt(90);
					up();
				}

				//
				rt(90);
				fd(30);
				lt(90);

			}

			//
			bk(30);
			lt(90);
			fd(60);
			rt(90);
		}
	}
}
