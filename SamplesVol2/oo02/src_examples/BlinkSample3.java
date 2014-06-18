import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * ��ԑJ�ځi�_�Łj�̃T���v���v���O���� ���̂R�iEnum�o�[�W�����j
 * 
 * @author gute
 * @date 2005/06/08 �I�u�v����8��
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

	// �E�C���h�E���J��
	void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	BlinkRectangle3 rectangle;

	// �A�j���[�V��������
	void doAnimation() {
		// �L�����o�X���擾����
		BCanvas canvas = window.getCanvas();

		// �I�u�W�F�N�g������������
		rectangle = new BlinkRectangle3(BLACK, 50, 50, 100, 50);

		// �A�j���[�V��������
		while (true) {
			// ���͂ɂ��C�_�ŏ�Ԃ�ύX����
			if (canvas.isKeyDown()) {
				int keyCode = canvas.getKeyCode();
				if (keyCode == 65) {// a
					rectangle.changeBlinkingState();
				}
			}

			// 1�R�}�̏������s��
			rectangle.processOneStep();

			{// �}�`��`��
				canvas.clear();
				rectangle.draw(canvas);
				canvas.update();
			}

			// ����
			canvas.sleep(0.1);
		}
	}

}