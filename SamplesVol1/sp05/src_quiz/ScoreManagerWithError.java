import java.util.HashMap;

import obpro.cui.Input;

/**
 * 成績管理するアプリケーション
 * （デバッグ問題, 問題は2種類ある）
 * （不正な文字入力のエラー処理はしなくて良いものとする)
 * 
 * 下記のコマンドにより成績を管理できる
 * ・成績の追加（コマンド：add）
 * ・成績の削除（コマンド：del）
 * ・成績の検索（コマンド：search）
 * ・成績一覧と平均表示（コマンド：show）
 * 
 * @author Masahiro Kawamura
 * @version $Id: ScoreManagerWithError.java,v 1.2 2007/05/24 12:21:33 macchan Exp $
 */
public class ScoreManagerWithError {

	public static void main(String[] args) {
		ScoreManagerWithError scoreManager = new ScoreManagerWithError();
		scoreManager.main();
	}

	final int NULL_INDEX = -1;

	final String ADD = "add";
	final String DELETE = "del";
	final String SEARCH = "search";
	final String SHOW = "show";
	final String QUIT = "quit";

	//成績データ(グローバル)
	HashMap<String, Integer> scores;

	//成績を管理する
	void main() {
		//アプリケーションの開始を知らせる
		System.out.println("★★★★★★成績管理アプリケーション★★★★★★");

		//成績を管理する
		initializeData();
		manageScores();

		//アプリケーションの終了を知らせる
		System.out.println("アプリケーションを終了します。");
	}

	//データを初期化する
	void initializeData() {
		scores = new HashMap<String, Integer>();
	}

	//成績を管理する
	void manageScores() {
		//成績を管理する
		while (true) {
			//コマンドの入力を受け取る
			String command = getCommand();

			//コマンドを実行する
			if (command == ADD) {
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
	String getCommand() {
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
	void addScore() {
		//成績の入力を受け取る
		System.out.println("名前を入力してください");
		String name = Input.getString();
		System.out.println("成績を入力してください");
		int score = Input.getInt();

		//成績を追加する
		scores.put(name, score);

		//追加結果を出力する
		System.out.println("成績を登録しました");
	}

	void deleteScore() {
		//削除対象の入力を受け取る
		System.out.println("削除する成績の名前を入力してください");
		String name = Input.getString();

		//成績を削除する
		scores.remove(name);

		//削除結果を出力する
		System.out.println("成績を削除しました");
	}

	//検索する
	void searchScore() {
		//検索対象の入力を受け取る
		System.out.println("検索する成績の名前を入力してください");
		String name = Input.getString();

		//検索する

		//検索結果を出力する
		System.out.println(name + "さんの点数は" + scores.get(name) + "点です");
	}

	//成績一覧と平均点を表示する	 
	void showScoreList() {
		//成績一覧を表示する
		System.out.println("★★★★★★成績一覧表★★★★★★");
		for (String key : scores.keySet()) {
			System.out.println(key + "さん" + scores.get(key) + "点");
		}

		//平均点を表示する
		System.out.println("★★★★★★平均点★★★★★★");
		double average = getAverageScore();
		System.out.println("平均点：" + average + "点");
	}

	//平均点を計算する
	double getAverageScore() {
		//合計点を計算する
		double total = 0d;
		for (int i = 0; i < scores.size(); i++) {
			total = total + scores.get(i);
		}

		//平均点を計算する
		double average = total / scores.size();

		return average;
	}

}