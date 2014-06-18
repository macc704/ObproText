/*
 * プログラム名: SizeOfTriangle5.java 三角形の面積を求めるプログラム（クラスを使う）
 * 
 * author macchan
 * version 1.0
 */
public class SizeOfTriangle5 {

	public static void main(String[] args) {
		SizeOfTriangle5 sizeOfTriangle5 = new SizeOfTriangle5();
		sizeOfTriangle5.main();
	}

	void main() {
		// (複数の)三角形の面積を求める
		while (true) {
			TriangleData triangleData;
			double size;

			triangleData = inputTriangleData();
			if (isDataEnd(triangleData)) {
				break;
			}
			if (isRightTriangleData(triangleData) == false) {
				System.out.println("三角形が面積を持ちません");
				continue;
			}
			size = calculateTriangleSize(triangleData);
			showTriangleSize(size);
		}
	}

	// 三角形の情報を読み込む
	TriangleData inputTriangleData() {
		TriangleData triangleData = new TriangleData();
		triangleData.base = Input.getDouble();// 底辺を読み込む
		triangleData.height = Input.getDouble();// 高さを読み込む
		return triangleData;
	}

	// 三角形の面積を計算する
	double calculateTriangleSize(TriangleData triangleData) {
		return triangleData.base * triangleData.height / 2;
	}

	// 三角形の面積を表示する
	void showTriangleSize(double size) {
		System.out.println("三角形の面積は" + size);
	}

	// 三角形の情報が終わりかどうか調べる
	boolean isDataEnd(TriangleData triangleData) {
		return triangleData.base == 0 && triangleData.height == 0;
	}

	// 読み込んだ三角形が面積を持つか調べる
	boolean isRightTriangleData(TriangleData triangleData) {
		return triangleData.base >= 0 && triangleData.height >= 0;
	}

}

// 「三角形の情報」クラス
class TriangleData {
	double base;
	double height;
}