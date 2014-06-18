/**
 * 成績管理するアプリケーション（オブジェクト指向　その2)
 * （配列の隠蔽，リスト導入）
 * (エラー処理なし)
 * 
 * 下記のコマンドにより成績を管理できる
 * ・成績の追加（コマンド：add）
 * ・成績の削除（コマンド：del）
 * ・成績の検索（コマンド：search）
 * ・成績一覧と平均表示（コマンド：show）
 * 
 * @author Yoshiaki Matsuzawa
 * @version 1.0
 */
public class ScoreManagerOO2 {

	public static void main(String[] args) {
		ScoreManagerOO2 scoreManager = new ScoreManagerOO2();
		scoreManager.main();
	}

	// 定数
	final int NULL_INDEX = -1; // 添字未定を表現する数

	final String ADD = "add";
	final String DELETE = "del";
	final String SEARCH = "search";
	final String SHOW = "show";
	final String QUIT = "quit";

	//成績データ
	private ScoreList scoreList;

	//成績を管理する
	private void main() {
		//アプリケーションの開始を知らせる
		System.out.println("★★★★★★成績管理アプリケーション★★★★★★");

		//成績を管理する
		initializeData();
		manageScores();

		//アプリケーションの終了を知らせる
		System.out.println("アプリケーションを終了します。");
	}

	//データを初期化する
	private void initializeData() {
		scoreList = new ScoreList();
	}

	//成績を管理する
	private void manageScores() {
		//成績を管理する
		while (true) {
			//コマンドの入力を受け取る
			String command = getCommand();

			//コマンドを実行する
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
				System.out.println("そのようなコマンドはありません");
			}
		}
	}

	//コマンド入力を受け取る
	private String getCommand() {
		//メニューを出力する
		System.out.print("コマンドを入力してください");
		System.out.print("(" + ADD + ":成績の追加");
		System.out.print(", " + DELETE + ":成績の削除");
		System.out.print(", " + SEARCH + ":成績の検索");
		System.out.print(", " + SHOW + ":成績一覧と平均点の表示");
		System.out.print(", " + QUIT + ":終了" + ")");
		System.out.println();

		//コマンドの入力を受け取る
		String command = Input.getString();
		return command;
	}

	//成績を追加する
	private void addScore() {
		//成績の入力を受け取る
		System.out.println("名前を入力してください");
		String name = Input.getString();
		System.out.println("成績を入力してください");
		int score = Input.getInt();

		//成績を追加する
		scoreList.add(new Score(score, name));

		//追加結果を出力する
		System.out.println("成績を登録しました");
	}

	private void deleteScore() {
		//削除対象の入力を受け取る
		System.out.println("削除する成績の名前を入力してください");
		String name = Input.getString();

		//成績を削除する
		int deleteIndex = searchScoreIndexByName(name);
		scoreList.remove(deleteIndex);

		//削除結果を出力する
		System.out.println("成績を削除しました");
	}

	//検索する
	private void searchScore() {
		//検索対象の入力を受け取る
		System.out.println("検索する成績の名前を入力してください");
		String name = Input.getString();

		//検索する
		int searchIndex = searchScoreIndexByName(name);

		//検索結果を出力する		
		Score score = scoreList.getScore(searchIndex);
		System.out.println(score.getName() + "さんの点数は" + score.getScore()
				+ "点です");
	}

	//名前をキーに成績を検索する
	private int searchScoreIndexByName(String name) {
		for (int i = 0; i < scoreList.getSize(); i++) {
			if (scoreList.getScore(i).getName().equals(name)) {
				return i;
			}
		}
		return NULL_INDEX;
	}

	//成績一覧と平均点を表示する	 
	private void showScoreList() {
		//成績一覧を表示する
		System.out.println("★★★★★★成績一覧表★★★★★★");
		for (int i = 0; i < scoreList.getSize(); i++) {
			Score score = scoreList.getScore(i);
			System.out.println(score.getName() + "さん" + score.getScore() + "点");
		}

		//平均点を表示する
		System.out.println("★★★★★★平均点★★★★★★");
		double average = getAverageScore();
		System.out.println("平均点：" + average + "点");
	}

	//平均点を計算する
	private double getAverageScore() {
		//合計点を計算する
		double total = 0d;
		for (int i = 0; i < scoreList.getSize(); i++) {
			total = total + scoreList.getScore(i).getScore();
		}

		//平均点を計算する
		double average = total / scoreList.getSize();

		return average;
	}

}