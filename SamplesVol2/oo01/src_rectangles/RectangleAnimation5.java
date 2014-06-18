import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * �l�p�`�̃A�j���[�V����5(�R���X�g���N�^�@& �t���[�����[�N���ӎ��������\�b�h��)
 * 
 * @author macchan
 * @date 2005/06/02 �I�u�v����V��
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

	//�E�C���h�E���J��
	void openWindow() {
		window = new BWindow();
		window.setLocation(100, 100);
		window.setSize(640, 480);
		window.show();
	}

	//�A�j���[�V��������
	void doAnimation() {
		//�O����
		BCanvas canvas = window.getCanvas();//�L�����o�X���擾����		
		initializeObjects();//�I�u�W�F�N�g�̏�����������

		//�A�j���[�V��������
		while (true) {
			//�}�`�𓮂���
			move();

			//�}�`��`��
			canvas.clear();
			draw(canvas);
			canvas.update();

			//����
			canvas.sleep(0.1);
		}
	}

	//�I�u�W�F�N�g������������
	void initializeObjects() {
		rectangle1 = new Rectangle(BLACK, 100, 100, 100, 100);
		rectangle2 = new Rectangle(RED, 300, 200, 50, 80);
	}

	//�I�u�W�F�N�g�𓮂���
	void move() {
		rectangle1.move(10, 10);
		rectangle2.move(5, 0);
	}

	//�I�u�W�F�N�g��`�悷��
	void draw(BCanvas canvas) {
		rectangle1.draw(canvas);
		rectangle2.draw(canvas);
	}

}