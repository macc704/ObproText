import java.awt.Color;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/**
 * GUI���v���O����2
 * �A�j���[�V�����̕��@2(������)
 * 
 * @author macchan
 * @date 2005/06/02 �I�u�v����V��@2006/05/21����
 * @version 1.0
 */
public class GUISample2 {

	public static void main(String[] args) {
		GUISample2 sample = new GUISample2();
		sample.main();
	}

	//�F�̒萔(�F�N���X���g�����߂ɂ�import�����K�v)
	final Color BLACK = new Color(0, 0, 0);
	final Color RED = new Color(255, 0, 0);
	final Color GREEN = new Color(0, 255, 0);
	final Color BLUE = new Color(0, 0, 255);

	void main() {
		BWindow window;

		{// �E�C���h�E���J��
			// �E�C���h�E�𐶐�����
			window = new BWindow();

			// �ʒu�Ƒ傫�������߂�
			window.setLocation(100, 100);
			window.setSize(640, 480);

			// �E�C���h�E���J��
			window.show();
		}

		{// �A�j���[�V����������
			// �L�����o�X���擾����
			BCanvas canvas = window.getCanvas();

			// �A�j���[�V����������
			int arcX = 0;
			while (true) {
				// �}�`�𓮂���
				arcX = arcX + 10;

				{// �}�`��`��
					// �L�����o�X���N���A����
					canvas.clear();

					// �}�`��`��
					canvas.drawLine(BLACK, 100, 100, 200, 200);// ��
					canvas
							.drawFillTriangle(BLUE, arcX, 300, 300, 350, 350,
									300);// �h��Ԃ��O�p�`
					canvas.drawArc(RED, arcX, 100, 200, 200, 0, 180);// �~��
					canvas.drawFillArc(GREEN, arcX, 100, 200, 200, 0, 360);// �h��Ԃ��~��

					// �L�����o�X���X�V����
					canvas.update();
				}

				// ����
				canvas.sleep(0.1);
			}
		}
	}

}