package trace_quiz.sp03;

public class TraceQuizWithReturnValue01 {

	public static void main(String[] args) {
		TraceQuizWithReturnValue01 quiz = new TraceQuizWithReturnValue01();
		quiz.main();
	}

	// 2つの商品の請求金額を出力する
	void main() {
		int kakaku1 = 120;// yen
		int kakaku2 = 130;// yen

		int totalWithTax = totalWithTax(kakaku1, kakaku2);

		System.out.println(totalWithTax + "（税込）円になります");
	}

	// 税込み合計金額を計算する
	int totalWithTax(int kakaku1, int kakaku2) {
		int total = total(kakaku1, kakaku2);
		total = total + tax(total, 0.05);
		return total;
	}

	// 合計金額を計算する
	int total(int kakaku1, int kakaku2) {
		int total = kakaku1 + kakaku2;
		return total;
	}

	// 税額を計算する
	int tax(int total, double taxRate) {
		return (int) (total * taxRate);
	}

}
