import java.util.ArrayList;
import java.util.List;

import obpro.cui.Input;

/*
 * SakubunApplication.java
 * Copyright(c) 2005 CreW Project. All rights reserved.
 */

/**
 * 作文さんアプリケーション
 * 
 * @author macchan
 * @date 2005/07/7 オブプロ第12回
 * @version 1.0
 */
public class SakubunApplication extends AbstractCUIApplication {

	private List<String> nouns = new ArrayList<String>();
	private List<String> verbs = new ArrayList<String>();

	// アプリケーションの開始を知らせる
	public void showTitle() {
		System.out.println("作文さん開始");
	}

	// アプリケーションの終了を知らせる
	public void showEndTitle() {
		System.out.println("作文さん終了");
	}

	// コマンドメニューを表示する
	public void showCommandMenu() {
		System.out.println("メニュー(1.名詞追加 2.動詞追加 3.作文 q.終了)");
	}

	// コマンドを実行する
	public void executeCommand(String command) {
		if (command.equals("1")) {
			addNoun();
		} else if (command.equals("2")) {
			addVerb();
		} else if (command.equals("3")) {
			makeSentence();
		} else {
			System.out.println("無効なコマンドです");
		}
	}

	// 名詞を追加する
	private void addNoun() {
		System.out.println("名詞を入力してください");
		String noun = Input.getString();
		nouns.add(noun);
		System.out.println("名詞" + noun + "を追加しました");
	}

	// 動詞を追加する
	private void addVerb() {
		System.out.println("動詞を入力してください");
		String verb = Input.getString();
		verbs.add(verb);
		System.out.println("動詞" + verb + "を追加しました");
	}

	// 作文する
	private void makeSentence() {
		// 語句を選ぶ
		String noun = (String) nouns.get((int) (Math.random() * nouns.size()));
		String verb = (String) verbs.get((int) (Math.random() * verbs.size()));

		// 結果を表示する
		System.out.println(noun + "は" + verb);
	}

}