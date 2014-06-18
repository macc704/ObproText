import java.util.ArrayList;

import obpro.common.BConverter;
import obpro.file.BFile;
import obpro.file.BFileReader;
import obpro.file.BFileWriter;

/*
 * �����f�[�^���o�͂̃T���v���v���O�����i���̂P �s��؂�t�H�[�}�b�g�j 
 * ���̃v���O�����𓮂����ɂ́ABFile���C�u�������K�v�B
 * 
 * @author macchan
 * @version 1.0
 */
public class MultiDataFileIOTest1 {

	public static void main(String[] args) {
		MultiDataFileIOTest1 test = new MultiDataFileIOTest1();
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
		BFile file = new BFile("data/data.txt");

		{// �t�@�C���֏����o��
			// �X�g���[�����J��
			BFileWriter writer = file.openWriter();

			// �X�g���[���֏����o��
			for (int i = 0; i < names.size(); i++) {
				writer.println(names.get(i));
				writer.println(BConverter.intToString(scores.get(i)));
			}

			// �X�g���[�������
			writer.close();
		}
	}

	// �ǂݍ���
	void input() {
		// �t�@�C����p�ӂ���
		BFile file = new BFile("data/data.txt");

		{// �t�@�C����ǂݍ���
			// �X�g���[�����J��
			BFileReader reader = file.openReader();

			// �X�g���[������ǂݍ���
			while (!reader.isEndOfFile()) {
				names.add(reader.readLine());
				scores.add(BConverter.stringToInt(reader.readLine()));
			}

			// �X�g���[�������
			reader.close();
		}
	}

}