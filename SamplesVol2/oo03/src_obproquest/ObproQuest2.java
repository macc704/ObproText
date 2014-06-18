import obpro.cui.Input;

/**
 * ObproQuest.java
 * オブプロクエスト2
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

	//ゲームをする
	private void main() {
		//アプリケーションの開始を知らせる
		System.out.println("☆オブプロクエスト2☆");
		System.out.print("\n\n\n");

		//初期化する
		initialize();

		//敵と戦う
		System.out.println(enemy.getName() + "があらわれた");
		while (true) {
			//現在の状況を出力する
			display();

			//味方ターンの処理をする
			if (!isAllPlayersDead()) {
				for (int i = 0; i < players.length && enemy.isALive(); i++) {
					players[i].processTurn(enemy);
				}
			} else {
				System.out.println("全滅しました");
				break;
			}

			//敵ターンの処理をする			
			if (enemy.isALive()) {
				enemy.processTurn(players);
			} else {
				System.out.println(enemy.getName() + "を倒した!");
				break;
			}
		}

		//アプリケーションの終了を知らせる
		System.out.print("\n\n\n");
		System.out.println("ゲームオーバー");
	}

	/**
	 * 初期化する	 
	 */
	private void initialize() {
		createPlayer(0, 100, 25, 15);
		createPlayer(1, 100, 10, 20);
		createPlayer(2, 100, 5, 35);
		enemy = new EnemyCharacter("竜王", 400, 0, 30);
	}

	/**
	 * 一人のプレイヤーを作成する
	 */
	private void createPlayer(int i, int maxHP, int maxMP, int power) {
		System.out.println((i + 1) + "番目の勇者の名前を入力してください");
		String name = Input.getString();
		players[i] = new PlayerCharacter(name, maxHP, maxMP, power);
	}

	/**
	 * すべてのプレイヤーが死んでしまったかどうか調べる
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
	 * 現在の状況を出力する	 
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