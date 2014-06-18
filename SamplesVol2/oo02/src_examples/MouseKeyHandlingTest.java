import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * �}�E�X�ƃL�[�n���h�����O�̃e�X�g
 * 
 * @author macchan
 * @date 2005/06/08 �I�u�v����8�� 2006/05/26�C��
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

	// �E�C���h�E���J��
	void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	// �A�j���[�V��������
	void doAnimation() {
		// �L�����o�X���擾����
		BCanvas canvas = window.getCanvas();

		// �A�j���[�V��������
		while (true) {
			{// �}�`��`��
				canvas.clear();
				draw(canvas);
				canvas.update();
			}

			// ����
			canvas.sleep(0.1);
		}
	}

	/**
	 * �}�`��`��
	 */
	void draw(BCanvas canvas) {
		// �N���b�N���ꂽ�L�[�̏�Ԃ�\������
		String keyCode = Integer.toString(canvas.getKeyCode());
		canvas.drawText(BLACK, "keyCode", KEYEVENT_LABEL_X, 100);
		canvas.drawText(BLACK, keyCode, KEYEVENT_VALUE_X, 100);

		String isKeyDown = Boolean.toString(canvas.isKeyDown());
		canvas.drawText(BLACK, "isKeyDown", KEYEVENT_LABEL_X, 125);
		canvas.drawText(BLACK, isKeyDown, KEYEVENT_VALUE_X, 125);

		// ������Ă���L�[��\������
		int y = 0;
		for (int i = 0; i < 256; i++) {
			if (canvas.isKeyPressing(i)) {
				canvas.drawText(BLACK, "key " + i + " is Now Pressing",
						KEYEVENT_LABEL_X, 150 + y);
				y += 25;
			}
		}

		{// �}�E�X�C�x���g�̏�Ԃ�\������
			// �}�E�X�̈ʒu
			String mousePoint = canvas.getMouseX() + "," + canvas.getMouseY();
			canvas.drawText(BLACK, "mousePoint", MOUSEEVENT_LABEL_X, 100);
			canvas.drawText(BLACK, mousePoint, MOUSEEVENT_VALUE_X, 100);

			// �i�����ꂩ�̂́j�}�E�X�{�^����������Ă��邩
			String isMouseDown = Boolean.toString(canvas.isMouseDown());
			canvas.drawText(BLACK, "isMouseDown", MOUSEEVENT_LABEL_X, 125);
			canvas.drawText(BLACK, isMouseDown, MOUSEEVENT_VALUE_X, 125);

			// ���}�E�X�{�^����������Ă��邩
			String isLeftMouseDown = Boolean.toString(canvas.isLeftMouseDown());
			canvas.drawText(BLACK, "isLeftMouseDown", MOUSEEVENT_LABEL_X, 150);
			canvas.drawText(BLACK, isLeftMouseDown, MOUSEEVENT_VALUE_X, 150);

			// �E�}�E�X�{�^����������Ă��邩
			String isRightMouseDown = Boolean.toString(canvas
					.isRightMouseDown());
			canvas.drawText(BLACK, "isRightMouseDown", MOUSEEVENT_LABEL_X, 175);
			canvas.drawText(BLACK, isRightMouseDown, MOUSEEVENT_VALUE_X, 175);

			// �}�E�X���N���b�N���ꂽ��
			String isClick = Boolean.toString(canvas.isClick());
			canvas.drawText(BLACK, "isClick", MOUSEEVENT_LABEL_X, 200);
			canvas.drawText(BLACK, isClick, MOUSEEVENT_VALUE_X, 200);

			// �}�E�X���V���O���N���b�N�����ꂽ��
			String isSingleClick = Boolean.toString(canvas.isSingleClick());
			canvas.drawText(BLACK, "isSingleClick", MOUSEEVENT_LABEL_X, 225);
			canvas.drawText(BLACK, isSingleClick, MOUSEEVENT_VALUE_X, 225);

			// �}�E�X���_�u���N���b�N���ꂽ��
			String isDoubleClick = Boolean.toString(canvas.isDoubleClick());
			canvas.drawText(BLACK, "isDoubleClick", MOUSEEVENT_LABEL_X, 250);
			canvas.drawText(BLACK, isDoubleClick, MOUSEEVENT_VALUE_X, 250);

			// �}�E�X���h���b�O����
			String isDragging = Boolean.toString(canvas.isDragging());
			canvas.drawText(BLACK, "isDragging", MOUSEEVENT_LABEL_X, 275);
			canvas.drawText(BLACK, isDragging, MOUSEEVENT_VALUE_X, 275);
		}
	}
}