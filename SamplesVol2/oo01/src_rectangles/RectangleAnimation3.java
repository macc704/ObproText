import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * �l�p�`�̃A�j���[�V����3(�f�[�^�I�u�W�F�N�g)
 * 
 * @author macchan
 * @date 2005/06/02 �I�u�v����V��
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
		RectangleData rectangle1 = new RectangleData();
		rectangle1.color = BLACK;
		rectangle1.x = 100;
		rectangle1.y = 100;
		rectangle1.width = 100;
		rectangle1.height = 100;

		//�l�p�`2�̃f�[�^������������
		RectangleData rectangle2 = new RectangleData();
		rectangle2.color = RED;
		rectangle2.x = 300;
		rectangle2.y = 200;
		rectangle2.width = 50;
		rectangle2.height = 80;

		//�A�j���[�V��������
		while (true) {
			{//�}�`�𓮂���
				//�l�p�`1
				rectangle1.x = rectangle1.x + 10;
				rectangle1.y = rectangle1.y + 10;

				//�l�p�`2
				rectangle2.x = rectangle2.x + 5;
			}

			{//�}�`��`��
				//�L�����o�X���N���A����
				canvas.clear();

				//�}�`��`��
				drawRectangle(canvas, rectangle1);
				drawRectangle(canvas, rectangle2);

				//�L�����o�X���X�V����
				canvas.update();
			}

			//����
			canvas.sleep(0.1);
		}
	}

	//�l�p�`������
	void drawRectangle(BCanvas canvas, RectangleData r) {
		canvas.drawLine(r.color, r.x, r.y, r.x + r.width, r.y);
		canvas.drawLine(r.color, r.x + r.width, r.y, r.x + r.width, r.y
				+ r.height);
		canvas.drawLine(r.color, r.x + r.width, r.y + r.height, r.x, r.y
				+ r.height);
		canvas.drawLine(r.color, r.x, r.y + r.height, r.x, r.y);
	}
}