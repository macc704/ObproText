import obpro.cui.Input;

/**
 * ObproQuest.java
 * �I�u�v���N�G�X�g2
 * 
 * @author macchan
 * @version $Id: ObproQuest2.java,v 1.1 2007/06/27 19:27:24 camei Exp $
 */
public class ObproQuest2 {

	public static void main(String[] args) {
		ObproQuest2 obproQuest = new ObproQuest2();
		obproQuest.main();
	}

	private PlayerCharacter[] players = new PlayerCharacter[3];
	private EnemyCharacter enemy;

	//�Q�[��������
	private void main() {
		//�A�v���P�[�V�����̊J�n��m�点��
		System.out.println("���I�u�v���N�G�X�g2��");
		System.out.print("\n\n\n");

		//����������
		initialize();

		//�G�Ɛ키
		System.out.println(enemy.getName() + "�������ꂽ");
		while (true) {
			//���݂̏󋵂��o�͂���
			display();

			//�����^�[���̏���������
			if (!isAllPlayersDead()) {
				for (int i = 0; i < players.length && enemy.isALive(); i++) {
					players[i].processTurn(enemy);
				}
			} else {
				System.out.println("�S�ł��܂���");
				break;
			}

			//�G�^�[���̏���������			
			if (enemy.isALive()) {
				enemy.processTurn(players);
			} else {
				System.out.println(enemy.getName() + "��|����!");
				break;
			}
		}

		//�A�v���P�[�V�����̏I����m�点��
		System.out.print("\n\n\n");
		System.out.println("�Q�[���I�[�o�[");
	}

	/**
	 * ����������	 
	 */
	private void initialize() {
		createPlayer(0, 100, 25, 15);
		createPlayer(1, 100, 10, 20);
		createPlayer(2, 100, 5, 35);
		enemy = new EnemyCharacter("����", 400, 0, 30);
	}

	/**
	 * ��l�̃v���C���[���쐬����
	 */
	private void createPlayer(int i, int maxHP, int maxMP, int power) {
		System.out.println((i + 1) + "�Ԗڂ̗E�҂̖��O����͂��Ă�������");
		String name = Input.getString();
		players[i] = new PlayerCharacter(name, maxHP, maxMP, power);
	}

	/**
	 * ���ׂẴv���C���[������ł��܂������ǂ������ׂ�
	 */
	private boolean isAllPlayersDead() {
		for (int i = 0; i < players.length; i++) {
			if (players[i].isALive()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * ���݂̏󋵂��o�͂���	 
	 */
	private void display() {
		System.out.println("------------------------");
		for (int i = 0; i < players.length; i++) {
			players[i].display();
		}
		System.out.println("------------------------");
		System.out.println();
	}

}