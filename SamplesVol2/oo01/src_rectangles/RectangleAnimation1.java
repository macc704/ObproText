import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * �l�p�`�̃A�j���[�V����1(�ׂ�����)
 * 
 * @author macchan
 * @date 2005/06/02 �I�u�v����V��
 * @version 1.0
 */
public class RectangleAnimation1 {

	public static void main(String[] args) {
		RectangleAnimation1 rectangleAnimation = new RectangleAnimation1();
		rectangleAnimation.main();
	}

	final Color BLACK = new Color(0, 0, 0);
	final Color RED = new Color(255, 0, 0);

	BWindow window;

	void main() {
		openWindow();
		doAnimation();
	}

	//�E�C���h�E���J��
	void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	//�A�j���[�V��������
	void doAnimation() {
		//�L�����o�X���擾����
		BCanvas canvas = window.getCanvas();

		//�l�p�`1�̃f�[�^������������
		int x1 = 100;
		int y1 = 100;
		int w1 = 100;
		int h1 = 100;

		//�l�p�`2�̃f�[�^������������
		int x2 = 300;
		int y2 = 200;
		int w2 = 50;
		int h2 = 80;

		//�A�j���[�V��������
		while (true) {
			{//�}�`�𓮂���
				//�l�p�`1
				x1 = x1 + 10;
				y1 = y1 + 10;

				//�l�p�`2
				x2 = x2 + 5;
			}

			{//�}�`��`��
				//�L�����o�X���N���A����
				canvas.clear();

				{//�}�`��`��
					//�l�p�`1
					canvas.drawLine(BLACK, x1, y1, x1 + w1, y1);
					canvas.drawLine(BLACK, x1 + w1, y1, x1 + w1, y1 + h1);
					canvas.drawLine(BLACK, x1 + w1, y1 + h1, x1, y1 + h1);
					canvas.drawLine(BLACK, x1, y1 + h1, x1, y1);

					//�l�p�`2
					canvas.drawLine(RED, x2, y2, x2 + w2, y2);
					canvas.drawLine(RED, x2 + w2, y2, x2 + w2, y2 + h2);
					canvas.drawLine(RED, x2 + w2, y2 + h2, x2, y2 + h2);
					canvas.drawLine(RED, x2, y2 + h2, x2, y2);
				}

				//�L�����o�X���X�V����
				canvas.update();
			}

			//����
			canvas.sleep(0.1);
		}
	}

}