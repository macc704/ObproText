/**
 * オブプロ第10回例題　(ポリモーフィズム2 配列)
 * 
 * @author macchan
 * @version 1.0
 */
public class Example2 {

	public static void main(String[] args) {
		Example2 example = new Example2();
		example.main();
	}

	void main() {
		A[] aList = new A[5];
		aList[0] = new B();
		aList[1] = new A();
		aList[2] = new C();
		aList[3] = new B();
		aList[4] = new C();

		for (int i = 0; i < aList.length; i++) {
			aList[i].display();
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
A#display()
A#display()

(B)
B#display()
A#display()
C#display()
B#display()
C#display()

(C)
コンパイルエラー

***********************************************/
