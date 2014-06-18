import obpro.turtle.Turtle;

/*
 * プログラム名:例題１ 家を書くプログラム
 * House.java
 * 
 * @author Yoshiaki Matsuzawa 
 * @date 2007/04/19
 */
public class House extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new House());
	}

	// 家を書く
	public void start() {
		// 屋根を書く
		{
			// 前処理
			rt(30);

			// 屋根を書く（本体）
			for (int i = 0; i < 3; i++) {
				fd(50);
				rt(120);
			}

			// 後処理
			lt(30);
		}

		// かべを書く
		for (int i = 0; i < 4; i++) {
			rt(90);
			fd(50);
		}

	}

}