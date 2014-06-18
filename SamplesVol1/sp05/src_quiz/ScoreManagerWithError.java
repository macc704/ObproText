import java.util.HashMap;

import obpro.cui.Input;

/**
 * ���ъǗ�����A�v���P�[�V����
 * �i�f�o�b�O���, ����2��ނ���j
 * �i�s���ȕ������͂̃G���[�����͂��Ȃ��ėǂ����̂Ƃ���)
 * 
 * ���L�̃R�}���h�ɂ�萬�т��Ǘ��ł���
 * �E���т̒ǉ��i�R�}���h�Fadd�j
 * �E���т̍폜�i�R�}���h�Fdel�j
 * �E���т̌����i�R�}���h�Fsearch�j
 * �E���шꗗ�ƕ��ϕ\���i�R�}���h�Fshow�j
 * 
 * @author Masahiro Kawamura
 * @version $Id: ScoreManagerWithError.java,v 1.2 2007/05/24 12:21:33 macchan Exp $
 */
public class ScoreManagerWithError {

	public static void main(String[] args) {
		ScoreManagerWithError scoreManager = new ScoreManagerWithError();
		scoreManager.main();
	}

	final int NULL_INDEX = -1;

	final String ADD = "add";
	final String DELETE = "del";
	final String SEARCH = "search";
	final String SHOW = "show";
	final String QUIT = "quit";

	//���уf�[�^(�O���[�o��)
	HashMap<String, Integer> scores;

	//���т��Ǘ�����
	void main() {
		//�A�v���P�[�V�����̊J�n��m�点��
		System.out.println("���������������ъǗ��A�v���P�[�V����������������");

		//���т��Ǘ�����
		initializeData();
		manageScores();

		//�A�v���P�[�V�����̏I����m�点��
		System.out.println("�A�v���P�[�V�������I�����܂��B");
	}

	//�f�[�^������������
	void initializeData() {
		scores = new HashMap<String, Integer>();
	}

	//���т��Ǘ�����
	void manageScores() {
		//���т��Ǘ�����
		while (true) {
			//�R�}���h�̓��͂��󂯎��
			String command = getCommand();

			//�R�}���h�����s����
			if (command == ADD) {
				addScore();
			} else if (command.equals(DELETE)) {
				deleteScore();
			} else if (command.equals(SEARCH)) {
				searchScore();
			} else if (command.equals(SHOW)) {
				showScoreList();
			} else if (command.equals(QUIT)) {
				break;
			} else {
				System.out.println("���̂悤�ȃR�}���h�͂���܂���");
			}
		}
	}

	//�R�}���h���͂��󂯎��
	String getCommand() {
		//���j���[���o�͂���
		System.out.print("�R�}���h����͂��Ă�������");
		System.out.print("(" + ADD + ":���т̒ǉ�");
		System.out.print(", " + DELETE + ":���т̍폜");
		System.out.print(", " + SEARCH + ":���т̌���");
		System.out.print(", " + SHOW + ":���шꗗ�ƕ��ϓ_�̕\��");
		System.out.print(", " + QUIT + ":�I��" + ")");
		System.out.println();

		//�R�}���h�̓��͂��󂯎��
		String command = Input.getString();
		return command;
	}

	//���т�ǉ�����
	void addScore() {
		//���т̓��͂��󂯎��
		System.out.println("���O����͂��Ă�������");
		String name = Input.getString();
		System.out.println("���т���͂��Ă�������");
		int score = Input.getInt();

		//���т�ǉ�����
		scores.put(name, score);

		//�ǉ����ʂ��o�͂���
		System.out.println("���т�o�^���܂���");
	}

	void deleteScore() {
		//�폜�Ώۂ̓��͂��󂯎��
		System.out.println("�폜���鐬�т̖��O����͂��Ă�������");
		String name = Input.getString();

		//���т��폜����
		scores.remove(name);

		//�폜���ʂ��o�͂���
		System.out.println("���т��폜���܂���");
	}

	//��������
	void searchScore() {
		//�����Ώۂ̓��͂��󂯎��
		System.out.println("�������鐬�т̖��O����͂��Ă�������");
		String name = Input.getString();

		//��������

		//�������ʂ��o�͂���
		System.out.println(name + "����̓_����" + scores.get(name) + "�_�ł�");
	}

	//���шꗗ�ƕ��ϓ_��\������	 
	void showScoreList() {
		//���шꗗ��\������
		System.out.println("���������������шꗗ�\������������");
		for (String key : scores.keySet()) {
			System.out.println(key + "����" + scores.get(key) + "�_");
		}

		//���ϓ_��\������
		System.out.println("���������������ϓ_������������");
		double average = getAverageScore();
		System.out.println("���ϓ_�F" + average + "�_");
	}

	//���ϓ_���v�Z����
	double getAverageScore() {
		//���v�_���v�Z����
		double total = 0d;
		for (int i = 0; i < scores.size(); i++) {
			total = total + scores.get(i);
		}

		//���ϓ_���v�Z����
		double average = total / scores.size();

		return average;
	}

}