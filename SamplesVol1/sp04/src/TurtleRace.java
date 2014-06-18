import java.util.ArrayList;

import obpro.turtle.Turtle;

/*
 * �v���O�������F �^�[�g�����[�X
 * ���߂Ẵ��X�g�i���ꕨ�j�̗��
 * ���C�u������import����Ă��Ȃ��ꍇCtrl + Shift + O �Ŏ���Import�ł��܂��D
 * 
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class TurtleRace extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new TurtleRace());
	}

	// �^�[�g���𓮂�������
	public void start() {
		hide();

		// �^�[�g���ւ̎Q�ƃ��X�g�i���ꕨ�j
		ArrayList<Turtle> turtles = new ArrayList<Turtle>();

		// �^�[�g���B���쐬����
		for (int i = 0; i < 10; i++) {
			Turtle turtle = new Turtle();
			turtles.add(turtle);
		}

		// �^�[�g���B�������ǂ����ׂ�
		int size = turtles.size();
		for (int i = 0; i < size; i++) {
			Turtle turtle = turtles.get(i);
			turtle.bk(30 * i);
		}

		// �^�[�g���B���E������
		for (int i = 0; i < size; i++) {
			turtles.get(i).rt(90);
		}

		// �^�[�g���������X�^�[�g�ʒu��
		for (Turtle turtle : turtles) {
			turtle.fd(20);
		}

		// �u�p�ӁI�X�^�[�g�I�v�����o����
		sleep(1);// 1�b�҂�

		// ���[�X������
		for (int i = 0; i < 100; i++) {
			for (Turtle turtle : turtles) {
				turtle.fd(random(5));
			}
		}
	}

}
