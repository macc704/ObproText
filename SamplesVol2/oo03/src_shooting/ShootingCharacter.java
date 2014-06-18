/**
 * シューティングゲームのキャラクターを表現するクラス
 */
public class ShootingCharacter {

	// 属性
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * コンストラクタ
	 */
	public ShootingCharacter(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * 高さを取得する
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * 幅を取得する
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * X座標を取得する
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Y座標を取得する
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * 位置を再設定する
	 */
	public void setLocation(int newX, int newY) {
		x = newX;
		y = newY;
	}

	/**
	 * 動かす
	 */
	public void move(int moveX, int moveY) {
		x = x + moveX;
		y = y + moveY;
	}
}