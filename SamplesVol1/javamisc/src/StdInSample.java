import java.util.Scanner;

/*
 * �v���O������: Java�ɂ��W�����o��
 * @author Yoshiaki Matsuzawa 
 * @date 2010/04/09
 */
public class StdInSample {

	public static void main(String[] args) {
		StdInSample stdInSample = new StdInSample();
		stdInSample.main();
	}

	Scanner input = new Scanner(System.in);// �W�����͂���͂���X�L���i�i���͂��s�����߂ɕK�v�j

	void main() {
		// ������̓���
		System.out.print("������������͂��Ă�>");
		System.out.flush();
		String s1 = input.next();// �W�����́F���̍s��ǂݍ��ށi�ǂݍ��ނ܂Ńu���b�N�j
		System.out.println("���͂��ꂽ������" + s1 + "�ł��D");// (Java��)

		// ���l�̓���
		System.out.print("������������͂��Ă�>");
		System.out.flush();
		int i1 = input.nextInt();// ���̍s��ǂݍ��݁C�����ɕϊ��i�ϊ��ł��Ȃ���Η�O�j
		System.out.println("���͂��ꂽ������" + i1 + "�ł��D");// (Java��)
	}

}