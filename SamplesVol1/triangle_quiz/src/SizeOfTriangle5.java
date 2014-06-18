/*
 * �v���O������: SizeOfTriangle5.java �O�p�`�̖ʐς����߂�v���O�����i�N���X���g���j
 * 
 * author macchan
 * version 1.0
 */
public class SizeOfTriangle5 {

	public static void main(String[] args) {
		SizeOfTriangle5 sizeOfTriangle5 = new SizeOfTriangle5();
		sizeOfTriangle5.main();
	}

	void main() {
		// (������)�O�p�`�̖ʐς����߂�
		while (true) {
			TriangleData triangleData;
			double size;

			triangleData = inputTriangleData();
			if (isDataEnd(triangleData)) {
				break;
			}
			if (isRightTriangleData(triangleData) == false) {
				System.out.println("�O�p�`���ʐς������܂���");
				continue;
			}
			size = calculateTriangleSize(triangleData);
			showTriangleSize(size);
		}
	}

	// �O�p�`�̏���ǂݍ���
	TriangleData inputTriangleData() {
		TriangleData triangleData = new TriangleData();
		triangleData.base = Input.getDouble();// ��ӂ�ǂݍ���
		triangleData.height = Input.getDouble();// ������ǂݍ���
		return triangleData;
	}

	// �O�p�`�̖ʐς��v�Z����
	double calculateTriangleSize(TriangleData triangleData) {
		return triangleData.base * triangleData.height / 2;
	}

	// �O�p�`�̖ʐς�\������
	void showTriangleSize(double size) {
		System.out.println("�O�p�`�̖ʐς�" + size);
	}

	// �O�p�`�̏�񂪏I��肩�ǂ������ׂ�
	boolean isDataEnd(TriangleData triangleData) {
		return triangleData.base == 0 && triangleData.height == 0;
	}

	// �ǂݍ��񂾎O�p�`���ʐς��������ׂ�
	boolean isRightTriangleData(TriangleData triangleData) {
		return triangleData.base >= 0 && triangleData.height >= 0;
	}

}

// �u�O�p�`�̏��v�N���X
class TriangleData {
	double base;
	double height;
}