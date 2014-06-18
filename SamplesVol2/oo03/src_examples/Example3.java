/**
 * Example3.java
 * オブジェクトの動作を理解するためのサンプルプログラム（その３　継承）
 * 
 * @author macchan
 * @date 2005/06/15 オブプロ「継承」
 * @version 1.0
 */
public class Example3 {

	public static void main(String[] args) {
		Example3 example = new Example3();
		example.main();
	}

	private ClassA a;
	private ClassB b;
	private ClassC c;
	private ClassD d;

	private void main() {
		//インスタンス生成
		a = new ClassA();
		b = new ClassB();
		c = new ClassC(100);
		d = new ClassD(100);

		//値設定
		a.setX(1000);
		a.setY(1000);
		b.setX(2000);
		b.setY(2000);
		b.setW(2000);
		b.setH(2000);
		c.setX(3000);
		c.setY(3000);
		d.setX(4000);
		d.setY(4000);
		d.addZ(50);

		//出力
		System.out.print("a: ");
		a.display();
		System.out.print("b: ");
		b.display();
		System.out.print("c: ");
		c.display();
		System.out.print("d: ");
		d.display();
	}
}