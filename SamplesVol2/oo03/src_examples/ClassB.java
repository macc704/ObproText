/**
 * ClassB.java
 * オブジェクトの動作を理解するためのサンプルプログラム(その３）
 * 
 * @author macchan
 * @date 2005/06/02 オブプロ「継承」
 * @version 1.0
 */
public class ClassB extends ClassA {

	private int w = 300;
	private int h = 400;

	/**
	 * wを取得する
	 */
	public int getW() {
		return w;
	}

	/**
	 * wを設定する
	 */
	public void setW(int w) {
		this.w = w;
	}

	/**
	 * hを取得する
	 */
	public int getH() {
		return h;
	}

	/**
	 * hを設定する
	 */
	public void setH(int h) {
		this.h = h;
	}

	/**
	 * 表示を行う(オーバーライドによる再定義）	 
	 */
	public void display() {
		System.out.println("x=" + getX() + ", y=" + getY() + ", w=" + getW()
				+ ", h=" + getH());
	}

}