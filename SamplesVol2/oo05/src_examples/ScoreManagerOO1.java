/**
 * ���ъǗ�����A�v���P�[�V�����i�I�u�W�F�N�g�w���@����1)
 * (�G���[�����Ȃ�)
 * 
 * ���L�̃R�}���h�ɂ�萬�т��Ǘ��ł���
 * �E���т̒ǉ��i�R�}���h�Fadd�j
 * �E���т̍폜�i�R�}���h�Fdel�j
 * �E���т̌����i�R�}���h�Fsearch�j
 * �E���шꗗ�ƕ��ϕ\���i�R�}���h�Fshow�j
 * 
 * @author Yoshiaki Matsuzawa
 * @version 1.0
 */
public class ScoreManagerOO1 {

	public static void main(String[] args) {
		ScoreManagerOO1 scoreManager = new ScoreManagerOO1();
		scoreManager.main();
	}

	// �萔
	final int MANAGEMENT_SCORE_MAX_SIZE = 5; // ���͂ł��鐬�т̐�
	final int NULL_INDEX = -1; // �Y�������\�����鐔

	final String ADD = "add";
	final String DELETE = "del";
	final String SEARCH = "search";
	final String SHOW = "show";
	final String QUIT = "quit";

	//���уf�[�^
	private Score[] scores;
	private int scoreSize;

	//���т��Ǘ�����
	private void main() {
		//�A�v���P�[�V�����̊J�n��m�点��
		System.out.println("���������������ъǗ��A�v���P�[�V����������������");

		//���т��Ǘ�����
		initializeData();
		manageScores();

		//�A�v���P�[�V�����̏I����m�点��
		System.out.println("�A�v���P�[�V�������I�����܂��B");
	}

	//�f�[�^������������
	private void initializeData() {
		//(�z��쐬)
		scores = new Score[MANAGEMENT_SCORE_MAX_SIZE];

		//(�傫��������)
		scoreSize = 0;
	}

	//���т��Ǘ�����
	private void manageScores() {
		//���т��Ǘ�����
		while (true) {
			//�R�}���h�̓��͂��󂯎��
			String command = getCommand();

			//�R�}���h�����s����
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

	//�R�}���h���͂��󂯎��
	private String getCommand() {
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
	private void addScore() {
		//���т̓��͂��󂯎��
		System.out.println("���O����͂��Ă�������");
		String name = Input.getString();
		System.out.println("���т���͂��Ă�������");
		int score = Input.getInt();

		//���т�ǉ�����
		int addScoreIndex = getScoreSize();
		scores[addScoreIndex] = new Score(score, name);
		scoreSize++;

		//�ǉ����ʂ��o�͂���
		System.out.println("���т�o�^���܂���");
	}

	private void deleteScore() {
		//�폜�Ώۂ̓��͂��󂯎��
		System.out.println("�폜���鐬�т̖��O����͂��Ă�������");
		String name = Input.getString();

		//���т��폜����
		int deleteIndex = searchScore(name);
		deleteScore(deleteIndex);

		//�폜���ʂ��o�͂���
		System.out.println("���т��폜���܂���");
	}

	//��������
	private void searchScore() {
		//�����Ώۂ̓��͂��󂯎��
		System.out.println("�������鐬�т̖��O����͂��Ă�������");
		String name = Input.getString();

		//��������
		int searchIndex = searchScore(name);

		//�������ʂ��o�͂���		
		System.out.println(scores[searchIndex].getName() + "����̓_����"
				+ scores[searchIndex].getScore() + "�_�ł�");
	}

	//���шꗗ�ƕ��ϓ_��\������	 
	private void showScoreList() {
		//���шꗗ��\������
		System.out.println("���������������шꗗ�\������������");
		for (int i = 0; i < getScoreSize(); i++) {
			System.out.println(scores[i].getName() + "����"
					+ scores[i].getScore() + "�_");
		}

		//���ϓ_��\������
		System.out.println("���������������ϓ_������������");
		double average = getAverageScore();
		System.out.println("���ϓ_�F" + average + "�_");
	}

	//���O���L�[�ɐ��т���������
	private int searchScore(String name) {
		for (int i = 0; i < getScoreSize(); i++) {
			if (scores[i].getName().equals(name)) {
				return i;
			}
		}
		return NULL_INDEX;
	}

	//���݂̐��уf�[�^�̐����擾����
	private int getScoreSize() {
		return scoreSize;
	}

	//���т��폜����
	private void deleteScore(int deleteIndex) {
		//���т��폜����
		scoreSize--;

		//�폜�����f�[�^����̃f�[�^���߂�
		for (int i = deleteIndex; i < getScoreSize(); i++) {
			scores[i] = scores[i + 1];
		}
	}

	//���ϓ_���v�Z����
	private double getAverageScore() {
		//���v�_���v�Z����
		double total = 0d;
		for (int i = 0; i < getScoreSize(); i++) {
			total = total + scores[i].getScore();
		}

		//���ϓ_���v�Z����
		double average = total / getScoreSize();

		return average;
	}

}