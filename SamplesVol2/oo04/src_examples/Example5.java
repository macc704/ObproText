/**
 * オブプロ第10回例題　(ポリモーフィズム5 instanceof演算子)
 * 
 * @author macchan
 * @version 1.0
 */
public class Example5 {

	public static void main(String[] args) {
		Example5 example = new Example5();
		example.main();
	}

	void main() {
		A[] aList = new A[3];
		aList[0] = new B();
		aList[1] = new A();
		aList[2] = new C();

		for (int i = 0; i < aList.length; i++) {
			System.out.println("aList[" + i + "] instanceof A = "
					+ (aList[i] instanceof A));
			System.out.println("aList[" + i + "] instanceof B = "
					+ (aList[i] instanceof B));
			System.out.println("aList[" + i + "] instanceof C = "
					+ (aList[i] instanceof C));
		}

		for (int i = 0; i < aList.length; i++) {
			if (aList[i] instanceof B) {
				B b = (B) aList[i];
				b.display2();
			}
		}
	}
	class A {
		public void display() {
			System.out.println("A#display()");
		}
	}

	class B extends A {
		public void display() {
			System.out.println("B#display()");
		}
		public void display2() {
			System.out.println("B#display2()");
		}
	}

	class C extends A {
		public void display() {
			System.out.println("C#display()");
		}
	}

}

/******************************************************
 問題：このプログラムをコンパイルして実行するとどのような出力になるか記述せよ．
 instanceof 演算子はそのクラスのインスタンスかどうかを真偽値を求める
 (結果はtrue もしくは false となる)
 *******************************************************/

