/**
 * ClassC.java
 * �I�u�W�F�N�g�̓���𗝉����邽�߂̃T���v���v���O����(���̂R�j
 * 
 * @author macchan
 * @date 2005/06/02 �I�u�v���u�p���v
 * @version 1.0
 */
public class ClassC extends ClassA {

	private int z;

	public ClassC(int z) {
		this.z = z;
	}

	/**
	 * z���擾����
	 */
	public int getZ() {
		return z;
	}

	/**
	 * z���擾����
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * �\�����s��(�I�[�o�[���C�h�ɂ��Ē�`�j	 
	 */
	public void display() {
		System.out.println("x=" + getX() + ", y=" + getY() + ", z=" + getZ());
	}
}