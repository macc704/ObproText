import obpro.turtle.Turtle;

/**
 * ���P�|B�F
 * ���\�p�`���������Ǝv�������C�v���O�������Ƃ܂�Ȃ��D
 * �Ȃ����l�@���āC�v���O�������C������
 */
public class DrawDecagonMissed extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new DrawDecagonMissed());
	}

	// �^�[�g���𓮂�������
	public void start() {
		double i = 0.1;
		while (true) {
			fd(20);
			rt(36);
			i = i + 0.1;
			if (i == 1.0) {
				break;
			}
		}
	}

}
