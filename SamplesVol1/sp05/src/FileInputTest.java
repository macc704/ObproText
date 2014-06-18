import java.util.ArrayList;

import obpro.file.BFile;
import obpro.file.BFileReader;

/*
 * ファイル入力のサンプルプログラム
 * このプログラムを動かすには、コンパイル時に同じフォルダに次のファイルが必要。
 * 
 * @author macchan
 * @version 1.0
 */
public class FileInputTest {

	public static void main(String[] args) {
		FileInputTest test = new FileInputTest();
		test.run();
	}

	// ファイル読み込みのテスト
	// 読み込んで表示する
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void run() {
		// ファイルを用意する
		BFile file = new BFile("data/data.txt");
		ArrayList inputStrings = new ArrayList();

		{// ファイルを読み込む
			// ストリームを開く
			BFileReader reader = file.openReader();

			// ストリームから読み込む
			for (int i = 0; !reader.isEndOfFile(); i++) {
				inputStrings.add(i, reader.readLine());
			}

			// ストリームを閉じる
			reader.close();
		}

		// 表示する
		for (int i = 0; i < inputStrings.size(); i++) {
			System.out.println(inputStrings.get(i));
		}
	}
}