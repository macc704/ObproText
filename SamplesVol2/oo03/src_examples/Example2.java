import java.util.ArrayList;

/**
 * Example2.java
 * �I�u�W�F�N�g�̓���𗝉����邽�߂̃T���v���v���O�����i���̂Q�@�����̃C���X�^���X�j
 * 
 * @author macchan
 * @date 2005/06/15 �I�u�v���u�p���v
 * @date 2007/06/27 camei �z����R���N�V����(ArrayList)�ŏ�������
 * @version 2.0
 */
public class Example2 {

	public static void main(String[] args) {
		Example2 example = new Example2();
		example.main();
	}

	private ArrayList<ClassA> aInstances;

	private void main() {

		// ���X�g����
		aInstances = new ArrayList<ClassA>();

		//�C���X�^���X������������
		initialize(aInstances);

		//�o��
		display(aInstances);
	}

	private void initialize(ArrayList<ClassA> targets) {
		for (int i = 0; i < 3; i++) {
			ClassA a = new ClassA();
			a.setX(100 * i);
			a.setY(100 * i);
			targets.add(a);
		}
	}

	private void display(ArrayList<ClassA> targets) {
		// ArrayList �̑S�v�f�ɏ����A�N�Z�X����͈̂ȉ��̂悤�ɂ�������
		for (int i = 0; i < targets.size(); i++) {
			ClassA a = targets.get(i);// targets��i�Ԗڂ̗v�f���擾
			System.out.print("targets [" + i + "]: ");
			a.display();
		}
	}
}