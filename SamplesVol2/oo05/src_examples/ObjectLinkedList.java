/**
 * 汎用リストを表現するクラス（連結リストで実装した）
 * 
 * @author macchan
 * @version $Id: ObjectLinkedList.java,v 1.1 2007/06/20 10:13:02 macchan Exp $
 */
public class ObjectLinkedList {

	// 定数
	final int NULL_INDEX = -1; // 添字未定を表現する数

	//データ
	private Link firstLink = null; //始点

	/**
	 * コンストラクタ
	 */
	public ObjectLinkedList() {
	}

	/**
	 * 追加する
	 */
	public void add(Object object) {
		//追加する連結オブジェクトを生成する
		Link newLink = new Link();
		newLink.data = object;

		//追加する
		if (firstLink == null) {//空のとき

			//リストの最初に追加する
			firstLink = newLink;

		} else {//空でないとき
			Link currentLink = firstLink; //今たどっている連結オブジェクト

			//リストの最後を探す
			while (currentLink.next != null) {
				currentLink = currentLink.next;//次の連結オブジェクトをたどる
			}

			//最後に追加する
			currentLink.next = newLink;
		}
	}

	/**
	 * (インスタンスを指定して）要素を削除する
	 */
	public void remove(Object object) {

		Link currentLink = firstLink; //今たどっている連結オブジェクト
		Link previousLink = null; //一つ前にたどった連結オブジェクト

		//削除すべき連結オブジェクトを探し削除する
		while (currentLink != null) {

			//削除すべき連結オブジェクトを削除する
			if (currentLink.data == object) {//削除する要素が見つかったとき

				//連結オブジェクトを削除する
				if (currentLink == firstLink) {//連結リストの始めで見つかったとき
					firstLink = currentLink.next;
					break;
				} else if (currentLink.next == null) {//連結リストの最後で見つかったとき
					previousLink.next = null;
					break;
				} else {//連結リストの中間で見つかったとき
					previousLink.next = currentLink.next;
					break;
				}
			}

			//次の連結オブジェクトをたどる
			previousLink = currentLink;
			currentLink = currentLink.next;
		}
	}

	/**
	 * （要素番号を指定して）要素を削除する
	 */
	public void remove(int index) {
		Object removeTarget = get(index);
		remove(removeTarget);
	}

	/**
	 * （インスタンスを指定して）要素番号を取得する
	 */
	public int getIndex(Object object) {
		Link currentLink = firstLink; //今たどっている連結オブジェクト
		int currentIndex = 0;

		//連結オブジェクトを走査し，取得する
		while (currentLink != null) {

			//指定されたインデックス番号のオブジェクトを取得する
			if (currentLink.data == object) {
				return currentIndex;
			}

			//次の連結オブジェクトをたどる
			currentLink = currentLink.next;
			currentIndex++;
		}

		return NULL_INDEX;

	}

	/**
	 * (要素番号を指定して)要素を取得する
	 */
	public Object get(int index) {
		Link currentLink = firstLink; //今たどっている連結オブジェクト
		int currentIndex = 0;

		//連結オブジェクトを探す
		while (currentLink != null) {

			//指定されたインデックス番号のオブジェクトを取得する
			if (currentIndex == index) {
				return currentLink.data;
			}

			//次の連結オブジェクトをたどる
			currentLink = currentLink.next;
			currentIndex++;
		}

		return null;
	}

	/**
	 * 要素数を取得する
	 */
	public int getSize() {
		Link currentLink = firstLink; //今たどっている連結オブジェクト
		int count = 0;

		//数を数える
		while (currentLink != null) {

			//数を増やす
			count++;

			//数え終わったのなら取得する
			if (currentLink.next == null) {//連結リストの最後までいったとき
				return count;
			}

			//次の連結オブジェクトをたどる
			currentLink = currentLink.next;
		}

		//(連結リストが空だったときは0のまま返す)
		return count;
	}

	/**
	 * 連結コネクターを表現する内部クラス
	 * このクラス内でのみ使うので，ここで定義している
	 * このクラス内でのみ使うので，カプセル化もしません．
	 */
	class Link {
		Object data;
		Link next;
	}

}

