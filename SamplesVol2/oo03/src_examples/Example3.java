/**
 * Example3.java
 * �I�u�W�F�N�g�̓���𗝉����邽�߂̃T���v���v���O�����i���̂R�@�p���j
 * 
 * @author macchan
 * @date 2005/06/15 �I�u�v���u�p���v
 * @version 1.0
 */
public class Example3 {

	public static void main(String[] args) {
		Example3 example = new Example3();
		example.main();
	}

	private ClassA a;
	private ClassB b;
	private ClassC c;
	private ClassD d;

	private void main() {
		//�C���X�^���X����
		a = new ClassA();
		b = new ClassB();
		c = new ClassC(100);
		d = new ClassD(100);

		//�l�ݒ�
		a.setX(1000);
		a.setY(1000);
		b.setX(2000);
		b.setY(2000);
		b.setW(2000);
		b.setH(2000);
		c.setX(3000);
		c.setY(3000);
		d.setX(4000);
		d.setY(4000);
		d.addZ(50);

		//�o��
		System.out.print("a: ");
		a.display();
		System.out.print("b: ");
		b.display();
		System.out.print("c: ");
		c.display();
		System.out.print("d: ");
		d.display();
	}
}