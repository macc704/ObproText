import java.util.ArrayList;

/**
 * �v���O�������F �q�[�v�I�[�o�[�t���[�̃e�X�g
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/06/13) 
 */
public class HeapOverFlowTest {

	public static void main(String[] args) {
		HeapOverFlowTest heapOverFlowTest = new HeapOverFlowTest();
		heapOverFlowTest.main();
	}

	private void main() {
		ArrayList<Test> list = new ArrayList<Test>();
		for (int i = 0; i < 100000000000000L; i++) {
			System.out.println(i);
			list.add(new Test());
		}
	}
}

class Test {
	int x = 0;
}
