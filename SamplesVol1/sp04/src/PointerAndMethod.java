import obpro.turtle.Turtle;

/*
 * �v���O�������F �Q�Ƃ����\�b�h�̈����ɂ���
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class PointerAndMethod extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new PointerAndMethod());
	}

	// �^�[�g���𓮂�������
	public void start() {
		hide();

		// ���Y�Ǝ��Y�����
		Turtle taro = new Turtle();
		Turtle jiro = new Turtle();
		jiro.bk(100);

		// ��̌܊p�`��`��
		drawRegularPolygon(taro, 5, 20);// ���Y���܊p�`������
		drawRegularPolygon(jiro, 5, 20);// ���Y���܊p�`������
	}

	// �w�肳�ꂽ�^�[�g�����C�w�肳�ꂽ�p���̐����p�`��`��
	public void drawRegularPolygon(Turtle t, int n, int size) {
		// �����𒲐߂���
		double angle = 360d / (double) n;
		rt(angle - 90);

		// ���p�`��`��
		for (int i = 0; i < n; i++) {
			t.fd(size);
			t.rt(angle);
		}

		// ������������ɖ߂�
		lt(angle - 90);
	}

}
