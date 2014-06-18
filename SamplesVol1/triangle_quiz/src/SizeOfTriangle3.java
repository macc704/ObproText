/*
 * �v���O������: SizeOfTriangle3.java �O�p�`�̖ʐς����߂�v���O�����i���\�b�h���j
 * 
 * author macchan
 * version 1.0
 */
public class SizeOfTriangle3 {

	public static void main(String[] args) {
		SizeOfTriangle3 sizeOfTriangle3 = new SizeOfTriangle3();
		sizeOfTriangle3.main();
	}

	void main() {
		// (������)�O�p�`�̖ʐς����߂�
		while (true) {
			double base;
			double height;
			double size;

			// �O�p�`�̏���ǂݍ���
			base = Input.getDouble();
			height = Input.getDouble();
			if (isDataEnd(base, height)) {
				break;
			}

			if (isRightTriangleData(base, height) == false) {
				System.out.println("�O�p�`���ʐς������܂���");
				continue;
			}

			size = calculateTriangleSize(base, height);
			showTriangleSize(size);
		}
	}

	// �O�p�`�̖ʐς��v�Z����
	double calculateTriangleSize(double base, double height) {
		return base * height / 2;
	}

	// �O�p�`�̖ʐς�\������
	void showTriangleSize(double size) {
		System.out.println("�O�p�`�̖ʐς�" + size);
	}

	// �O�p�`�̏�񂪏I��肩�ǂ������ׂ�
	boolean isDataEnd(double base, double height) {
		return base == 0 && height == 0;
	}

	// �ǂݍ��񂾎O�p�`���ʐς��������ׂ�
	boolean isRightTriangleData(double base, double height) {
		return base >= 0 && height >= 0;
	}

}