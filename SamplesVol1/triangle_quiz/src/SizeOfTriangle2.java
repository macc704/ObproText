/*
 * プログラム名: SizeOfTriangle2.java 三角形の面積を求めるプログラム（レビュー後）
 * 
 * author macchan
 * version 1.0
 */
public class SizeOfTriangle2 {

	public static void main(String[] args) {
		SizeOfTriangle2 sizeOfTriangle2 = new SizeOfTriangle2();
		sizeOfTriangle2.main();
	}

	void main() {
		// (複数の)三角形の面積を求める
		while (true) {
			double base;
			double height;
			double size;

			// 三角形の情報を読み込む
			base = Input.getDouble();// 底辺を読み込む
			height = Input.getDouble();// 高さを読み込む
			if (base == 0 && height == 0) {// 三角形の情報が終わり
				break;
			}

			// 読み込んだ三角形が面積を持つか調べる
			if (base < 0 || height < 0) {// 読み込んだ三角形が面積を持たない場合
				System.out.println("三角形が面積を持ちません");// エラーメッセージを表示する
				continue;
			}

			// 三角形の面積を計算する
			size = base * height / 2;

			// 三角形の面積を表示する
			System.out.println("三角形の面積は" + size);
		}
	}

}