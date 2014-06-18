package trace_quiz.sp03;

import obpro.cui.Input;

/**
 * ƒvƒƒOƒ‰ƒ€–¼F FactorialCalculator ŠKæ‚ğŒvZ‚·‚éƒvƒƒOƒ‰ƒ€
 * ì¬ÒF Rintal Takeda
 * ƒo[ƒWƒ‡ƒ“F 1.0 (2005/5/11) 
 */

public class FactorialCalculatorAnswer {

	public static void main(String[] args) {
		FactorialCalculatorAnswer factorialCalculatorAnswer = new FactorialCalculatorAnswer();
		factorialCalculatorAnswer.main();
	}

	// ŠKæ‚ğŒvZ‚·‚é
	void main() {
		// ®”‚ğ“ü—Í‚·‚é
		int number;
		System.out.println("ŠKæ‚ÌŒvZ‚ğ‚µ‚Ü‚·D®”‚ğ“ü—Í‚µ‚Ä‰º‚³‚¢>>");
		number = Input.getInt();
		
		// ŠKæ‚ğŒvZ‚·‚é
		int answer;
		answer = factorial(number);
		
		// ŒvZŒ‹‰Ê‚ğo—Í‚·‚é
		System.out.println("Factorial=" + answer);
	}

	// ŠKæ‚ğŒvZ‚·‚é
	int factorial(int n) {
		if(n == 1) {
			return 1;
		} else {
			return (n * factorial(n - 1));
		}
	}
}
