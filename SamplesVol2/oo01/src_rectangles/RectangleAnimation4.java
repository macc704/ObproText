import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * 四角形のアニメーション4(カプセル化)
 * 
 * @author macchan
 * @date 2005/06/02 オブプロ第７回
 * @version 1.0
 */
public class RectangleAnimation4 {

	public static void main(String[] args) {
		RectangleAnimation4 rectangleAnimation = new RectangleAnimation4();
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
		CapsuledRectangle rectangle1 = new CapsuledRectangle();
		rectangle1.initialize(BLACK, 100, 100, 100, 100);

		//四角形2のデータを初期化する
		CapsuledRectangle rectangle2 = new CapsuledRectangle();
		rectangle2.initialize(RED, 300, 200, 50, 80);

		//アニメーションする
		while (true) {
			//図形を動かす
			rectangle1.move(10, 10);
			rectangle2.move(5, 0);

			{//図形を描く
				//キャンバスをクリアする
				canvas.clear();

				//図形を描く
				rectangle1.draw(canvas);
				rectangle2.draw(canvas);

				//キャンバスを更新する
				canvas.update();
			}

			//眠る
			canvas.sleep(0.1);
		}
	}
}