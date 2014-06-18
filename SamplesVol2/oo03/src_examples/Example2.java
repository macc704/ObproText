import java.util.ArrayList;

/**
 * Example2.java
 * オブジェクトの動作を理解するためのサンプルプログラム（その２　複数のインスタンス）
 * 
 * @author macchan
 * @date 2005/06/15 オブプロ「継承」
 * @date 2007/06/27 camei 配列をコレクション(ArrayList)で書き直す
 * @version 2.0
 */
public class Example2 {

	public static void main(String[] args) {
		Example2 example = new Example2();
		example.main();
	}

	private ArrayList<ClassA> aInstances;

	private void main() {

		// リスト生成
		aInstances = new ArrayList<ClassA>();

		//インスタンス生成＆初期化
		initialize(aInstances);

		//出力
		display(aInstances);
	}

	private void initialize(ArrayList<ClassA> targets) {
		for (int i = 0; i < 3; i++) {
			ClassA a = new ClassA();
			a.setX(100 * i);
			a.setY(100 * i);
			targets.add(a);
		}
	}

	private void display(ArrayList<ClassA> targets) {
		// ArrayList の全要素に順次アクセスするのは以下のようにも書ける
		for (int i = 0; i < targets.size(); i++) {
			ClassA a = targets.get(i);// targetsのi番目の要素を取得
			System.out.print("targets [" + i + "]: ");
			a.display();
		}
	}
}