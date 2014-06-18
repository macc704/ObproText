import java.awt.Color;

import obpro.gui.BCanvas;

/**
 * �l�p�`��\������N���X
 */
public class Rectangle {

	private Color color;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;

	/**
	 * �R���X�g���N�^
	 */
	public Rectangle(Color color, int x, int y, int width, int height) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * ������
	 */
	public void move(int moveX, int moveY) {
		x = x + moveX;
		y = y + moveY;
	}

	/**
	 * �`��
	 */
	public void draw(BCanvas canvas) {
		canvas.drawLine(color, x, y, x + width, y);
		canvas.drawLine(color, x + width, y, x + width, y + height);
		canvas.drawLine(color, x + width, y + height, x, y + height);
		canvas.drawLine(color, x, y + height, x, y);
	}
}