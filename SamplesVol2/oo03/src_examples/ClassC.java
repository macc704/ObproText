/**
 * ClassC.java
 * オブジェクトの動作を理解するためのサンプルプログラム(その３）
 * 
 * @author macchan
 * @date 2005/06/02 オブプロ「継承」
 * @version 1.0
 */
public class ClassC extends ClassA {

	private int z;

	public ClassC(int z) {
		this.z = z;
	}

	/**
	 * zを取得する
	 */
	public int getZ() {
		return z;
	}

	/**
	 * zを取得する
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * 表示を行う(オーバーライドによる再定義）	 
	 */
	public void display() {
		System.out.println("x=" + getX() + ", y=" + getY() + ", z=" + getZ());
	}
}