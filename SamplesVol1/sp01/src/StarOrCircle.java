import obpro.turtle.Turtle;

/*
 * �v���O������: ���Q ���C�������͉~�������v���O����
 * StarOrCircle.java
 * 
 * @author Yoshiaki Matsuzawa 
 * @date 2007/04/19
 */
public class StarOrCircle extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new StarOrCircle());
	}

	public void start() {

		// �����~��I��ł��炤
		print("����1, �~��2����͂��Ă��������D");
		int kind = input();

		// �傫���i�����j��I��ł��炤
		print("�傫��(����)����͂��Ă��������D");
		int length = input();

		// ���܂��͉~������
		if (kind == 1) {
			// ��������
			rt(18);
			for (int i = 0; i < 5; i++) {
				fd(length);
				rt(144);
			}
			lt(18);
		} else if (kind == 2) {
			// �~������
			for (int i = 0; i < 72; i++) {
				fd(length);
				rt(5);
			}
		} else {
			// �G���[����
			print("1�܂���2����͂��Ă��������D");
		}
	}
}
