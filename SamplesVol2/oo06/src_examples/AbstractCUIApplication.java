/*
 * AbstractCUIApplication.java
 * Copyright(c) 2005 CreW Project. All rights reserved.
 */

/**
 * CUIアプリケーション　フレームワーク 
 * 抽象アプリケーションクラス（スーパークラス）
 * 
 * @author macchan
 * @version 1.0
 */
public class AbstractCUIApplication {

	/**
	 * アプリケーションの開始を知らせる
	 */
	public void showTitle() {
	}

	/**
	 * アプリケーションの終了を知らせる
	 */
	public void showEndTitle() {
	}

	/**
	 * データを初期化する
	 */
	public void initializeData() {
	}

	/**
	 * コマンドメニューを表示する
	 */
	public void showCommandMenu() {
	}

	/**
	 * 終了コマンドを取得する
	 */
	public String getQuitCommand() {
		return "q";
	}

	/**
	 * コマンドを実行する
	 */
	public void executeCommand(String command) {
	}

}