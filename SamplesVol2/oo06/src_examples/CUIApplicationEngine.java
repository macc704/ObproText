import obpro.cui.Input;

/*
 * CUIApplicationEngine.java
 * Copyright(c) 2005 CreW Project. All rights reserved.
 */

/**
 * CUIアプリケーション　フレームワーク 
 * 実行エンジン
 * 
 * @author macchan
 * @version 1.0
 */
public class CUIApplicationEngine {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("起動には引数が必要です");
			return;
		}

		//アプリケーションを生成し，エンジンを起動する
		AbstractCUIApplication application = (AbstractCUIApplication) BReflection
				.createInstanceByName(args[0]);
		CUIApplicationEngine engine = new CUIApplicationEngine(application);
		engine.run();
	}

	//実行するアプリケーション
	private AbstractCUIApplication application;

	/**
	 * コンストラクタ
	 */
	private CUIApplicationEngine(AbstractCUIApplication application) {
		this.application = application;
	}

	//アプリケーションを実行する
	private void run() {
		//アプリケーションの開始を知らせる
		application.showTitle();

		//アプリケーションを実行する
		application.initializeData();
		executeProcessLoop();

		//アプリケーションの終了を知らせる
		application.showEndTitle();
	}

	//アプリケーションを実行する
	private void executeProcessLoop() {
		//アプリケーションを実行する
		while (true) {
			//コマンドの入力を受け取る
			String command = getCommand();

			//コマンドを実行する
			if (command.equals(application.getQuitCommand())) {
				break;
			} else {
				application.executeCommand(command);
			}
		}
	}

	//コマンド入力を受け取る
	private String getCommand() {
		//メニューを出力する
		application.showCommandMenu();

		//コマンドの入力を受け取る
		String command = Input.getString();
		return command;
	}

}