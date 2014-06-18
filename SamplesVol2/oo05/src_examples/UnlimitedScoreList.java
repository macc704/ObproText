/**
 * 成績リストを表現するクラス
 * (ScoreListを可変長にした）
 * 
 * @author macchan
 * @version $Id: UnlimitedScoreList.java,v 1.1 2007/06/20 10:13:02 macchan Exp $
 */
public class UnlimitedScoreList {

	// 定数
	final int NULL_INDEX = -1; // 添字未定を表現する数

	//成績データ
	private Score[] scores;
	private int scoreSize;

	/**
	 * コンストラクタ
	 */
	public UnlimitedScoreList() {
		scores = new Score[2];
		scoreSize = 0;
	}

	/**
	 * 成績を追加する
	 */
	public void add(Score score) {
		int addScoreIndex = getSize();
		scores[addScoreIndex] = score;
		scoreSize++;

		ensureCapacity();
	}

	/**
	 * (インスタンスを指定して）)成績を削除する
	 */
	public void remove(Score score) {
		int deleteIndex = getIndex(score);
		remove(deleteIndex);
	}

	/**
	 * （要素番号を指定して）成績を削除する
	 */
	public void remove(int deleteIndex) {
		//成績を削除する
		scoreSize--;

		//削除したデータより後のデータをつめる
		for (int i = deleteIndex; i < getSize(); i++) {
			scores[i] = scores[i + 1];
		}

		ensureCapacity();
	}

	/**
	 * （インスタンスを指定して）要素番号を取得する
	 */
	public int getIndex(Score score) {
		for (int i = 0; i < getSize(); i++) {
			if (scores[i] == score) {
				return i;
			}
		}
		return NULL_INDEX;
	}

	/**
	 * (要素番号を指定して)インスタンスを取得する
	 */
	public Score getScore(int index) {
		return scores[index];
	}

	/**
	 * 現在の成績データの数を取得する
	 */
	public int getSize() {
		return scoreSize;
	}

	/**
	 * 配列の大きさを調整する	 
	 */
	private void ensureCapacity() {
		Score[] newScores = new Score[scoreSize + 1];
		arrayCopy(scores, newScores);
		scores = newScores;
	}

	/**
	 * 配列（の中身）をコピーする
	 */
	private void arrayCopy(Score[] source, Score[] target) {
		for (int i = 0; i < source.length && i < target.length; i++) {
			target[i] = source[i];
		}
	}

}