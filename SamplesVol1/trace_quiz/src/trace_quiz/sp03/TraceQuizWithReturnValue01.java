package trace_quiz.sp03;

public class TraceQuizWithReturnValue01 {

	public static void main(String[] args) {
		TraceQuizWithReturnValue01 quiz = new TraceQuizWithReturnValue01();
		quiz.main();
	}

	// 2‚Â‚Ì¤•i‚Ì¿‹‹àŠz‚ğo—Í‚·‚é
	void main() {
		int kakaku1 = 120;// yen
		int kakaku2 = 130;// yen

		int totalWithTax = totalWithTax(kakaku1, kakaku2);

		System.out.println(totalWithTax + "iÅj‰~‚É‚È‚è‚Ü‚·");
	}

	// Å‚İ‡Œv‹àŠz‚ğŒvZ‚·‚é
	int totalWithTax(int kakaku1, int kakaku2) {
		int total = total(kakaku1, kakaku2);
		total = total + tax(total, 0.05);
		return total;
	}

	// ‡Œv‹àŠz‚ğŒvZ‚·‚é
	int total(int kakaku1, int kakaku2) {
		int total = kakaku1 + kakaku2;
		return total;
	}

	// ÅŠz‚ğŒvZ‚·‚é
	int tax(int total, double taxRate) {
		return (int) (total * taxRate);
	}

}
