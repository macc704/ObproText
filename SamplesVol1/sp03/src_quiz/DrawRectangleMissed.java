import obpro.turtle.Turtle;

/**
 * ���P�|A�F
 * �l�p�`���������Ǝv�������C�v���O�������Ƃ܂�Ȃ��D
 * �Ȃ����l�@���āC�v���O�������C������
 */
public class DrawRectangleMissed extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new DrawRectangleMissed());
	}

	// �^�[�g���𓮂�������
	public void start() {
		int i = 0;
		while (i < 4) {
			fd(100);
			rt(90);
			i = i++;
		}
	}

}
