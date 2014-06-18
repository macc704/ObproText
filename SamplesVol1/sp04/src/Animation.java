import java.util.ArrayList;

import obpro.turtle.ImageTurtle;
import obpro.turtle.Turtle;

/*
 * �v���O�������F�����A�j���[�V����
 * looks���߂�Squeak�́u�����ڂ�ς���v���@���Q�l�ɍ���Ă��܂��D
 * 
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class Animation extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new Animation());
	}

	ImageTurtle man;
	ArrayList<ImageTurtle> manImages;

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
		// �A�j���[�V��������l
		man = new ImageTurtle("src/img/man1.gif");

		// �摜������������
		manImages = new ArrayList<ImageTurtle>();
		for (int i = 0; i < 8; i++) {
			manImages.add(new ImageTurtle("src/img/man" + (i + 1) + ".gif"));// ���ꕨ�̓Y����0����n�܂邱�Ƃɒ��ӂ���
		}
		// �B���Ă���
		for (ImageTurtle manImage : manImages) {
			manImage.hide();
		}
	}

	// ��X�e�b�v�̏���������
	private void processOneStep(int counter) {
		// ���̉摜�ɕς���
		int nextImageIndex = counter % 8;
		ImageTurtle nextImage = manImages.get(nextImageIndex);
		man.looks(nextImage);

		// man.looks(manImages.get(counter % 8));���ƈ�s�ŏ�����D
	}

}
