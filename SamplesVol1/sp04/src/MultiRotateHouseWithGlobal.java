import java.util.ArrayList;

import obpro.turtle.Turtle;

/*
 * �v���O�������F ��������̉�
 * �O���[�o���ł�OK.�ł��C�{���ɑS�̂Ŏg�����̂����O���[�o���ɂ��Ă͂����܂���D
 * �����C�߂�l����{�ł��D���p�͌��_�ł��D
 * 
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class MultiRotateHouseWithGlobal extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new MultiRotateHouseWithGlobal());
	}

	ArrayList<House> houses;

	// �^�[�g���𓮂�������
	public void start() {
		hide();

		// ����������
		initialize();
		update();

		// �A�j���[�V����������
		while (true) {
			sleep(0.025);
			processOneStep();
			update();
		}
	}

	// �Ƃ�����������
	private void initialize() {
		houses = new ArrayList<House>();
		for (int i = 0; i < 10; i++) {
			houses.add(new House());
		}
		for (House house : houses) {
			house.warp(random(300), random(300));
			house.size(random(100), random(150));
		}
	}

	// ��X�e�b�v�̏���������
	private void processOneStep() {
		for (House house : houses) {
			house.fd(3);
			house.rt(3);
		}
	}

}
