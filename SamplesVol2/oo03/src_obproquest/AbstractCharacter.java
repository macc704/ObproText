/** 
 * 抽象的な「キャラクター」を表現するクラス
 * 
 * @author macchan
 * @version 1.0
 */
public class AbstractCharacter {

	//定数
	private final int ALIVE = 1;
	private final int DEAD = 2;

	//属性
	private String name;
	private int power;
	private int maxHP;
	private int HP;
	private int maxMP;
	private int MP;

	//状態
	private int liveState = ALIVE;

	/**
	 * コンストラクタ
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
	 * HPを回復する
	 */
	public void refreshHP() {
		this.HP = this.maxHP;
	}

	/**
	 * MPを回復する
	 */
	public void refreshMP() {
		this.MP = this.maxMP;
	}

	/**
	 * HPを減少させる
	 */
	public void reduceHP(int reduceHP) {
		HP = HP - reduceHP;
		if (HP <= 0) {
			HP = 0;
			this.liveState = DEAD;
		}
	}

	/**
	 * MPを減少させる
	 */
	public void reduceMP(int reduceMP) {
		MP = MP - reduceMP;
	}

	/**
	 * いきているか調べる
	 */
	public boolean isALive() {
		return liveState == ALIVE;
	}

	/**
	 * 状態を表示する
	 */
	public void display() {
		System.out.println("「" + getName() + "」" + "\tHP:" + getHPString()
				+ "/" + getMaxHP() + "\tMP:" + getMP() + "/" + getMaxMP());
	}

	/**
	 * HPの文字列表現を取得する
	 */
	private String getHPString() {
		if (HP > 0) {
			return Integer.toString(HP);
		} else {
			return "しぼう";
		}
	}

	//--- 以下Getter & Setter ---
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