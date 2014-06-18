/** 
 * ���ۓI�ȁu�L�����N�^�[�v��\������N���X
 * 
 * @author macchan
 * @version 1.0
 */
public class AbstractCharacter {

	//�萔
	private final int ALIVE = 1;
	private final int DEAD = 2;

	//����
	private String name;
	private int power;
	private int maxHP;
	private int HP;
	private int maxMP;
	private int MP;

	//���
	private int liveState = ALIVE;

	/**
	 * �R���X�g���N�^
	 */
	public AbstractCharacter(String name, int maxHP, int maxMP, int power) {
		this.name = name;
		this.maxHP = maxHP;
		this.maxMP = maxMP;
		this.power = power;

		refreshHP();
		refreshMP();
	}

	/**
	 * HP���񕜂���
	 */
	public void refreshHP() {
		this.HP = this.maxHP;
	}

	/**
	 * MP���񕜂���
	 */
	public void refreshMP() {
		this.MP = this.maxMP;
	}

	/**
	 * HP������������
	 */
	public void reduceHP(int reduceHP) {
		HP = HP - reduceHP;
		if (HP <= 0) {
			HP = 0;
			this.liveState = DEAD;
		}
	}

	/**
	 * MP������������
	 */
	public void reduceMP(int reduceMP) {
		MP = MP - reduceMP;
	}

	/**
	 * �����Ă��邩���ׂ�
	 */
	public boolean isALive() {
		return liveState == ALIVE;
	}

	/**
	 * ��Ԃ�\������
	 */
	public void display() {
		System.out.println("�u" + getName() + "�v" + "\tHP:" + getHPString()
				+ "/" + getMaxHP() + "\tMP:" + getMP() + "/" + getMaxMP());
	}

	/**
	 * HP�̕�����\�����擾����
	 */
	private String getHPString() {
		if (HP > 0) {
			return Integer.toString(HP);
		} else {
			return "���ڂ�";
		}
	}

	//--- �ȉ�Getter & Setter ---
	public int getMaxHP() {
		return this.maxHP;
	}
	public int getMaxMP() {
		return this.maxMP;
	}
	public int getHP() {
		return this.HP;
	}
	public int getMP() {
		return this.MP;
	}
	public String getName() {
		return name;
	}
	public void setLiveState(int liveState) {
		this.liveState = liveState;
	}
	public int getPower() {
		return this.power;
	}
	public void setPower(int power) {
		this.power = power;
	}
}