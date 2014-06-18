import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * 四角形のアニメーション5(コンストラクタ　& フレームワークを意識したメソッド化)
 * 
 * @author macchan
 * @date 2005/06/02 オブプロ第７回
 * @version 1.0
 */
public class RectangleAnimation5 {

	public static void main(String[] args) {
		RectangleAnimation5 rectangleAnimation = new RectangleAnimation5();
		rectangleAnimation.main();
	}

	final Color BLACK = new Color(0, 0, 0);
	final Color RED = new Color(255, 0, 0);

	BWindow window;

	Rectangle rectangle1;
	Rectangle rectangle2;

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
		//前処理
		BCanvas canvas = window.getCanvas();//キャンバスを取得する		
		initializeObjects();//オブジェクトの初期化をする

		//アニメーションする
		while (true) {
			//図形を動かす
			move();

			//図形を描く
			canvas.clear();
			draw(canvas);
			canvas.update();

			//眠る
			canvas.sleep(0.1);
		}
	}

	//オブジェクトを初期化する
	void initializeObjects() {
		rectangle1 = new Rectangle(BLACK, 100, 100, 100, 100);
		rectangle2 = new Rectangle(RED, 300, 200, 50, 80);
	}

	//オブジェクトを動かす
	void move() {
		rectangle1.move(10, 10);
		rectangle2.move(5, 0);
	}

	//オブジェクトを描画する
	void draw(BCanvas canvas) {
		rectangle1.draw(canvas);
		rectangle2.draw(canvas);
	}

}