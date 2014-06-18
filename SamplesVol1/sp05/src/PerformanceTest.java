import obpro.common.BStopWatch;

/*
 * プログラム名： ストップウオッチのテストプログラム
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/24) 
 */
public class PerformanceTest {

	public static void main(String[] args) {
		PerformanceTest performanceTest = new PerformanceTest();
		performanceTest.main();
	}

	private void main() {
		BStopWatch sw = new BStopWatch();
		sw.start();
		int x = 0;
		for (int i = 0; i < 100000000; i++) {
			x = x + i / 100;
		}
		sw.stop();
		System.out.println("かかった時間は" + sw.getTimeByMiliseconds() + "ミリ秒です．");
	}

}
