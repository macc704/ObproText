import java.util.ArrayList;

import obpro.turtle.Turtle;

/*
 * �v���O�������F �^�[�g�����[�X
 * ���߂Ẵ��X�g�i���ꕨ�j�̗�� (Java1.4 �ȑO�̃o�[�W�����̏ꍇ�j
 * 
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/17)
 */
public class TurtleRace14 extends Turtle {

	// �N������
	public static void main(String[] args) {
		Turtle.startTurtle(new TurtleRace14());
	}

	// �^�[�g���𓮂�������
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void start() {
		hide();

		// �^�[�g���ւ̎Q�ƃ��X�g�i���ꕨ�j
		ArrayList turtles = new ArrayList();

		// �^�[�g���B���쐬����
		for (int i = 0; i < 3; i++) {
			Turtle turtle = new Turtle();
			turtles.add(turtle);
		}

		// �^�[�g���B�������ǂ����ׂ�
		int size = turtles.size();
		for (int i = 0; i < size; i++) {
			Turtle turtle = (Turtle) turtles.get(i);
			turtle.bk(30 * i);
		}

		// �^�[�g���B���E������
		for (int i = 0; i < size; i++) {
			((Turtle) turtles.get(i)).rt(90);
		}

		// �^�[�g���������X�^�[�g�ʒu��
		for (int i = 0; i < size; i++) {
			((Turtle) turtles.get(i)).fd(20);
		}

		// �u�p�ӁI�X�^�[�g�I�v�����o����
		sleep(1);// 1�b�҂�

		// ���[�X������
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < size; j++) {
				((Turtle) turtles.get(j)).fd(random(5));
			}
		}
	}

}
