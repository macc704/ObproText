/*
 * プログラム名: SizeOfTriangle1.java 三角形の面積を求めるプログラム（レビュー前）
 * 
 * author macchan
 * version 1.0
 */
public class SizeOfTriangle1 {

	public static void main(String[] args) {
		SizeOfTriangle1 sizeOfTriangle1 = new SizeOfTriangle1();
		sizeOfTriangle1.main();
	}

	void main() {
		int base;
		int height;
		int size;

		// 底辺と高さを読み込む
		base = input();
		height = input();

		// データが存在する
		while (base == 0 && height == 0) {
			// 底辺・高さが共に0より大きい数字である
			if (base > 0 && height > 0) {
				size = base * height / 2;// 三角形の面積を計算する
				print("三角形の面積は" + size);// 三角形の面積を表示する
			} else {
				print("エラーです");// エラーメッセージを表示する
			}

			// 底辺と高さを読み込む
			base = input();
			height = input();
		}
	}

	// （整数の）入力を受け取る（未実装）
	int input() {
		return 0;
	}

	// プリントする（未実装）
	void print(String s) {
	}
}