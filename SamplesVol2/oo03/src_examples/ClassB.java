/**
 * ClassB.java
 * �I�u�W�F�N�g�̓���𗝉����邽�߂̃T���v���v���O����(���̂R�j
 * 
 * @author macchan
 * @date 2005/06/02 �I�u�v���u�p���v
 * @version 1.0
 */
public class ClassB extends ClassA {

	private int w = 300;
	private int h = 400;

	/**
	 * w���擾����
	 */
	public int getW() {
		return w;
	}

	/**
	 * w��ݒ肷��
	 */
	public void setW(int w) {
		this.w = w;
	}

	/**
	 * h���擾����
	 */
	public int getH() {
		return h;
	}

	/**
	 * h��ݒ肷��
	 */
	public void setH(int h) {
		this.h = h;
	}

	/**
	 * �\�����s��(�I�[�o�[���C�h�ɂ��Ē�`�j	 
	 */
	public void display() {
		System.out.println("x=" + getX() + ", y=" + getY() + ", w=" + getW()
				+ ", h=" + getH());
	}

}