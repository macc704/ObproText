package trace_quiz.sp03;

import obpro.cui.Input;

/**
 * プログラム名： 
 * 作成者： 
 * バージョン： 1.0 () 
 */

public class FactorialCalculator {

	public static void main(String[] args) {
		FactorialCalculator factorialCalculator = new FactorialCalculator();
		factorialCalculator.main();
	}

	// 
	void main() {
		// 
		int number;
		System.out.println("階乗の計算をします．整数を入力して下さい>>");
		number = Input.getInt();
		
		// 
		int answer;
		answer = factorial(number);
		
		// 
		System.out.println("Factorial=" + answer);
	}

	// 
	int factorial(int n) {
		if(n == 1) {
			return 1;
		} else {
			return (n * factorial(n - 1));
		}
	}
}
