/**
 * ClassA.java
 * オブジェクトの動作を理解するためのサンプルプログラム(その１～その３）
 * 
 * @author macchan
 * @date 2005/06/02 オブプロ「継承」
 * @version 1.0
 */
public class ClassA {

	private int x = 100;
	private int y = 200;

	/**
	 * xを取得する
	 */
	public int getX() {
		return x;
	}

	/**
	 * xを設定する
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * yを取得する
	 */
	public int getY() {
		return y;
	}

	/**
	 * yを設定する
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 表示を行う	 
	 */
	public void display() {
		System.out.println("x=" + getX() + ", y=" + getY());
	}

}