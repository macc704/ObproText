import obpro.turtle.Turtle;

/*
 * �v���O�������F���R  �}�`���i�O�p�`�C�l�p�`���݂Ɂj4�����v���O����
 * MultiObject.java
 * 
 * @author Yoshiaki Matsuzawa 
 * @date 2007/04/19
 */
public class MultiObject extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new MultiObject());
	}

	public void start() {

		// �O����
		window.size(600, 200);

		// �}�`���i�O�p�`�C�l�p�`���݂Ɂj4����
		int i = 0;
		while (i < 4) {

			// �}�`������
			if (i % 2 == 0) {
				// �O�p�`������
				{
					// �O����
					rt(30);

					// �O�p�`�������{����
					int j = 0;
					while (j < 3) {
						fd(50);
						rt(120);
						j++;
					}

					// �㏈��
					lt(30);
				}
			} else {
				// �l�p�`������
				int j = 0;
				while (j < 4) {
					fd(50);
					rt(90);
					j++;
				}
			}

			// ���̈ʒu�Ɉړ�����
			{
				// �O����
				up();

				// �ړ�����{����
				rt(90);
				fd(100);
				lt(90);

				// �㏈��
				down();
			}

			// �㏈��
			i++;
		}
	}
}