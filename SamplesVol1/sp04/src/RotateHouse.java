import obpro.turtle.Turtle;

/*
 * �v���O�������F �͂��߂ẴA�j���[�V����
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class RotateHouse extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new RotateHouse());
	}

	// �^�[�g���𓮂�������
	public void start() {
		hide();

		// ����������
		House myHouse = new House();
		update();

		// �A�j���[�V����������
		while (true) {
			// �܂�
			sleep(0.025);

			// ����������������
			myHouse.fd(5);
			myHouse.rt(5);

			// �X�V����
			update();
		}
	}

}
