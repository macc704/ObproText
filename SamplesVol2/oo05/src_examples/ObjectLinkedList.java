/**
 * �ėp���X�g��\������N���X�i�A�����X�g�Ŏ��������j
 * 
 * @author macchan
 * @version $Id: ObjectLinkedList.java,v 1.1 2007/06/20 10:13:02 macchan Exp $
 */
public class ObjectLinkedList {

	// �萔
	final int NULL_INDEX = -1; // �Y�������\�����鐔

	//�f�[�^
	private Link firstLink = null; //�n�_

	/**
	 * �R���X�g���N�^
	 */
	public ObjectLinkedList() {
	}

	/**
	 * �ǉ�����
	 */
	public void add(Object object) {
		//�ǉ�����A���I�u�W�F�N�g�𐶐�����
		Link newLink = new Link();
		newLink.data = object;

		//�ǉ�����
		if (firstLink == null) {//��̂Ƃ�

			//���X�g�̍ŏ��ɒǉ�����
			firstLink = newLink;

		} else {//��łȂ��Ƃ�
			Link currentLink = firstLink; //�����ǂ��Ă���A���I�u�W�F�N�g

			//���X�g�̍Ō��T��
			while (currentLink.next != null) {
				currentLink = currentLink.next;//���̘A���I�u�W�F�N�g�����ǂ�
			}

			//�Ō�ɒǉ�����
			currentLink.next = newLink;
		}
	}

	/**
	 * (�C���X�^���X���w�肵�āj�v�f���폜����
	 */
	public void remove(Object object) {

		Link currentLink = firstLink; //�����ǂ��Ă���A���I�u�W�F�N�g
		Link previousLink = null; //��O�ɂ��ǂ����A���I�u�W�F�N�g

		//�폜���ׂ��A���I�u�W�F�N�g��T���폜����
		while (currentLink != null) {

			//�폜���ׂ��A���I�u�W�F�N�g���폜����
			if (currentLink.data == object) {//�폜����v�f�����������Ƃ�

				//�A���I�u�W�F�N�g���폜����
				if (currentLink == firstLink) {//�A�����X�g�̎n�߂Ō��������Ƃ�
					firstLink = currentLink.next;
					break;
				} else if (currentLink.next == null) {//�A�����X�g�̍Ō�Ō��������Ƃ�
					previousLink.next = null;
					break;
				} else {//�A�����X�g�̒��ԂŌ��������Ƃ�
					previousLink.next = currentLink.next;
					break;
				}
			}

			//���̘A���I�u�W�F�N�g�����ǂ�
			previousLink = currentLink;
			currentLink = currentLink.next;
		}
	}

	/**
	 * �i�v�f�ԍ����w�肵�āj�v�f���폜����
	 */
	public void remove(int index) {
		Object removeTarget = get(index);
		remove(removeTarget);
	}

	/**
	 * �i�C���X�^���X���w�肵�āj�v�f�ԍ����擾����
	 */
	public int getIndex(Object object) {
		Link currentLink = firstLink; //�����ǂ��Ă���A���I�u�W�F�N�g
		int currentIndex = 0;

		//�A���I�u�W�F�N�g�𑖍����C�擾����
		while (currentLink != null) {

			//�w�肳�ꂽ�C���f�b�N�X�ԍ��̃I�u�W�F�N�g���擾����
			if (currentLink.data == object) {
				return currentIndex;
			}

			//���̘A���I�u�W�F�N�g�����ǂ�
			currentLink = currentLink.next;
			currentIndex++;
		}

		return NULL_INDEX;

	}

	/**
	 * (�v�f�ԍ����w�肵��)�v�f���擾����
	 */
	public Object get(int index) {
		Link currentLink = firstLink; //�����ǂ��Ă���A���I�u�W�F�N�g
		int currentIndex = 0;

		//�A���I�u�W�F�N�g��T��
		while (currentLink != null) {

			//�w�肳�ꂽ�C���f�b�N�X�ԍ��̃I�u�W�F�N�g���擾����
			if (currentIndex == index) {
				return currentLink.data;
			}

			//���̘A���I�u�W�F�N�g�����ǂ�
			currentLink = currentLink.next;
			currentIndex++;
		}

		return null;
	}

	/**
	 * �v�f�����擾����
	 */
	public int getSize() {
		Link currentLink = firstLink; //�����ǂ��Ă���A���I�u�W�F�N�g
		int count = 0;

		//���𐔂���
		while (currentLink != null) {

			//���𑝂₷
			count++;

			//�����I������̂Ȃ�擾����
			if (currentLink.next == null) {//�A�����X�g�̍Ō�܂ł������Ƃ�
				return count;
			}

			//���̘A���I�u�W�F�N�g�����ǂ�
			currentLink = currentLink.next;
		}

		//(�A�����X�g���󂾂����Ƃ���0�̂܂ܕԂ�)
		return count;
	}

	/**
	 * �A���R�l�N�^�[��\����������N���X
	 * ���̃N���X���ł̂ݎg���̂ŁC�����Œ�`���Ă���
	 * ���̃N���X���ł̂ݎg���̂ŁC�J�v�Z���������܂���D
	 */
	class Link {
		Object data;
		Link next;
	}

}

