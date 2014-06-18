/**
 * �ėp���X�g��\������N���X
 * 
 * @author macchan
 * @version $Id: ObjectList.java,v 1.1 2007/06/20 10:13:02 macchan Exp $
 */
public class ObjectList {

	//�萔
	final int NULL_INDEX = -1; // �Y�������\�����鐔

	//�f�[�^
	private Object[] objects;
	private int size;

	/**
	 * �R���X�g���N�^
	 */
	public ObjectList() {
		objects = new Object[2];
		size = 0;
	}

	/**
	 * �v�f��ǉ�����
	 */
	public void add(Object Object) {
		int addObjectIndex = getSize();
		objects[addObjectIndex] = Object;
		size++;

		ensureCapacity();
	}

	/**
	 * (�C���X�^���X���w�肵�āj�v�f���폜����
	 */
	public void remove(Object Object) {
		int deleteIndex = getIndex(Object);
		remove(deleteIndex);
	}

	/**
	 * �i�v�f�ԍ����w�肵�āj�v�f���폜����
	 */
	public void remove(int deleteIndex) {
		//���т��폜����
		size--;

		//�폜�����f�[�^����̃f�[�^���߂�
		for (int i = deleteIndex; i < getSize(); i++) {
			objects[i] = objects[i + 1];
		}

		ensureCapacity();
	}

	/**
	 * �i�C���X�^���X���w�肵�āj�v�f�ԍ����擾����
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
	 * (�v�f�ԍ����w�肵��)�v�f���擾����
	 */
	public Object get(int index) {
		return objects[index];
	}

	/**
	 * �v�f�����擾����
	 */
	public int getSize() {
		return size;
	}

	/**
	 * �z��̑傫���𒲐�����	 
	 */
	private void ensureCapacity() {
		Object[] newObjects = new Object[size + 1];
		arrayCopy(objects, newObjects);
		objects = newObjects;
	}

	/**
	 * �z��i�̒��g�j���R�s�[����
	 */
	private void arrayCopy(Object[] source, Object[] target) {
		for (int i = 0; i < source.length && i < target.length; i++) {
			target[i] = source[i];
		}
	}

}