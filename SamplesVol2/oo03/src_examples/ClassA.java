/**
 * ClassA.java
 * �I�u�W�F�N�g�̓���𗝉����邽�߂̃T���v���v���O����(���̂P�`���̂R�j
 * 
 * @author macchan
 * @date 2005/06/02 �I�u�v���u�p���v
 * @version 1.0
 */
public class ClassA {

	private int x = 100;
	private int y = 200;

	/**
	 * x���擾����
	 */
	public int getX() {
		return x;
	}

	/**
	 * x��ݒ肷��
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * y���擾����
	 */
	public int getY() {
		return y;
	}

	/**
	 * y��ݒ肷��
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * �\�����s��	 
	 */
	public void display() {
		System.out.println("x=" + getX() + ", y=" + getY());
	}

}