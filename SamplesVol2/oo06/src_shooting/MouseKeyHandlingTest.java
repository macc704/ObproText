import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * �}�E�X�ƃL�[�n���h�����O�̃e�X�g(�t���[�����[�N�Ή���)
 * 
 * @author macchan
 * @date 2005/07/7 �I�u�v����12��
 * @version 1.0
 */
public class MouseKeyHandlingTest extends AbstractGUIAnimationApplication {

	final Color BLACK = new Color(0, 0, 0);
	final int KEYEVENT_LABEL_X = 100;
	final int KEYEVENT_VALUE_X = 200;
	final int MOUSEEVENT_LABEL_X = 300;
	final int MOUSEEVENT_VALUE_X = 450;

	public static void main(String[] args) {
		GUIAnimationApplicationEngine game = new GUIAnimationApplicationEngine(
				new MouseKeyHandlingTest());
		game.run();
	}

	/**
	 * �}�`��`��
	 */
	public void drawForApplication(BCanvas canvas) {
		// �L�[�C�x���g�̏�Ԃ�\������
		String keyCode = Integer.toString(canvas.getKeyCode());
		canvas.drawText(BLACK, "keyCode", KEYEVENT_LABEL_X, 100);
		canvas.drawText(BLACK, keyCode, KEYEVENT_VALUE_X, 100);

		String isKeyDown = Boolean.toString(canvas.isKeyDown());
		canvas.drawText(BLACK, "isKeyDown", KEYEVENT_LABEL_X, 125);
		canvas.drawText(BLACK, isKeyDown, KEYEVENT_VALUE_X, 125);

		// �e�L�[�̏�Ԃ�\������
		int y = 0;
		for (int i = 0; i < 256; i++) {
			if (canvas.isKeyPressing(i)) {
				canvas.drawText(BLACK, "key " + i + " is Now Pressing",
						KEYEVENT_LABEL_X, 150 + y);
				y += 25;
			}
		}

		// �}�E�X�C�x���g�̏�Ԃ�\������
		String mousePoint = canvas.getMouseX() + "," + canvas.getMouseY();
		canvas.drawText(BLACK, "mousePoint", MOUSEEVENT_LABEL_X, 100);
		canvas.drawText(BLACK, mousePoint, MOUSEEVENT_VALUE_X, 100);

		String isMouseDown = Boolean.toString(canvas.isMouseDown());
		canvas.drawText(BLACK, "isMouseDown", MOUSEEVENT_LABEL_X, 125);
		canvas.drawText(BLACK, isMouseDown, MOUSEEVENT_VALUE_X, 125);

		String isLeftMouseDown = Boolean.toString(canvas.isLeftMouseDown());
		canvas.drawText(BLACK, "isLeftMouseDown", MOUSEEVENT_LABEL_X, 150);
		canvas.drawText(BLACK, isLeftMouseDown, MOUSEEVENT_VALUE_X, 150);

		String isRightMouseDown = Boolean.toString(canvas.isRightMouseDown());
		canvas.drawText(BLACK, "isRightMouseDown", MOUSEEVENT_LABEL_X, 175);
		canvas.drawText(BLACK, isRightMouseDown, MOUSEEVENT_VALUE_X, 175);

		String isClick = Boolean.toString(canvas.isClick());
		canvas.drawText(BLACK, "isClick", MOUSEEVENT_LABEL_X, 200);
		canvas.drawText(BLACK, isClick, MOUSEEVENT_VALUE_X, 200);

		String isDoubleClick = Boolean.toString(canvas.isDoubleClick());
		canvas.drawText(BLACK, "isDoubleClick", MOUSEEVENT_LABEL_X, 225);
		canvas.drawText(BLACK, isDoubleClick, MOUSEEVENT_VALUE_X, 225);

		String isDragging = Boolean.toString(canvas.isDragging());
		canvas.drawText(BLACK, "isDragging", MOUSEEVENT_LABEL_X, 250);
		canvas.drawText(BLACK, isDragging, MOUSEEVENT_VALUE_X, 250);
	}
}