/*
 * プログラム名: SizeOfTriangle3.java 三角形の面積を求めるプログラム（メソッド化）
 * 
 * author macchan
 * version 1.0
 */
public class SizeOfTriangle3 {

	public static void main(String[] args) {
		SizeOfTriangle3 sizeOfTriangle3 = new SizeOfTriangle3();
		sizeOfTriangle3.main();
	}

	void main() {
		// (複数の)三角形の面積を求める
		while (true) {
			double base;
			double height;
			double size;

			// 三角形の情報を読み込む
			base = Input.getDouble();
			height = Input.getDouble();
			if (isDataEnd(base, height)) {
				break;
			}

			if (isRightTriangleData(base, height) == false) {
				System.out.println("三角形が面積を持ちません");
				continue;
			}

			size = calculateTriangleSize(base, height);
			showTriangleSize(size);
		}
	}

	// 三角形の面積を計算する
	double calculateTriangleSize(double base, double height) {
		return base * height / 2;
	}

	// 三角形の面積を表示する
	void showTriangleSize(double size) {
		System.out.println("三角形の面積は" + size);
	}

	// 三角形の情報が終わりかどうか調べる
	boolean isDataEnd(double base, double height) {
		return base == 0 && height == 0;
	}

	// 読み込んだ三角形が面積を持つか調べる
	boolean isRightTriangleData(double base, double height) {
		return base >= 0 && height >= 0;
	}

}