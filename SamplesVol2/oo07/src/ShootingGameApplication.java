import obpro.gamefw.AbstractGUIAnimationApplication;
import obpro.gamefw.GUIAnimationApplicationEngine;

/*
 * ShootingGame.java
 * Created on 2011/07/28
 * Copyright(c) 2011 Yoshiaki Matsuzawa, Shizuoka University. All rights reserved.
 */

/**
 * @author macchan
 * 
 */
public class ShootingGameApplication extends AbstractGUIAnimationApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GUIAnimationApplicationEngine
				.main(new String[] { ShootingGameApplication.class.getName() });
	}

	public void prepareAnimationStart() {
		getEngine().addElement(new ShootingGame(0, 0, 1000, 1000));
	}
}
