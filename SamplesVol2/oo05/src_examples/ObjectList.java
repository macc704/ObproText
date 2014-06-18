/**
 * 汎用リストを表現するクラス
 * 
 * @author macchan
 * @version $Id: ObjectList.java,v 1.1 2007/06/20 10:13:02 macchan Exp $
 */
public class ObjectList {

	//定数
	final int NULL_INDEX = -1; // 添字未定を表現する数

	//データ
	private Object[] objects;
	private int size;

	/**
	 * コンストラクタ
	 */
	public ObjectList() {
		objects = new Object[2];
		size = 0;
	}

	/**
	 * 要素を追加する
	 */
	public void add(Object Object) {
		int addObjectIndex = getSize();
		objects[addObjectIndex] = Object;
		size++;

		ensureCapacity();
	}

	/**
	 * (インスタンスを指定して）要素を削除する
	 */
	public void remove(Object Object) {
		int deleteIndex = getIndex(Object);
		remove(deleteIndex);
	}

	/**
	 * （要素番号を指定して）要素を削除する
	 */
	public void remove(int deleteIndex) {
		//成績を削除する
		size--;

		//削除したデータより後のデータをつめる
		for (int i = deleteIndex; i < getSize(); i++) {
			objects[i] = objects[i + 1];
		}

		ensureCapacity();
	}

	/**
	 * （インスタンスを指定して）要素番号を取得する
	 */
	public int getIndex(Object object) {
		for (int i = 0; i < getSize(); i++) {
			if (objects[i] == object) {
				return i;
			}
		}
		return NULL_INDEX;
	}

	/**
	 * (要素番号を指定して)要素を取得する
	 */
	public Object get(int index) {
		return objects[index];
	}

	/**
	 * 要素数を取得する
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 配列の大きさを調整する	 
	 */
	private void ensureCapacity() {
		Object[] newObjects = new Object[size + 1];
		arrayCopy(objects, newObjects);
		objects = newObjects;
	}

	/**
	 * 配列（の中身）をコピーする
	 */
	private void arrayCopy(Object[] source, Object[] target) {
		for (int i = 0; i < source.length && i < target.length; i++) {
			target[i] = source[i];
		}
	}

}