/**
 * Example1.java
 * �I�u�W�F�N�g�̓���𗝉����邽�߂̃T���v���v���O�����i���̂P�@�C���X�^���X��j
 * 
 * @author macchan
 * @date 2005/06/15 �I�u�v���u�p���v
 * @version 1.0
 */
public class Example1 {

	public static void main(String[] args) {
		Example1 example = new Example1();
		example.main();
	}

	private ClassA a;

	private void main() {
		//�C���X�^���X������������
		a = new ClassA();
		a.setX(1000);
		a.setY(1000);

		//�o��
		System.out.print("a: ");
		a.display();
	}

}