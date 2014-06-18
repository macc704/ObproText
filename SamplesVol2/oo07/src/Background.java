import obpro.gui.BCanvas;

/**
 * 背景を表現するクラス
 */
public class Background extends Component {

	private int x1 = 0;
	private int x2 = 1000;

	public Background() {
		super(0, 0, 0, 0);
	}

	/**
	 * 1ステップの処理をする（オーバーライド）
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
	 * 描画する(オーバーライド)
	 */
	public void draw(BCanvas canvas) {
		canvas.drawImage("img/background.jpg", x1, 0);
		canvas.drawImage("img/background.jpg", x2, 0);
	}

}