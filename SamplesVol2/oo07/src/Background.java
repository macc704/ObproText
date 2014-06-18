import obpro.gui.BCanvas;

/**
 * �w�i��\������N���X
 */
public class Background extends Component {

	private int x1 = 0;
	private int x2 = 1000;

	public Background() {
		super(0, 0, 0, 0);
	}

	/**
	 * 1�X�e�b�v�̏���������i�I�[�o�[���C�h�j
	 */
	public void processOneStep(BCanvas canvas) {
		x1--;
		if (x1 < -1000) {
			x1 = 1000;
		}
		x2--;
		if (x2 < -1000) {
			x2 = 1000;
		}
	}

	/**
	 * �`�悷��(�I�[�o�[���C�h)
	 */
	public void draw(BCanvas canvas) {
		canvas.drawImage("img/background.jpg", x1, 0);
		canvas.drawImage("img/background.jpg", x2, 0);
	}

}