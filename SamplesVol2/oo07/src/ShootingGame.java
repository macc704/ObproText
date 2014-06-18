/*
 * Stage.java
 * Created on 2011/07/28
 * Copyright(c) 2011 Yoshiaki Matsuzawa, Shizuoka University. All rights reserved.
 */

/**
 * @author macchan
 * 
 */
public class ShootingGame extends Container {

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public ShootingGame(int x, int y, int width, int height) {
		super(x, y, width, height);

		clear();
		addChild(new TitleStage(this));
	}

	public void handleGameFinished() {
		clear();
		addChild(new TitleStage(this));
	}

	public void handleGameStart() {
		clear();
		addChild(new GameStage(this));
	}

}
