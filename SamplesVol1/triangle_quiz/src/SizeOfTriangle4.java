/*
 * プログラム名: SizeOfTriangle4.java 三角形の面積を求めるプログラム
 *          （グローバル変数を利用して，強引にメソッド化．あまりよいプログラムではない）
 * 
 * author macchan
 * version 1.0
 */
public class SizeOfTriangle4 {

	public static void main(String[] args) {
		SizeOfTriangle4 sizeOfTriangle4 = new SizeOfTriangle4();
		sizeOfTriangle4.main();
	}

	double base;// グローバル
	double height;// グローバル

	void main() {
		// (複数の)三角形の面積を求める
		while (true) {
			double size;

			inputTriangleData();
			if (isDataEnd() == true) {
				break;
			}

			if (isRightTriangleData() == false) {
				System.out.println("三角形が面積を持ちません");
				continue;
			}

			size = calculateTriangleSize();
			showTriangleSize(size);
		}
	}

	// 三角形の情報を読み込む
	void inputTriangleData() {
		base = Input.getDouble();// 底辺を読み込む
		height = Input.getDouble();// 高さを読み込む
	}

	// 三角形の面積を計算する
	double calculateTriangleSize() {
		return base * height / 2;
	}

	// 三角形の面積を表示する
	void showTriangleSize(double size) {
		System.out.println("三角形の面積は" + size);
	}

	// 三角形の情報が終わりかどうか調べる
	boolean isDataEnd() {
		return base == 0 && height == 0;
	}

	// 読み込んだ三角形が面積を持つか調べる
	boolean isRightTriangleData() {
		return base >= 0 && height >= 0;
	}

}