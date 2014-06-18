/*
 * �v���O������: SizeOfTriangle4.java �O�p�`�̖ʐς����߂�v���O����
 *          �i�O���[�o���ϐ��𗘗p���āC�����Ƀ��\�b�h���D���܂�悢�v���O�����ł͂Ȃ��j
 * 
 * author macchan
 * version 1.0
 */
public class SizeOfTriangle4 {

	public static void main(String[] args) {
		SizeOfTriangle4 sizeOfTriangle4 = new SizeOfTriangle4();
		sizeOfTriangle4.main();
	}

	double base;// �O���[�o��
	double height;// �O���[�o��

	void main() {
		// (������)�O�p�`�̖ʐς����߂�
		while (true) {
			double size;

			inputTriangleData();
			if (isDataEnd() == true) {
				break;
			}

			if (isRightTriangleData() == false) {
				System.out.println("�O�p�`���ʐς������܂���");
				continue;
			}

			size = calculateTriangleSize();
			showTriangleSize(size);
		}
	}

	// �O�p�`�̏���ǂݍ���
	void inputTriangleData() {
		base = Input.getDouble();// ��ӂ�ǂݍ���
		height = Input.getDouble();// ������ǂݍ���
	}

	// �O�p�`�̖ʐς��v�Z����
	double calculateTriangleSize() {
		return base * height / 2;
	}

	// �O�p�`�̖ʐς�\������
	void showTriangleSize(double size) {
		System.out.println("�O�p�`�̖ʐς�" + size);
	}

	// �O�p�`�̏�񂪏I��肩�ǂ������ׂ�
	boolean isDataEnd() {
		return base == 0 && height == 0;
	}

	// �ǂݍ��񂾎O�p�`���ʐς��������ׂ�
	boolean isRightTriangleData() {
		return base >= 0 && height >= 0;
	}

}