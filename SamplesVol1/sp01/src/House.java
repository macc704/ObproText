import obpro.turtle.Turtle;

/*
 * �v���O������:���P �Ƃ������v���O����
 * House.java
 * 
 * @author Yoshiaki Matsuzawa 
 * @date 2007/04/19
 */
public class House extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new House());
	}

	// �Ƃ�����
	public void start() {
		// ����������
		{
			// �O����
			rt(30);

			// �����������i�{�́j
			for (int i = 0; i < 3; i++) {
				fd(50);
				rt(120);
			}

			// �㏈��
			lt(30);
		}

		// ���ׂ�����
		for (int i = 0; i < 4; i++) {
			rt(90);
			fd(50);
		}

	}

}