/**
 * Point.java
 * オブジェクト指向（クラス/インスタンス)の動作を理解するためのサンプルプログラム
 * 
 * @author macchan
 * @date 2005/06/02 オブプロ第７回
 * @version 1.0
 */
public class Point {

	int x;
	int y;

	/**
	 * xを設定する
	 */
	void setX(int x) {
		this.x = x;
	}

	/**
	 * xを増やす
	 */
	void addX(int x) {
		this.x = this.x + x;
	}

}