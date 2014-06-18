/**
 * �v���O�������F �������r�̃T���v��(�G���[�t��)
 * �쐬�ҁF Yoshiaki Matsuzawa
 * �o�[�W�����F 1.0 (2007/05/24) 
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
