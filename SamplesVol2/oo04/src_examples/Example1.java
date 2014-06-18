/**
 * オブプロ第10回例題　(ポリモーフィズム1)
 * 
 * @author macchan
 * @version 1.0
 */
public class Example1 {

	public static void main(String[] args) {
		Example1 example = new Example1();
		example.main();
	}

	void main() {
		A a1 = new A();
		a1.display();

		A a2 = new B();
		a2.display();

		A a3 = new C();
		a3.display();
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
A#display()
A#display()

(B)
A#display()
B#display()
C#display()
  
(C)
コンパイルエラー

***********************************************/