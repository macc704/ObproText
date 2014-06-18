import obpro.turtle.Turtle;

/*
 * プログラム名：例題３  図形を（三角形，四角形交互に）4つ書くプログラム
 * MultiObject.java
 * 
 * @author Yoshiaki Matsuzawa 
 * @date 2007/04/19
 */
public class MultiObject extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new MultiObject());
	}

	public void start() {

		// 前処理
		window.size(600, 200);

		// 図形を（三角形，四角形交互に）4つ書く
		int i = 0;
		while (i < 4) {

			// 図形を書く
			if (i % 2 == 0) {
				// 三角形を書く
				{
					// 前処理
					rt(30);

					// 三角形を書く本処理
					int j = 0;
					while (j < 3) {
						fd(50);
						rt(120);
						j++;
					}

					// 後処理
					lt(30);
				}
			} else {
				// 四角形を書く
				int j = 0;
				while (j < 4) {
					fd(50);
					rt(90);
					j++;
				}
			}

			// 次の位置に移動する
			{
				// 前処理
				up();

				// 移動する本処理
				rt(90);
				fd(100);
				lt(90);

				// 後処理
				down();
			}

			// 後処理
			i++;
		}
	}
}