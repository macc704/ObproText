import java.util.ArrayList;

import obpro.common.BConverter;
import obpro.file.BFile;
import obpro.file.BFileReader;
import obpro.file.BFileWriter;

/*
 * 複数データ入出力のサンプルプログラム（その２　カンマ区切り）
 * このプログラムを動かすには、BFileライブラリが必要。
 *
 * @author macchan
 * @version 1.0
 */
public class MultiDataFileIOTest2 {

	public static void main(String[] args) {
		MultiDataFileIOTest2 test = new MultiDataFileIOTest2();
		test.run(args);
	}

	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Integer> scores = new ArrayList<Integer>();

	// ファイル読み書きのテスト
	void run(String[] args) {
		addData("中居", 50);
		addData("木村", 80);
		addData("稲垣", 90);
		addData("香取", 35);
		output();
		input();
	}

	void addData(String name, int score) {
		names.add(name);
		scores.add(score);
	}

	// 書き出す
	void output() {
		// ファイルを用意する
		BFile file = new BFile("data/data.csv");

		{// ファイルへ書き出す
			// ストリームを開く
			BFileWriter writer = file.openWriter();

			// ストリームへ書き出す
			for (int i = 0; i < names.size(); i++) {
				writer.print(names.get(i));
				writer.print(",");
				writer.print(BConverter.intToString(scores.get(i)));
				writer.println();
			}

			// ストリームを閉じる
			writer.close();
		}
	}

	// 読み込む
	@SuppressWarnings("unchecked")
	void input() {
		// ファイルを用意する
		BFile file = new BFile("data/data.csv");

		{// ファイルを読み込む
			// ストリームを開く
			BFileReader reader = file.openReader();

			// ストリームから読み込む
			while (!reader.isEndOfFile()) {
				String line = reader.readLine();
				ArrayList<String> tokens = BConverter.split(line, ",");
				names.add(tokens.get(0));
				scores.add(BConverter.stringToInt(tokens.get(1)));
			}

			// ストリームを閉じる
			reader.close();
		}
	}
}