import obpro.turtle.ImageTurtle;
import obpro.turtle.Turtle;

/*
 * �v���O�������F �_��
 * �摜�������Ă���t�H���_�́u�v���W�F�N�g�̃t�H���_�v����_�ƂȂ�܂��D�K�X�ύX���Ă�������
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class OnAndOffAnimation extends Turtle {
	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new OnAndOffAnimation());
	}

	ImageTurtle man;

	// �^�[�g���𓮂�������
	public void start() {
		hide();

		// ����������
		initialize();
		update();

		// �A�j���[�V����������
		int counter = 0;
		while (true) {
			sleep(0.5);
			processOneStep(counter);
			update();
			counter++;
		}
	}

	// �Ƃ�����������
	private void initialize() {
		man = new ImageTurtle("src/img/man1.gif");
	}

	// ��X�e�b�v�̏���������
	private void processOneStep(int counter) {
		if (counter % 2 == 0) {
			man.hide();
		} else {
			man.show();
		}
	}
}
