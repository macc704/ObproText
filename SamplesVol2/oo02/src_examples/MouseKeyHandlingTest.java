import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * マウスとキーハンドリングのテスト
 * 
 * @author macchan
 * @date 2005/06/08 オブプロ第8回 2006/05/26修正
 * @version 1.0
 */
public class MouseKeyHandlingTest {

	public static void main(String[] args) {
		MouseKeyHandlingTest test = new MouseKeyHandlingTest();
		test.main();
	}

	final Color BLACK = new Color(0, 0, 0);
	final int KEYEVENT_LABEL_X = 100;
	final int KEYEVENT_VALUE_X = 200;
	final int MOUSEEVENT_LABEL_X = 300;
	final int MOUSEEVENT_VALUE_X = 450;

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

	// アニメーションする
	void doAnimation() {
		// キャンバスを取得する
		BCanvas canvas = window.getCanvas();

		// アニメーションする
		while (true) {
			{// 図形を描く
				canvas.clear();
				draw(canvas);
				canvas.update();
			}

			// 眠る
			canvas.sleep(0.1);
		}
	}

	/**
	 * 図形を描く
	 */
	void draw(BCanvas canvas) {
		// クリックされたキーの状態を表示する
		String keyCode = Integer.toString(canvas.getKeyCode());
		canvas.drawText(BLACK, "keyCode", KEYEVENT_LABEL_X, 100);
		canvas.drawText(BLACK, keyCode, KEYEVENT_VALUE_X, 100);

		String isKeyDown = Boolean.toString(canvas.isKeyDown());
		canvas.drawText(BLACK, "isKeyDown", KEYEVENT_LABEL_X, 125);
		canvas.drawText(BLACK, isKeyDown, KEYEVENT_VALUE_X, 125);

		// 押されているキーを表示する
		int y = 0;
		for (int i = 0; i < 256; i++) {
			if (canvas.isKeyPressing(i)) {
				canvas.drawText(BLACK, "key " + i + " is Now Pressing",
						KEYEVENT_LABEL_X, 150 + y);
				y += 25;
			}
		}

		{// マウスイベントの状態を表示する
			// マウスの位置
			String mousePoint = canvas.getMouseX() + "," + canvas.getMouseY();
			canvas.drawText(BLACK, "mousePoint", MOUSEEVENT_LABEL_X, 100);
			canvas.drawText(BLACK, mousePoint, MOUSEEVENT_VALUE_X, 100);

			// （いずれかのの）マウスボタンが押されているか
			String isMouseDown = Boolean.toString(canvas.isMouseDown());
			canvas.drawText(BLACK, "isMouseDown", MOUSEEVENT_LABEL_X, 125);
			canvas.drawText(BLACK, isMouseDown, MOUSEEVENT_VALUE_X, 125);

			// 左マウスボタンが押されているか
			String isLeftMouseDown = Boolean.toString(canvas.isLeftMouseDown());
			canvas.drawText(BLACK, "isLeftMouseDown", MOUSEEVENT_LABEL_X, 150);
			canvas.drawText(BLACK, isLeftMouseDown, MOUSEEVENT_VALUE_X, 150);

			// 右マウスボタンが押されているか
			String isRightMouseDown = Boolean.toString(canvas
					.isRightMouseDown());
			canvas.drawText(BLACK, "isRightMouseDown", MOUSEEVENT_LABEL_X, 175);
			canvas.drawText(BLACK, isRightMouseDown, MOUSEEVENT_VALUE_X, 175);

			// マウスがクリックされたか
			String isClick = Boolean.toString(canvas.isClick());
			canvas.drawText(BLACK, "isClick", MOUSEEVENT_LABEL_X, 200);
			canvas.drawText(BLACK, isClick, MOUSEEVENT_VALUE_X, 200);

			// マウスがシングルクリックがされたか
			String isSingleClick = Boolean.toString(canvas.isSingleClick());
			canvas.drawText(BLACK, "isSingleClick", MOUSEEVENT_LABEL_X, 225);
			canvas.drawText(BLACK, isSingleClick, MOUSEEVENT_VALUE_X, 225);

			// マウスがダブルクリックされたか
			String isDoubleClick = Boolean.toString(canvas.isDoubleClick());
			canvas.drawText(BLACK, "isDoubleClick", MOUSEEVENT_LABEL_X, 250);
			canvas.drawText(BLACK, isDoubleClick, MOUSEEVENT_VALUE_X, 250);

			// マウスがドラッグ中か
			String isDragging = Boolean.toString(canvas.isDragging());
			canvas.drawText(BLACK, "isDragging", MOUSEEVENT_LABEL_X, 275);
			canvas.drawText(BLACK, isDragging, MOUSEEVENT_VALUE_X, 275);
		}
	}
}