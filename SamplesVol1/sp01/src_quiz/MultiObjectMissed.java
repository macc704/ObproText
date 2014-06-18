import obpro.turtle.Turtle;


/*
 * 問題２：
 * 以下のように書いたら，意図どおり動かなかった．
 * １）フローチャートを描け（1枚に入りきるように，詳細を省略してよい）
 * ２）何故動かないか，仮説をたてよ
 * ３）仮説が正しいかどうか，デバッガで検証せよ
 * 結果を200字程度にまとめよ．
 * 
 * MultiObjectMissed.java
 * 図形を（三角形，四角形交互に）4つ書くプログラム(のつもり)
 * 2007/04/19
 * Yoshiaki Matsuzawa
 */
public class MultiObjectMissed extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new MultiObjectMissed());
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
					i = 0;
					while (i < 3) {
						fd(50);
						rt(120);
						i++;
					}

					// 後処理
					lt(30);
				}
			} else {
				// 四角形を書く
				i = 0;
				while (i < 4) {
					fd(50);
					rt(90);
					i++;
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