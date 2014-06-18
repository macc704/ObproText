/**
 * EnemyCharacter.java
 * プレイヤーを表現するクラス
 * 
 * @author macchan
 * @version 1.0
 */
public class EnemyCharacter extends AbstractCharacter {

	/**
	 * コンストラクタ
	 */
	public EnemyCharacter(String name, int maxHP, int maxMP, int power) {
		super(name, maxHP, maxMP, power);
	}

	/**
	 * １ターンの処理をする
	 */
	public void processTurn(PlayerCharacter[] players) {
		int targetPlayerIndex = (int) (Math.random() * (double) players.length);
		attack(players[targetPlayerIndex]);
	}

	/**
	 * 攻撃する
	 */
	public void attack(PlayerCharacter player) {
		if (player.isALive()) {
			//攻撃
			System.out.println("ボスの攻撃");
			int attackPoint = (int) (getPower() * Math.random() * 10);
			player.reduceHP(attackPoint);

			//結果報告
			System.out.println(player.getName() + "は" + attackPoint
					+ "のダメージを受けた");
			if (!player.isALive()) {
				System.out.println(player.getName() + "はちからつきた");
			}
		} else {
			System.out.println(getName() + "は" + player.getName()
					+ "に攻撃しようとしたが，すでにしんでいた");
		}
	}

}