package trace_quiz.sp02;

import java.util.Scanner;

/**
 * @�v���O�������F 
 * @�쐬�F
 */
public class TraceQuizMethod01 {

	public static void main(String[] args) {
		TraceQuizMethod01 quiz = new TraceQuizMethod01();
		quiz.main();
	}

	Scanner scanner = new Scanner(System.in);

	// 
	void main() {
		// 
		int length;
		System.out.println("��������͂��ĉ�����");
		length = scanner.nextInt();// 4����͂������̂Ƃ���

		// 
		methodA(length);
	}

	// 
	void methodA(int length) {
		int i = 0;
		while (i < length) {
			if (i == 0) {// 
				methodB(length);
			} else if (i != 0 && i != length - 1) {// 
				methodC(length);
			} else if (i == length - 1) {// 
				methodB(length);
			}
			i++;
			System.out.println();
		}
	}

	// 
	void methodB(int length) {
		int i = 0;
		while (i < length) {
			System.out.print("��");
			i++;
		}
	}

	// 
	void methodC(int length) {
		int i = 0;
		while (i < length) {
			if (i == 0 || i == length - 1) {// 
				System.out.print("��");
			} else {// 
				System.out.print("��");
			}
			i++;
		}
	}
}