import obpro.file.BFile;
import obpro.file.BFileWriter;

/*
 * ファイル出力のサンプルプログラム
 * このプログラムを動かすには、コンパイル時に同じフォルダに次のファイルが必要。
 * 
 * @author macchan
 * @version 1.0
 */
public class FileOutputTest {

	public static void main(String[] args) {
		FileOutputTest test = new FileOutputTest();
		test.run();
	}

	// ファイル書き出しのテスト
	void run() {
		// ファイルを用意する
		BFile file = new BFile("data/data.txt");

		{// ファイルへ書き出す
			// ストリームを開く
			BFileWriter writer = file.openWriter();

			// ストリームへ書き出す
			writer.println("テスト");

			// ストリームを閉じる
			writer.close();
		}
	}

}