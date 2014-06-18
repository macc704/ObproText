package trace_quiz.sp04;

import java.util.ArrayList;

import obpro.turtle.ImageTurtle;
import obpro.turtle.Turtle;

/*
 * �g���[�X���i�Q�Ɓj
 * �E���L�v���O�����ɂ͖�肪����̂ŁC���s�s�\�ɂȂ����Ƃ���Ńg���[�X���~���C���R���l�@����
 * �E�A���C�摜�ǂݍ��݁i46�s�ځj�ɂ͖��͂Ȃ����̂Ƃ���
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class TraceQuizReference extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new TraceQuizReference());
	}

	// �^�[�g���𓮂�������
	public void start() {
		ArrayList<ImageTurtle> manImages = new ArrayList<ImageTurtle>();
		ImageTurtle man = null;// ImageTurtle man;

		// ����������
		hide();
		initialize(manImages);
		update();

		// �A�j���[�V����������
		int counter = 0;
		while (true) {
			sleep(0.1);
			processOneStep(man, manImages, counter);
			update();
			counter++;
		}
	}

	// �摜������������
	private void initialize(ArrayList<ImageTurtle> manImages) {
		// �摜������������
		for (int i = 0; i < 2; i++) {
			ImageTurtle man = new ImageTurtle("man" + (i + 1) + ".gif");
			man.hide();
			manImages.add(man);
		}
	}

	// ��X�e�b�v�̏���������
	private void processOneStep(ImageTurtle man,
			ArrayList<ImageTurtle> manImages, int counter) {
		int imgNum = counter % 2;
		ImageTurtle img = manImages.get(imgNum);
		man.looks(img);
	}

}