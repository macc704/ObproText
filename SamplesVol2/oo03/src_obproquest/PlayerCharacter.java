import obpro.cui.Input;

/**
 * PlayerCharacter.java
 * プレイヤーを表現するクラス
 * 
 * @author macchan
 * @version 1.0
 */
public class PlayerCharacter extends AbstractCharacter {

	private final int HEAL_CONSUME_MP = 5;
	private final int POWERUP_CONSUME_MP = 10;

	/**
	 * コンストラクタ
	 */
	public PlayerCharacter(String name, int maxHP, int maxMP, int power) {
		super(name, maxHP, maxMP, power);
	}

	/**
	 * １ターンの処理をする
	 */
	public void processTurn(EnemyCharacter enemy) {
		if (isALive()) {
			//コマンドを選ぶ
			System.out.println(getName() + "のターン 1.こうげき 2.回復 3.パワーアップ");
			System.out.print(">>");
			System.out.flush();
			String command = Input.getString();

			//コマンドを実行する
			if ("1".equals(command)) {
				attack(enemy);
			} else if ("2".equals(command)) {
				heal();
			} else if ("3".equals(command)) {
				upPower();
			} else {
				System.out.println("無効なコマンドです");
			}
		}
	}

	/**
	 * 攻撃する
	 */
	private void attack(EnemyCharacter enemy) {
		System.out.println(getName() + "の攻撃！");
		int attackPoint = (int) (Math.random() * 10) + getPower();
		enemy.reduceHP(attackPoint);
		System.out.println(enemy.getName() + "に" + attackPoint + "のダメージを与えた");
	}

	/**
	 * 回復する
	 */
	private void heal() {
		if (getMP() >= HEAL_CONSUME_MP) {
			super.refreshHP();
			super.reduceMP(HEAL_CONSUME_MP);
			System.out.println(getName() + "はHPを回復した");
		} else {
			System.out.println("MPが足りません");
		}
	}

	/**
	 * パワーアップする
	 */
	private void upPower() {
		if (getMP() >= POWERUP_CONSUME_MP) {
			super.setPower(getPower() * 2);
			super.reduceMP(POWERUP_CONSUME_MP);
			System.out.println(getName() + "のちからが上がった");
		} else {
			System.out.println("MPが足りません");
		}
	}
}