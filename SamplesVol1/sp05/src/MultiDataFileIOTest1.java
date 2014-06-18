import java.util.ArrayList;

import obpro.common.BConverter;
import obpro.file.BFile;
import obpro.file.BFileReader;
import obpro.file.BFileWriter;

/*
 * 複数データ入出力のサンプルプログラム（その１ 行区切りフォーマット） 
 * このプログラムを動かすには、BFileライブラリが必要。
 * 
 * @author macchan
 * @version 1.0
 */
public class MultiDataFileIOTest1 {

	public static void main(String[] args) {
		MultiDataFileIOTest1 test = new MultiDataFileIOTest1();
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
		BFile file = new BFile("data/data.txt");

		{// ファイルへ書き出す
			// ストリームを開く
			BFileWriter writer = file.openWriter();

			// ストリームへ書き出す
			for (int i = 0; i < names.size(); i++) {
				writer.println(names.get(i));
				writer.println(BConverter.intToString(scores.get(i)));
			}

			// ストリームを閉じる
			writer.close();
		}
	}

	// 読み込む
	void input() {
		// ファイルを用意する
		BFile file = new BFile("data/data.txt");

		{// ファイルを読み込む
			// ストリームを開く
			BFileReader reader = file.openReader();

			// ストリームから読み込む
			while (!reader.isEndOfFile()) {
				names.add(reader.readLine());
				scores.add(BConverter.stringToInt(reader.readLine()));
			}

			// ストリームを閉じる
			reader.close();
		}
	}

}