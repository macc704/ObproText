import obpro.gui.BCanvas;

/**
 * �w�i��\������N���X
 */
public class Background extends AnimationElement {

	private int x;

	/**
	 * 1�X�e�b�v�̏���������i�I�[�o�[���C�h�j
	 */
	public void processOneStep(BCanvas canvas) {
		x--;
	}

	/**
	 * �`�悷��(�I�[�o�[���C�h)
	 */
	public void draw(BCanvas canvas) {
		canvas.drawImage("img/background.jpg", x, 0);
	}

}