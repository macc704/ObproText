import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * 四角形のアニメーション2(メソッド化)
 * 
 * @author macchan
 * @date 2005/06/02 オブプロ第７回
 * @version 1.0
 */
public class RectangleAnimation2 {

	public static void main(String[] args) {
		RectangleAnimation2 rectangleAnimation = new RectangleAnimation2();
		rectangleAnimation.main();
	}

	final Color BLACK = new Color(0, 0, 0);
	final Color RED = new Color(255, 0, 0);

	BWindow window;

	void main() {
		openWindow();
		doAnimation();
	}

	//ウインドウを開く
	void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	//アニメーションする
	void doAnimation() {
		//キャンバスを取得する
		BCanvas canvas = window.getCanvas();

		//四角形1のデータを初期化する
		int x1 = 100;
		int y1 = 100;
		int w1 = 100;
		int h1 = 100;

		//四角形2のデータを初期化する
		int x2 = 300;
		int y2 = 200;
		int w2 = 50;
		int h2 = 80;

		//アニメーションする
		while (true) {
			{//図形を動かす
				//四角形1
				x1 = x1 + 10;
				y1 = y1 + 10;

				//四角形2
				x2 = x2 + 5;
			}

			{//図形を描く
				//キャンバスをクリアする
				canvas.clear();

				//図形を描く
				drawRectangle(canvas, BLACK, x1, y1, w1, h1);
				drawRectangle(canvas, RED, x2, y2, w2, h2);

				//キャンバスを更新する
				canvas.update();
			}

			//眠る
			canvas.sleep(0.1);
		}
	}

	//四角形を書く
	void drawRectangle(BCanvas canvas, Color color, int x1, int y1, int w1,
			int h1) {
		canvas.drawLine(color, x1, y1, x1 + w1, y1);
		canvas.drawLine(color, x1 + w1, y1, x1 + w1, y1 + h1);
		canvas.drawLine(color, x1 + w1, y1 + h1, x1, y1 + h1);
		canvas.drawLine(color, x1, y1 + h1, x1, y1);
	}

}