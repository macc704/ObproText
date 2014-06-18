package trace_quiz.makeup;

/*
 * 2011年度オブプロ追試問題
 * 
 * トレースは17行目のmain()から始めること。
 * @version 2011.07.30
 * @author okadaken
 */
public class Tsuishi01 {

	public static void main(String[] args) {
		Tsuishi01 tsuishi = new Tsuishi01();
		tsuishi.main();
	}

	void main() {
		int n = 3;
		int a = 0;
		int b = 0;

		for (int i = 0; i < n; i++) {
			a = i + 1;
			b = n - a;

			method01(a, b);
		}
	}

	private void method01(int a, int b) {
		for (int i = 0; i < b; i++) {
			System.out.print("␣␣");
		}

		for (int i = 0; i < a; i++) {
			System.out.print("ＳＦＣ");
			System.out.print("␣");
		}

		System.out.println();
	}
}
