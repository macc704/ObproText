/**
 * プログラム名： 文字列比較のサンプル(エラー付き)
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/24) 
 */
public class StringTestWithError {

	public static void main(String[] args) {
		StringTestWithError stringTest = new StringTestWithError();
		stringTest.main();
	}

	private void main() {
		String a = "hoge";
		String b = "hoge";
		String c = b;
		String d = new String("hoge");

		System.out.println("a == b : " + a == b);
		System.out.println("a.equals(b) : " + a.equals(b));

		System.out.println("b == c : " + b == c);
		System.out.println("b.equals(c) : " + b.equals(c));

		System.out.println("c == d : " + c == d);
		System.out.println("c.equals(d) : " + c.equals(d));
	}

}
