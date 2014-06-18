/**
 * 問題１－C：
 * 四捨五入するメソッドを作り，テストを作った．
 * 出力は以下のようになるはずだったが，そうならない．（実行してみよ）
 * なぜか考察して，プログラムを修正せよ
 * （ヒント：2つの問題が複合しています．）
 * 
 少数第0位まで四捨五入した結果：6.0
 少数第1位まで四捨五入した結果：5.8
 少数第2位まで四捨五入した結果：5.78
 少数第3位まで四捨五入した結果：5.785
 少数第4位まで四捨五入した結果：5.7846
 少数第5位まで四捨五入した結果：5.78463
 少数第6位まで四捨五入した結果：5.784626
 少数第7位まで四捨五入した結果：5.7846261
 少数第8位まで四捨五入した結果：5.78462611
 少数第9位まで四捨五入した結果：5.784626109
 少数第10位まで四捨五入した結果：5.7846261093
 少数第11位まで四捨五入した結果：5.78462610928
 少数第12位まで四捨五入した結果：5.784626109284
 少数第13位まで四捨五入した結果：5.7846261092837
 少数第14位まで四捨五入した結果：5.78462610928375
 */
public class RoundOffNumbersMissed {

	public static void main(String[] args) {
		RoundOffNumbersMissed roundOffNumbersMissed = new RoundOffNumbersMissed();
		roundOffNumbersMissed.main();
	}

	//四捨五入する関数のテストプログラム
	void main() {
		double number = 5.784626109283749;//適当な値

		//少数第n位まで四捨五入した値を15位まで表示する
		for (int i = 0; i < 15; i++) {
			System.out.println("少数第" + i + "位まで四捨五入した結果：" + round(number, i));
		}
	}

	//少数第n+1位を四捨五入し，少数第n位までの値を求める
	double round(double value, int n) {
		int multiplier = (int) Math.pow(10, n); //リクエストされた桁に応じて，１０の乗数を求める
		double multiplied = value * multiplier; //乗数をかける
		int rounded = (int) (multiplied + 0.5); //少数第１位で四捨五入する
		double newValue = (double) (rounded / multiplier);//乗数で割って数を戻す
		return newValue;
	}
}
