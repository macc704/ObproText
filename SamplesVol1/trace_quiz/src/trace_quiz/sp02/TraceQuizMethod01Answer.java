package trace_quiz.sp02;

import java.util.Scanner;

/**
 * @�v���O�������F �w�肳�ꂽ�����̎l�p�`���R���\�[���ɏo�͂���v���O����
 * @�쐬�F�ނ炩�݂��� (2008/5/22)
 * @�C���Fmacchan (2008/5/23)
 */
public class TraceQuizMethod01Answer {

	public static void main(String[] args) {
		TraceQuizMethod01Answer quiz = new TraceQuizMethod01Answer();
		quiz.main();
	}

	Scanner scanner = new Scanner(System.in);

	// �w�肳�ꂽ�����̎l�p�`���R���\�[���ɏo�͂���
	void main() {
		// �������擾����
		int length;
		System.out.println("��������͂��ĉ�����");
		length = scanner.nextInt();// 4����͂������̂Ƃ���

		// �l�p�`��`��
		methodA(length);
	}

	// �l�p�`��`��
	void methodA(int length) {
		int i = 0;
		while (i < length) {
			if (i == 0) {// ���
				methodB(length);
			} else if (i != 0 && i != length - 1) {// �㉺�ӈȊO�̒i�i���i�j
				methodC(length);
			} else if (i == length - 1) {// ����
				methodB(length);
			}
			i++;
			System.out.println();
		}
	}

	// ��ӁC�܂��͉��ӂ�`��
	void methodB(int length) {
		int i = 0;
		while (i < length) {
			System.out.print("��");
			i++;
		}
	}

	// �㉺�ӈȊO�̒i�i���i�j��`��
	void methodC(int length) {
		int i = 0;
		while (i < length) {
			if (i == 0 || i == length - 1) {// ���ӁE�E��
				System.out.print("��");
			} else {// ���ӁE�E�ӈȊO���󓴂Ŗ��߂�
				System.out.print("��");
			}
			i++;
		}
	}
}