/*
 * �v���O������: SizeOfTriangle2.java �O�p�`�̖ʐς����߂�v���O�����i���r���[��j
 * 
 * author macchan
 * version 1.0
 */
public class SizeOfTriangle2 {

	public static void main(String[] args) {
		SizeOfTriangle2 sizeOfTriangle2 = new SizeOfTriangle2();
		sizeOfTriangle2.main();
	}

	void main() {
		// (������)�O�p�`�̖ʐς����߂�
		while (true) {
			double base;
			double height;
			double size;

			// �O�p�`�̏���ǂݍ���
			base = Input.getDouble();// ��ӂ�ǂݍ���
			height = Input.getDouble();// ������ǂݍ���
			if (base == 0 && height == 0) {// �O�p�`�̏�񂪏I���
				break;
			}

			// �ǂݍ��񂾎O�p�`���ʐς��������ׂ�
			if (base < 0 || height < 0) {// �ǂݍ��񂾎O�p�`���ʐς������Ȃ��ꍇ
				System.out.println("�O�p�`���ʐς������܂���");// �G���[���b�Z�[�W��\������
				continue;
			}

			// �O�p�`�̖ʐς��v�Z����
			size = base * height / 2;

			// �O�p�`�̖ʐς�\������
			System.out.println("�O�p�`�̖ʐς�" + size);
		}
	}

}