import obpro.turtle.Turtle;


/*
 * ���Q�F
 * �ȉ��̂悤�ɏ�������C�Ӑ}�ǂ��蓮���Ȃ������D
 * �P�j�t���[�`���[�g��`���i1���ɓ��肫��悤�ɁC�ڍׂ��ȗ����Ă悢�j
 * �Q�j���̓����Ȃ����C���������Ă�
 * �R�j���������������ǂ����C�f�o�b�K�Ō��؂���
 * ���ʂ�200�����x�ɂ܂Ƃ߂�D
 * 
 * MultiObjectMissed.java
 * �}�`���i�O�p�`�C�l�p�`���݂Ɂj4�����v���O����(�̂���)
 * 2007/04/19
 * Yoshiaki Matsuzawa
 */
public class MultiObjectMissed extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new MultiObjectMissed());
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
					i = 0;
					while (i < 3) {
						fd(50);
						rt(120);
						i++;
					}

					// �㏈��
					lt(30);
				}
			} else {
				// �l�p�`������
				i = 0;
				while (i < 4) {
					fd(50);
					rt(90);
					i++;
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