import obpro.turtle.Turtle;

/**
 * 問題１－B：
 * 正十角形を書こうと思ったが，プログラムがとまらない．
 * なぜか考察して，プログラムを修正せよ
 */
public class DrawDecagonMissed extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new DrawDecagonMissed());
	}

	// タートルを動かす処理
	public void start() {
		double i = 0.1;
		while (true) {
			fd(20);
			rt(36);
			i = i + 0.1;
			if (i == 1.0) {
				break;
			}
		}
	}

}
