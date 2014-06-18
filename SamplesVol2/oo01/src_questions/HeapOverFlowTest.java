import java.util.ArrayList;

/**
 * プログラム名： ヒープオーバーフローのテスト
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/06/13) 
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
