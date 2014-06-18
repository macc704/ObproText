/**
 * ���у��X�g��\������N���X
 * 
 * @author macchan
 * @version $Id: ScoreList.java,v 1.1 2007/06/20 10:13:02 macchan Exp $
 */
public class ScoreList {

	// �萔
	final int NULL_INDEX = -1; // �Y�������\�����鐔

	// ���уf�[�^
	private Score[] scores;
	private int scoreSize;

	/**
	 * �R���X�g���N�^
	 */
	public ScoreList() {
		scores = new Score[2];
		scoreSize = 0;
	}

	/**
	 * ���т�ǉ�����
	 */
	public void add(Score score) {
		int addScoreIndex = getSize();
		scores[addScoreIndex] = score;
		scoreSize++;
	}

	/**
	 * (�C���X�^���X���w�肵�āj���т��폜����
	 */
	public void remove(Score score) {
		int deleteIndex = getIndex(score);
		remove(deleteIndex);
	}

	/**
	 * �i�v�f�ԍ����w�肵�āj���т��폜����
	 */
	public void remove(int deleteIndex) {
		// ���т��폜����
		scoreSize--;

		// �폜�����f�[�^����̃f�[�^���߂�
		for (int i = deleteIndex; i < getSize(); i++) {
			scores[i] = scores[i + 1];
		}
	}

	/**
	 * �i�C���X�^���X���w�肵�āj�v�f�ԍ����擾����
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
	 * (�v�f�ԍ����w�肵��)���т��擾����
	 */
	public Score getScore(int index) {
		return scores[index];
	}

	/**
	 * ���уf�[�^�̐����擾����
	 */
	public int getSize() {
		return scoreSize;
	}

	/**
	 * �z��̑傫���𒲐�����
	 */
	@SuppressWarnings("unused")
	private void ensureCapacity() {
		Score[] newScores = new Score[scoreSize + 1];
		arrayCopy(scores, newScores);
		scores = newScores;
	}

	/**
	 * �z��i�̒��g�j���R�s�[����
	 */
	private void arrayCopy(Score[] source, Score[] target) {
		for (int i = 0; i < source.length && i < target.length; i++) {
			target[i] = source[i];
		}
	}

}