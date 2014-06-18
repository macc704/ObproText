/**
 * Example1.java
 * オブジェクトの動作を理解するためのサンプルプログラム（その１　インスタンス一つ）
 * 
 * @author macchan
 * @date 2005/06/15 オブプロ「継承」
 * @version 1.0
 */
public class Example1 {

	public static void main(String[] args) {
		Example1 example = new Example1();
		example.main();
	}

	private ClassA a;

	private void main() {
		//インスタンス生成＆初期化
		a = new ClassA();
		a.setX(1000);
		a.setY(1000);

		//出力
		System.out.print("a: ");
		a.display();
	}

}