import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * GUI例題プログラム2
 * アニメーションの方法2(動かす)
 * 
 * @author macchan
 * @date 2005/06/02 オブプロ第７回　2006/05/21改訂
 * @version 1.0
 */
public class GUISample2 {

	public static void main(String[] args) {
		GUISample2 sample = new GUISample2();
		sample.main();
	}

	//色の定数(色クラスを使うためにはimport文が必要)
	final Color BLACK = new Color(0, 0, 0);
	final Color RED = new Color(255, 0, 0);
	final Color GREEN = new Color(0, 255, 0);
	final Color BLUE = new Color(0, 0, 255);

	void main() {
		BWindow window;

		{// ウインドウを開く
			// ウインドウを生成する
			window = new BWindow();

			// 位置と大きさを決める
			window.setLocation(100, 100);
			window.setSize(640, 480);

			// ウインドウを開く
			window.show();
		}

		{// アニメーションをする
			// キャンバスを取得する
			BCanvas canvas = window.getCanvas();

			// アニメーションをする
			int arcX = 0;
			while (true) {
				// 図形を動かす
				arcX = arcX + 10;

				{// 図形を描く
					// キャンバスをクリアする
					canvas.clear();

					// 図形を描く
					canvas.drawLine(BLACK, 100, 100, 200, 200);// 線
					canvas
							.drawFillTriangle(BLUE, arcX, 300, 300, 350, 350,
									300);// 塗りつぶし三角形
					canvas.drawArc(RED, arcX, 100, 200, 200, 0, 180);// 円弧
					canvas.drawFillArc(GREEN, arcX, 100, 200, 200, 0, 360);// 塗りつぶし円弧

					// キャンバスを更新する
					canvas.update();
				}

				// 眠る
				canvas.sleep(0.1);
			}
		}
	}

}