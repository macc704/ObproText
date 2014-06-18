import obpro.turtle.Turtle;

/*
 * プログラム名： 今まで作ったものをオブジェクトとして使う
 * 作成者： Yoshiaki Matsuzawa
 * バージョン： 1.0 (2007/05/17)
 */
public class DrawObject extends Turtle {

	// 起動処理
	public static void main(String[] args) {
		Turtle.startTurtle(new DrawObject());
	}

	// タートルを動かす処理
	public void start() {
		hide();

		// 家を表示する
		House myHouse = new House();// House.javaを同じフォルダにおくこと
		myHouse.fd(5);// タートルと同じ命令＋αが使える
		update();// 今までと違って，更新命令をしないと，画面は更新されない
	}

}
