package trace_quiz.sp03;

public class TraceQuizWithReturnValue01 {

	public static void main(String[] args) {
		TraceQuizWithReturnValue01 quiz = new TraceQuizWithReturnValue01();
		quiz.main();
	}

	// 2�̏��i�̐������z���o�͂���
	void main() {
		int kakaku1 = 120;// yen
		int kakaku2 = 130;// yen

		int totalWithTax = totalWithTax(kakaku1, kakaku2);

		System.out.println(totalWithTax + "�i�ō��j�~�ɂȂ�܂�");
	}

	// �ō��ݍ��v���z���v�Z����
	int totalWithTax(int kakaku1, int kakaku2) {
		int total = total(kakaku1, kakaku2);
		total = total + tax(total, 0.05);
		return total;
	}

	// ���v���z���v�Z����
	int total(int kakaku1, int kakaku2) {
		int total = kakaku1 + kakaku2;
		return total;
	}

	// �Ŋz���v�Z����
	int tax(int total, double taxRate) {
		return (int) (total * taxRate);
	}

}
