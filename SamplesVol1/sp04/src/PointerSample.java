import obpro.turtle.Turtle;

/*
 * �v���O�������F �j�b�N�l�[�������� �Q�Ƃ𗝉����邽�߂̗��
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/18)
 */
public class PointerSample extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new PointerSample());
	}

	// �^�[�g���𓮂�������
	public void start() {
		hide();

		// �T���Y�����
		Turtle kametaro;
		kametaro = new Turtle();

		// ���Y�Ƃ����ʖ�������
		Turtle taro;
		taro = kametaro;

		// t�Ƃ����ʖ�������
		Turtle t;
		t = taro;

		// �T���Y���~�ʂ�`��
		for (int i = 0; i < 60; i++) {
			kametaro.rt(2);
			kametaro.fd(2);
		}

		// ���Y���l�p�`�������i�T���Y�������j
		for (int i = 0; i < 4; i++) {
			taro.fd(50);
			taro.rt(90);
		}

		// t���O�p�`�������i�T���Y�������j
		for (int i = 0; i < 3; i++) {
			t.fd(100);
			t.rt(120);
		}
	}
}
