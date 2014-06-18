import obpro.gui.BCanvas;

/**
 * 背景を表現するクラス
 */
public class Background extends AnimationElement {

	private int x;

	/**
	 * 1ステップの処理をする（オーバーライド）
	 */
	public void processOneStep(BCanvas canvas) {
		x--;
	}

	/**
	 * 描画する(オーバーライド)
	 */
	public void draw(BCanvas canvas) {
		canvas.drawImage("img/background.jpg", x, 0);
	}

}