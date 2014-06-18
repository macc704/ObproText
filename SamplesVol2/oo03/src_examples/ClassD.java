/**
 * ClassD.java
 * オブジェクトの動作を理解するためのサンプルプログラム(その３）
 * 
 * @author macchan
 * @date 2005/06/02 オブプロ「継承」
 * @version 1.0
 */
public class ClassD extends ClassC {

	/**
	 * コンストラクタは継承しないので，必ず再定義する必要がある
	 */
	public ClassD(int z) {
		super(z);
	}

	/**
	 * zを増やす
	 */
	public void addZ(int addZ) {
		int z = getZ();//スーパークラスのメソッドを呼ぶ
		setZ(z + addZ);//スーパークラスのメソッドを呼ぶ
	}

}