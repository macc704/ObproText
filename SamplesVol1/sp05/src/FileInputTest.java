import java.util.ArrayList;

import obpro.file.BFile;
import obpro.file.BFileReader;

/*
 * �t�@�C�����͂̃T���v���v���O����
 * ���̃v���O�����𓮂����ɂ́A�R���p�C�����ɓ����t�H���_�Ɏ��̃t�@�C�����K�v�B
 * 
 * @author macchan
 * @version 1.0
 */
public class FileInputTest {

	public static void main(String[] args) {
		FileInputTest test = new FileInputTest();
		test.run();
	}

	// �t�@�C���ǂݍ��݂̃e�X�g
	// �ǂݍ���ŕ\������
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void run() {
		// �t�@�C����p�ӂ���
		BFile file = new BFile("data/data.txt");
		ArrayList inputStrings = new ArrayList();

		{// �t�@�C����ǂݍ���
			// �X�g���[�����J��
			BFileReader reader = file.openReader();

			// �X�g���[������ǂݍ���
			for (int i = 0; !reader.isEndOfFile(); i++) {
				inputStrings.add(i, reader.readLine());
			}

			// �X�g���[�������
			reader.close();
		}

		// �\������
		for (int i = 0; i < inputStrings.size(); i++) {
			System.out.println(inputStrings.get(i));
		}
	}
}