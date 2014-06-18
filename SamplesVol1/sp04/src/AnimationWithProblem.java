import java.util.ArrayList;

import obpro.turtle.ImageTurtle;
import obpro.turtle.Turtle;

/*
 * �v���O������: ��肠��A�j���[�V����
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class AnimationWithProblem extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new AnimationWithProblem());
	}

	final String IMG_FOLDER = "lectures/lecture05/src/img/";

	ImageTurtle man = new ImageTurtle();

	ArrayList<ImageTurtle> manImages = new ArrayList<ImageTurtle>();

	// �^�[�g���𓮂�������
	public void start() {
		hide();

		// ����������
		initialize();
		update();

		// �A�j���[�V����������
		int counter = 0;
		while (true) {
			sleep(0.1);
			processOneStep(counter);
			update();
			counter++;
		}
	}

	// �摜������������
	private void initialize() {
		// �摜������������
		for (int i = 1; i <= 8; i++) {
			ImageTurtle manImage = new ImageTurtle(IMG_FOLDER + "man" + i
					+ ".gif");
			manImage.hide();
			manImages.add(manImage);
		}
	}

	// ��X�e�b�v�̏���������
	private void processOneStep(int counter) {
		man.looks(manImages.get(counter % 8));
	}

}
