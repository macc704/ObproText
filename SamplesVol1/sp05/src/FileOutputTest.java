import obpro.file.BFile;
import obpro.file.BFileWriter;

/*
 * �t�@�C���o�͂̃T���v���v���O����
 * ���̃v���O�����𓮂����ɂ́A�R���p�C�����ɓ����t�H���_�Ɏ��̃t�@�C�����K�v�B
 * 
 * @author macchan
 * @version 1.0
 */
public class FileOutputTest {

	public static void main(String[] args) {
		FileOutputTest test = new FileOutputTest();
		test.run();
	}

	// �t�@�C�������o���̃e�X�g
	void run() {
		// �t�@�C����p�ӂ���
		BFile file = new BFile("data/data.txt");

		{// �t�@�C���֏����o��
			// �X�g���[�����J��
			BFileWriter writer = file.openWriter();

			// �X�g���[���֏����o��
			writer.println("�e�X�g");

			// �X�g���[�������
			writer.close();
		}
	}

}