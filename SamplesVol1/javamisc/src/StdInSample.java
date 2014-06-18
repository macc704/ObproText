import java.util.Scanner;

/*
 * プログラム名: Javaによる標準入出力
 * @author Yoshiaki Matsuzawa 
 * @date 2010/04/09
 */
public class StdInSample {

	public static void main(String[] args) {
		StdInSample stdInSample = new StdInSample();
		stdInSample.main();
	}

	Scanner input = new Scanner(System.in);// 標準入力を解析するスキャナ（入力を行うために必要）

	void main() {
		// 文字列の入力
		System.out.print("何か文字を入力してね>");
		System.out.flush();
		String s1 = input.next();// 標準入力：次の行を読み込む（読み込むまでブロック）
		System.out.println("入力された文字は" + s1 + "です．");// (Java式)

		// 数値の入力
		System.out.print("何か数字を入力してね>");
		System.out.flush();
		int i1 = input.nextInt();// 次の行を読み込み，整数に変換（変換できなければ例外）
		System.out.println("入力された数字は" + i1 + "です．");// (Java式)
	}

}