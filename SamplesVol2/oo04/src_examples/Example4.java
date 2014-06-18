/**
 * オブプロ第10回例題　(ポリモーフィズム 4　ダウンキャスト)
 * 
 * @author macchan
 * @version 1.0
 */
public class Example4 {

	public static void main(String[] args) {
		Example4 example = new Example4();
		example.main();
	}

	void main() {
		A a = new B();
		B b = (B) a;

		a.display();
		b.display();
		b.display2();
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

/**********************************************
問題：このプログラムをコンパイルして実行するとどうなるか

(A)
A#display()
B#display()
B#display2()

(B)
B#display()
B#display()
B#display2()

(C)
コンパイルエラー

***********************************************/
