/**
 * �v���O�������F �X�^�b�N�I�[�o�[�t���[�̃e�X�g
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/06/13) 
 */
public class StackOverFlowTest {

	public static void main(String[] args) {
		StackOverFlowTest stackOverFlowTest = new StackOverFlowTest();
		stackOverFlowTest.main();
	}

	private void main() {
		method(1);
	}

	void method(int x) {
		System.out.println(++x);
		method(x);
	}

}
