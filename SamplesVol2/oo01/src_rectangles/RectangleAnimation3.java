import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * 四角形のアニメーション3(データオブジェクト)
 * 
 * @author macchan
 * @date 2005/06/02 オブプロ第７回
 * @version 1.0
 */
public class RectangleAnimation3 {

	public static void main(String[] args) {
		RectangleAnimation3 rectangleAnimation = new RectangleAnimation3();
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
		RectangleData rectangle1 = new RectangleData();
		rectangle1.color = BLACK;
		rectangle1.x = 100;
		rectangle1.y = 100;
		rectangle1.width = 100;
		rectangle1.height = 100;

		//四角形2のデータを初期化する
		RectangleData rectangle2 = new RectangleData();
		rectangle2.color = RED;
		rectangle2.x = 300;
		rectangle2.y = 200;
		rectangle2.width = 50;
		rectangle2.height = 80;

		//アニメーションする
		while (true) {
			{//図形を動かす
				//四角形1
				rectangle1.x = rectangle1.x + 10;
				rectangle1.y = rectangle1.y + 10;

				//四角形2
				rectangle2.x = rectangle2.x + 5;
			}

			{//図形を描く
				//キャンバスをクリアする
				canvas.clear();

				//図形を描く
				drawRectangle(canvas, rectangle1);
				drawRectangle(canvas, rectangle2);

				//キャンバスを更新する
				canvas.update();
			}

			//眠る
			canvas.sleep(0.1);
		}
	}

	//四角形を書く
	void drawRectangle(BCanvas canvas, RectangleData r) {
		canvas.drawLine(r.color, r.x, r.y, r.x + r.width, r.y);
		canvas.drawLine(r.color, r.x + r.width, r.y, r.x + r.width, r.y
				+ r.height);
		canvas.drawLine(r.color, r.x + r.width, r.y + r.height, r.x, r.y
				+ r.height);
		canvas.drawLine(r.color, r.x, r.y + r.height, r.x, r.y);
	}
}