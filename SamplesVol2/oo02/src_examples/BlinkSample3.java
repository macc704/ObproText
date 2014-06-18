import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * 状態遷移（点滅）のサンプルプログラム その３（Enumバージョン）
 * 
 * @author gute
 * @date 2005/06/08 オブプロ第8回
 * @version 1.0
 */
public class BlinkSample3 {

	public static void main(String[] args) {
		BlinkSample3 blinkSample = new BlinkSample3();
		blinkSample.main();
	}

	final Color BLACK = new Color(0, 0, 0);

	BWindow window;

	void main() {
		openWindow();
		doAnimation();
	}

	// ウインドウを開く
	void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	BlinkRectangle3 rectangle;

	// アニメーションする
	void doAnimation() {
		// キャンバスを取得する
		BCanvas canvas = window.getCanvas();

		// オブジェクトを初期化する
		rectangle = new BlinkRectangle3(BLACK, 50, 50, 100, 50);

		// アニメーションする
		while (true) {
			// 入力により，点滅状態を変更する
			if (canvas.isKeyDown()) {
				int keyCode = canvas.getKeyCode();
				if (keyCode == 65) {// a
					rectangle.changeBlinkingState();
				}
			}

			// 1コマの処理を行う
			rectangle.processOneStep();

			{// 図形を描く
				canvas.clear();
				rectangle.draw(canvas);
				canvas.update();
			}

			// 眠る
			canvas.sleep(0.1);
		}
	}

}