import obpro.turtle.Turtle;

/*
 * �v���O�������F ���܂ō�������̂��I�u�W�F�N�g�Ƃ��Ďg��
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class DrawObject extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new DrawObject());
	}

	// �^�[�g���𓮂�������
	public void start() {
		hide();

		// �Ƃ�\������
		House myHouse = new House();// House.java�𓯂��t�H���_�ɂ�������
		myHouse.fd(5);// �^�[�g���Ɠ������߁{�����g����
		update();// ���܂łƈ���āC�X�V���߂����Ȃ��ƁC��ʂ͍X�V����Ȃ�
	}

}
