package trace_quiz.sp01;

import obpro.turtle.Turtle;

/**
 * @�v���O�������F�@
 * @�쐬�ҁF
 */
public class TraceQuizTurtle01 extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new TraceQuizTurtle01());
	}

	// �^�[�g���𓮂�������
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
