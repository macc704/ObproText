/**
 * OOTraceSample.java オブジェクト指向（クラス/インスタンス)の動作を理解するためのサンプルプログラム
 * 
 * @author macchan
 * @date 2005/06/02 オブプロ第７回
 * @version 1.0
 */
public class OOTraceSample {

	public static void main(String[] args) {
		OOTraceSample sample = new OOTraceSample();
		sample.main();
	}

	@SuppressWarnings("null")
	void main() {
		Point p1;
		Point p2;
		Point p3 = null;

		p1 = new Point();
		p1.x = 100;
		p1.y = 100;

		p2 = new Point();
		p2.x = 200;
		p2.y = 200;

		System.out.println("p1.x=" + p1.x + ", p1.y=" + p1.y);
		System.out.println("p2.x=" + p2.x + ", p2.y=" + p2.y);

		p1.addX(50);
		p2.setX(50);

		System.out.println("p1.x=" + p1.x + ", p1.y=" + p1.y);
		System.out.println("p2.x=" + p2.x + ", p2.y=" + p2.y);

		p1 = p2;

		p1.x = 800;

		System.out.println("p1.x=" + p1.x + ", p1.y=" + p1.y);
		System.out.println("p2.x=" + p2.x + ", p2.y=" + p2.y);

		p3.x = 100;
	}

}