import obpro.turtle.Turtle;

/**
 * 問題１－A：
 * 四角形を書こうと思ったが，プログラムがとまらない．
 * なぜか考察して，プログラムを修正せよ
 */
public class DrawRectangleMissed extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new DrawRectangleMissed());
	}

	// タートルを動かす処理
	public void start() {
		int i = 0;
		while (i < 4) {
			fd(100);
			rt(90);
			i = i++;
		}
	}

}
