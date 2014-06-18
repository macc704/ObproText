import java.util.ArrayList;

import obpro.common.BConverter;
import obpro.file.BFile;
import obpro.file.BFileReader;
import obpro.file.BFileWriter;

/*
 * �����f�[�^���o�͂̃T���v���v���O�����i���̂Q�@�J���}��؂�j
 * ���̃v���O�����𓮂����ɂ́ABFile���C�u�������K�v�B
 *
 * @author macchan
 * @version 1.0
 */
public class MultiDataFileIOTest2 {

	public static void main(String[] args) {
		MultiDataFileIOTest2 test = new MultiDataFileIOTest2();
		test.run(args);
	}

	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Integer> scores = new ArrayList<Integer>();

	// �t�@�C���ǂݏ����̃e�X�g
	void run(String[] args) {
		addData("����", 50);
		addData("�ؑ�", 80);
		addData("��_", 90);
		addData("����", 35);
		output();
		input();
	}

	void addData(String name, int score) {
		names.add(name);
		scores.add(score);
	}

	// �����o��
	void output() {
		// �t�@�C����p�ӂ���
		BFile file = new BFile("data/data.csv");

		{// �t�@�C���֏����o��
			// �X�g���[�����J��
			BFileWriter writer = file.openWriter();

			// �X�g���[���֏����o��
			for (int i = 0; i < names.size(); i++) {
				writer.print(names.get(i));
				writer.print(",");
				writer.print(BConverter.intToString(scores.get(i)));
				writer.println();
			}

			// �X�g���[�������
			writer.close();
		}
	}

	// �ǂݍ���
	@SuppressWarnings("unchecked")
	void input() {
		// �t�@�C����p�ӂ���
		BFile file = new BFile("data/data.csv");

		{// �t�@�C����ǂݍ���
			// �X�g���[�����J��
			BFileReader reader = file.openReader();

			// �X�g���[������ǂݍ���
			while (!reader.isEndOfFile()) {
				String line = reader.readLine();
				ArrayList<String> tokens = BConverter.split(line, ",");
				names.add(tokens.get(0));
				scores.add(BConverter.stringToInt(tokens.get(1)));
			}

			// �X�g���[�������
			reader.close();
		}
	}
}