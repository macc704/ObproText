/**
 * EnemyCharacter.java
 * �v���C���[��\������N���X
 * 
 * @author macchan
 * @version 1.0
 */
public class EnemyCharacter extends AbstractCharacter {

	/**
	 * �R���X�g���N�^
	 */
	public EnemyCharacter(String name, int maxHP, int maxMP, int power) {
		super(name, maxHP, maxMP, power);
	}

	/**
	 * �P�^�[���̏���������
	 */
	public void processTurn(PlayerCharacter[] players) {
		int targetPlayerIndex = (int) (Math.random() * (double) players.length);
		attack(players[targetPlayerIndex]);
	}

	/**
	 * �U������
	 */
	public void attack(PlayerCharacter player) {
		if (player.isALive()) {
			//�U��
			System.out.println("�{�X�̍U��");
			int attackPoint = (int) (getPower() * Math.random() * 10);
			player.reduceHP(attackPoint);

			//���ʕ�
			System.out.println(player.getName() + "��" + attackPoint
					+ "�̃_���[�W���󂯂�");
			if (!player.isALive()) {
				System.out.println(player.getName() + "�͂��������");
			}
		} else {
			System.out.println(getName() + "��" + player.getName()
					+ "�ɍU�����悤�Ƃ������C���łɂ���ł���");
		}
	}

}