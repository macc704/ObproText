import obpro.turtle.Turtle;

/*
 * �v���O�������F 2�C�̋T �C���X�^���X�̐���
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class MultiTurtle extends Turtle {
	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new MultiTurtle());
	}

	// �^�[�g���𓮂�������
	public void start() {
		hide();// �����ݒ�̃^�[�g���͎g��Ȃ��̂ŉB��

		// ���Y�����
		Turtle taro;
		taro = new Turtle();

		// ���Y�����
		Turtle jiro;
		jiro = new Turtle();

		// ���Y���l�p�`������
		for (int i = 0; i < 4; i++) {
			taro.fd(50);
			taro.rt(90);
		}

		// ���Y���l�p�`������
		for (int i = 0; i < 4; i++) {
			jiro.fd(50);
			jiro.lt(90);
		}

		// ���Y�Ǝ��Y���~������
		for (int i = 0; i < 36; i++) {
			taro.fd(3);
			taro.rt(10);
			jiro.fd(3);
			jiro.lt(10);
		}
	}
}
