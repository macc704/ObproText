import obpro.cui.Input;

/**
 * PlayerCharacter.java
 * �v���C���[��\������N���X
 * 
 * @author macchan
 * @version 1.0
 */
public class PlayerCharacter extends AbstractCharacter {

	private final int HEAL_CONSUME_MP = 5;
	private final int POWERUP_CONSUME_MP = 10;

	/**
	 * �R���X�g���N�^
	 */
	public PlayerCharacter(String name, int maxHP, int maxMP, int power) {
		super(name, maxHP, maxMP, power);
	}

	/**
	 * �P�^�[���̏���������
	 */
	public void processTurn(EnemyCharacter enemy) {
		if (isALive()) {
			//�R�}���h��I��
			System.out.println(getName() + "�̃^�[�� 1.�������� 2.�� 3.�p���[�A�b�v");
			System.out.print(">>");
			System.out.flush();
			String command = Input.getString();

			//�R�}���h�����s����
			if ("1".equals(command)) {
				attack(enemy);
			} else if ("2".equals(command)) {
				heal();
			} else if ("3".equals(command)) {
				upPower();
			} else {
				System.out.println("�����ȃR�}���h�ł�");
			}
		}
	}

	/**
	 * �U������
	 */
	private void attack(EnemyCharacter enemy) {
		System.out.println(getName() + "�̍U���I");
		int attackPoint = (int) (Math.random() * 10) + getPower();
		enemy.reduceHP(attackPoint);
		System.out.println(enemy.getName() + "��" + attackPoint + "�̃_���[�W��^����");
	}

	/**
	 * �񕜂���
	 */
	private void heal() {
		if (getMP() >= HEAL_CONSUME_MP) {
			super.refreshHP();
			super.reduceMP(HEAL_CONSUME_MP);
			System.out.println(getName() + "��HP���񕜂���");
		} else {
			System.out.println("MP������܂���");
		}
	}

	/**
	 * �p���[�A�b�v����
	 */
	private void upPower() {
		if (getMP() >= POWERUP_CONSUME_MP) {
			super.setPower(getPower() * 2);
			super.reduceMP(POWERUP_CONSUME_MP);
			System.out.println(getName() + "�̂����炪�オ����");
		} else {
			System.out.println("MP������܂���");
		}
	}
}