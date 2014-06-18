package trace_quiz.sp02;

import java.util.Scanner;

/**
 * @プログラム名： 指定された長さの四角形をコンソールに出力するプログラム
 * @作成：むらかみきほ (2008/5/22)
 * @修正：macchan (2008/5/23)
 */
public class TraceQuizMethod01Answer {

	public static void main(String[] args) {
		TraceQuizMethod01Answer quiz = new TraceQuizMethod01Answer();
		quiz.main();
	}

	Scanner scanner = new Scanner(System.in);

	// 指定された長さの四角形をコンソールに出力する
	void main() {
		// 長さを取得する
		int length;
		System.out.println("長さを入力して下さい");
		length = scanner.nextInt();// 4を入力したものとする

		// 四角形を描く
		methodA(length);
	}

	// 四角形を描く
	void methodA(int length) {
		int i = 0;
		while (i < length) {
			if (i == 0) {// 上辺
				methodB(length);
			} else if (i != 0 && i != length - 1) {// 上下辺以外の段（中段）
				methodC(length);
			} else if (i == length - 1) {// 下辺
				methodB(length);
			}
			i++;
			System.out.println();
		}
	}

	// 上辺，または下辺を描く
	void methodB(int length) {
		int i = 0;
		while (i < length) {
			System.out.print("■");
			i++;
		}
	}

	// 上下辺以外の段（中段）を描く
	void methodC(int length) {
		int i = 0;
		while (i < length) {
			if (i == 0 || i == length - 1) {// 左辺・右辺
				System.out.print("■");
			} else {// 左辺・右辺以外を空洞で埋める
				System.out.print("□");
			}
			i++;
		}
	}
}