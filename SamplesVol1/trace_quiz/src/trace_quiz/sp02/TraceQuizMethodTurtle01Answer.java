package trace_quiz.sp02;

import obpro.turtle.Turtle;

/**
 * @�v���O�������F �L�k��`���v���O����
 * @�쐬�F �����̂ɂ� (2008/5/22)
 * @�C���F ���V�F��(macchan)(2008/5/23)
 */
public class TraceQuizMethodTurtle01Answer extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new TraceQuizMethodTurtle01Answer());
	}

	// �L�k��`��
	public void start() {
		// �������̊L�k�ɂ���
		rt(90);

		// �L�k��`��
		for (int i = 3; i < 6; i++) {
			methodA(i, 200 / i);
		}
	}

	// �����p�`��`��
	void methodA(int param1, int param2) {
		// �������ɂȂ�悤�Ɋp�x�𒲐߂���
		rt(180 / param1);

		// �����p�`��`��
		for (int i = 0; i < param1; i++) {
			fd(param2);
			rt(360 / param1);
		}

		// �p�x��߂�
		lt(180 / param1);
	}
}
