import java.util.ArrayList;

import obpro.turtle.Turtle;

/*
 * �v���O�������F ��������̉� ���\�b�h������č\��������
 * 
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class MultiRotateHouseWithMethod extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new MultiRotateHouseWithMethod());
	}

	// �^�[�g���𓮂�������
	public void start() {
		hide();

		// ����������
		ArrayList<House> houses = initializeHouses();
		update();

		// �A�j���[�V����������
		while (true) {
			sleep(0.025);
			processOneStep(houses);
			update();
		}
	}

	// �Ƃ�����������
	private ArrayList<House> initializeHouses() {
		ArrayList<House> houses = new ArrayList<House>();
		for (int i = 0; i < 10; i++) {
			houses.add(new House());
		}
		for (House house : houses) {
			house.warp(random(300), random(300));
			house.size(random(100), random(150));
		}
		return houses;
	}

	// ��X�e�b�v�̏���������
	private void processOneStep(ArrayList<House> houses) {
		for (House house : houses) {
			house.fd(3);
			house.rt(3);
		}
	}

}
