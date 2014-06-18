import java.awt.Color;

import obpro.gui.BCanvas;

/*
 * TitleStage.java
 * Created on 2011/07/28
 * Copyright(c) 2011 Yoshiaki Matsuzawa, Shizuoka University. All rights reserved.
 */

/**
 * @author macchan
 * 
 */
public class TitleStage extends Container {

	private ShootingGame game;

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public TitleStage(ShootingGame game) {
		super(game.getX(), game.getY(), game.getWidth(), game.getHeight());
		this.game = game;
	}

	public void processOneStep(BCanvas canvas) {
		if (canvas.getKeyCode() == 10) {
			game.handleGameStart();
		}
	}

	public void draw(BCanvas canvas) {
		canvas.drawText(Color.BLACK, "Title Of Game", 100, 100);
	}

}
