/**
 * ClassD.java
 * �I�u�W�F�N�g�̓���𗝉����邽�߂̃T���v���v���O����(���̂R�j
 * 
 * @author macchan
 * @date 2005/06/02 �I�u�v���u�p���v
 * @version 1.0
 */
public class ClassD extends ClassC {

	/**
	 * �R���X�g���N�^�͌p�����Ȃ��̂ŁC�K���Ē�`����K�v������
	 */
	public ClassD(int z) {
		super(z);
	}

	/**
	 * z�𑝂₷
	 */
	public void addZ(int addZ) {
		int z = getZ();//�X�[�p�[�N���X�̃��\�b�h���Ă�
		setZ(z + addZ);//�X�[�p�[�N���X�̃��\�b�h���Ă�
	}

}