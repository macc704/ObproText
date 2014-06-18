/**
 * プログラム名： スタックオーバーフローのテスト
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/06/13) 
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
