import obpro.gamefw.GameCharacter;

/*
 * Component.java
 * Created on 2011/07/28
 * Copyright(c) 2011 Yoshiaki Matsuzawa, Shizuoka University. All rights reserved.
 */

/**
 * @author macchan
 */
public class Component extends GameCharacter {

	private Container parent;

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Component(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	protected void setContainer(Container parent) {
		this.parent = parent;
	}

	public int getAbsoluteX() {
		if (parent == null) {
			return getX();
		}
		return parent.getAbsoluteX() + getX();
	}

	public int getAbsoluteY() {
		if (parent == null) {
			return getY();
		}
		return parent.getAbsoluteY() + getY();
	}

}
