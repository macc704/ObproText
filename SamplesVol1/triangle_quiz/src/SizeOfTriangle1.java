/*
 * �v���O������: SizeOfTriangle1.java �O�p�`�̖ʐς����߂�v���O�����i���r���[�O�j
 * 
 * author macchan
 * version 1.0
 */
public class SizeOfTriangle1 {

	public static void main(String[] args) {
		SizeOfTriangle1 sizeOfTriangle1 = new SizeOfTriangle1();
		sizeOfTriangle1.main();
	}

	void main() {
		int base;
		int height;
		int size;

		// ��ӂƍ�����ǂݍ���
		base = input();
		height = input();

		// �f�[�^�����݂���
		while (base == 0 && height == 0) {
			// ��ӁE����������0���傫�������ł���
			if (base > 0 && height > 0) {
				size = base * height / 2;// �O�p�`�̖ʐς��v�Z����
				print("�O�p�`�̖ʐς�" + size);// �O�p�`�̖ʐς�\������
			} else {
				print("�G���[�ł�");// �G���[���b�Z�[�W��\������
			}

			// ��ӂƍ�����ǂݍ���
			base = input();
			height = input();
		}
	}

	// �i�����́j���͂��󂯎��i�������j
	int input() {
		return 0;
	}

	// �v�����g����i�������j
	void print(String s) {
	}
}