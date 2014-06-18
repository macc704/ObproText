import java.util.ArrayList;

import obpro.cui.Input;

/*
 * ���ъǗ�����A�v���P�[�V�����i����1)
 * (�G���[�����Ȃ�)
 * 
 * ���L�̃R�}���h�ɂ�萬�т��Ǘ��ł���
 * �E���т̒ǉ��i�R�}���h�Fadd�j
 * �E���т̍폜�i�R�}���h�Fdel�j
 * �E���т̌����i�R�}���h�Fsearch�j
 * �E���шꗗ�ƕ��ϕ\���i�R�}���h�Fshow�j
 * 
 * @author Masahiro Kawamura
 * @version $Id: ScoreManager1.java,v 1.1 2007/05/24 12:10:00 macchan Exp $
 */
public class ScoreManager1 {

	public static void main(String[] args) {
		ScoreManager1 scoreManager = new ScoreManager1();
		scoreManager.main();
	}

	// �萔
	final int MANAGEMENT_SCORE_MAX_SIZE = 5; // ���͂ł��鐬�т̐�
	final String ADD = "add";
	final String DELETE = "del";
	final String SEARCH = "search";
	final String SHOW = "show";
	final String QUIT = "quit";

	// ���уf�[�^(�O���[�o��)
	ArrayList<Integer> scores;

	// ���т��Ǘ�����
	void main() {
		// �A�v���P�[�V�����̊J�n��m�点��
		System.out.println("���������������ъǗ��A�v���P�[�V����������������");

		// ���т��Ǘ�����
		initializeData();
		manageScores();

		// �A�v���P�[�V�����̏I����m�点��
		System.out.println("�A�v���P�[�V�������I�����܂��B");
	}

	// �f�[�^������������
	void initializeData() {
		scores = new ArrayList<Integer>();
	}

	// ���т��Ǘ�����
	void manageScores() {
		// ���т��Ǘ�����
		while (true) {
			// �R�}���h�̓��͂��󂯎��
			String command = getCommand();

			// �R�}���h�����s����
			if (command.equals(ADD)) {
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

	// �R�}���h���͂��󂯎��
	String getCommand() {
		// ���j���[���o�͂���
		System.out.print("�R�}���h����͂��Ă�������");
		System.out.print("(" + ADD + ":���т̒ǉ�");
		System.out.print(", " + DELETE + ":���т̍폜");
		System.out.print(", " + SEARCH + ":���т̌���");
		System.out.print(", " + SHOW + ":���шꗗ�ƕ��ϓ_�̕\��");
		System.out.print(", " + QUIT + ":�I��" + ")");
		System.out.println();

		// �R�}���h�̓��͂��󂯎��
		String command = Input.getString();
		return command;
	}

	// ���т�ǉ�����
	void addScore() {
		// ���т̓��͂��󂯎��
		System.out.println("���т���͂��Ă�������");
		int score = Input.getInt();

		// ���т�ǉ�����
		scores.add(score);

		// �ǉ����ʂ��o�͂���
		System.out.println("���т�o�^���܂���");
	}

	void deleteScore() {
		// �폜�Ώۂ̓��͂��󂯎��
		System.out.println("�폜���鐬�т̔ԍ�����͂��Ă�������");
		int deleteIndex = Input.getInt();

		// ���т��폜����
		deleteScore(deleteIndex);

		// �폜���ʂ��o�͂���
		System.out.println("���т��폜���܂���");
	}

	// ��������
	void searchScore() {
		// �����Ώۂ̓��͂��󂯎��
		System.out.println("�������鐬�т̔ԍ�����͂��Ă�������");
		int searchIndex = Input.getInt();

		// ��������
		// (�����s�v)

		// �������ʂ��o�͂���
		System.out.println(scores.get(searchIndex) + "�_�ł�");
	}

	// ���шꗗ�ƕ��ϓ_��\������
	void showScoreList() {
		// ���шꗗ��\������
		System.out.println("���������������шꗗ�\������������");
		for (int i = 0; i < scores.size(); i++) {
			System.out.println("����[" + i + "]" + scores.get(i) + "�_");
		}

		// ���ϓ_��\������
		System.out.println("���������������ϓ_������������");
		double average = getAverageScore();
		System.out.println("���ϓ_�F" + average + "�_");
	}

	// ���т��폜����
	void deleteScore(int deleteIndex) {
		scores.remove(deleteIndex);
	}

	// ���ϓ_���v�Z����
	double getAverageScore() {
		// ���v�_���v�Z����
		double total = 0d;
		for (int i = 0; i < scores.size(); i++) {
			total = total + scores.get(i);
		}

		// ���ϓ_���v�Z����
		double average = total / scores.size();

		return average;
	}

}