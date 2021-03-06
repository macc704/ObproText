package trace_quiz.sp03;

import obpro.cui.Input;

/**
 * プログラム名： FactorialCalculator 階乗を計算するプログラム
 * 作成者： Rintal Takeda
 * バージョン： 1.0 (2005/5/11) 
 */

public class FactorialCalculatorAnswer {

	public static void main(String[] args) {
		FactorialCalculatorAnswer factorialCalculatorAnswer = new FactorialCalculatorAnswer();
		factorialCalculatorAnswer.main();
	}

	// 階乗を計算する
	void main() {
		// 整数を入力する
		int number;
		System.out.println("階乗の計算をします．整数を入力して下さい>>");
		number = Input.getInt();
		
		// 階乗を計算する
		int answer;
		answer = factorial(number);
		
		// 計算結果を出力する
		System.out.println("Factorial=" + answer);
	}

	// 階乗を計算する
	int factorial(int n) {
		if(n == 1) {
			return 1;
		} else {
			return (n * factorial(n - 1));
		}
	}
}
