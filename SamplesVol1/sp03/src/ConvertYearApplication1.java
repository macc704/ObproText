import obpro.cui.Input;

/*
 * �v���O������: ����a��ϊ��v���O�����i���\�b�h�Ȃ��j
 * 
 * author �I�u�v�����
 * version 1.0
 */
public class ConvertYearApplication1 {

	public static void main(String[] args) {
		ConvertYearApplication1 convertYearApplication = new ConvertYearApplication1();
		convertYearApplication.main();
	}

	// �����a��ɕϊ�����
	void main() {
		// �A�v���P�[�V�����̊J�n��m�点��
		System.out.println("����a��ϊ��v���O�������J�n���܂�");

		{// �����a��ɕϊ�����
			int year;
			String japaneseYear;

			// �������͂���
			System.out.println("�������͂��Ă�������");
			year = Input.getInt();

			// �����a��ɕϊ�����
			if (year >= 1989) {
				japaneseYear = "����" + (year - 1988);
			} else if (year >= 1926) {
				japaneseYear = "���a" + (year - 1925);
			} else {
				japaneseYear = "�s��";
			}

			// �ϊ����ʂ��o�͂���
			System.out.println(year + "�N��" + japaneseYear + "�N�ł�.");
		}

		// �A�v���P�[�V�����̏I����m�点��
		System.out.println("����a��ϊ��v���O�������I�����܂�");
	}
}
