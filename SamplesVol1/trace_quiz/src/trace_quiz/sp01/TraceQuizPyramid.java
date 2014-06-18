package trace_quiz.sp01;

public class TraceQuizPyramid {

	public static void main(String[] args) {
		TraceQuizPyramid quiz = new TraceQuizPyramid();
		quiz.main();
	}

	//
	void main() {
		int n = 5;

		//
		for (int i = 0; i < n; i++) {
			int count = i + 1;
			int spaceCount = n - count;

			//
			for (int j = 0; j < spaceCount; j++) {
				System.out.print("  ");
			}

			//
			for (int j = 0; j < count; j++) {
				System.out.print("SFC");
				System.out.print(" ");
			}

			//
			System.out.println();
		}
	}

}
