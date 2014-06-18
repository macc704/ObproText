import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * �l�p�`�̃A�j���[�V����4(�J�v�Z����)
 * 
 * @author macchan
 * @date 2005/06/02 �I�u�v����V��
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
		CapsuledRectangle rectangle1 = new CapsuledRectangle();
		rectangle1.initialize(BLACK, 100, 100, 100, 100);

		//�l�p�`2�̃f�[�^������������
		CapsuledRectangle rectangle2 = new CapsuledRectangle();
		rectangle2.initialize(RED, 300, 200, 50, 80);

		//�A�j���[�V��������
		while (true) {
			//�}�`�𓮂���
			rectangle1.move(10, 10);
			rectangle2.move(5, 0);

			{//�}�`��`��
				//�L�����o�X���N���A����
				canvas.clear();

				//�}�`��`��
				rectangle1.draw(canvas);
				rectangle2.draw(canvas);

				//�L�����o�X���X�V����
				canvas.update();
			}

			//����
			canvas.sleep(0.1);
		}
	}
}