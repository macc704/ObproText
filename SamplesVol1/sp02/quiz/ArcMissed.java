/*
 * ArcMissed.java
 * 円弧を書くプログラム(コンパイルエラー）
 * 
 * Created on 2007/04/26 by macchan
 * Copyright(c) 2007 CreW Project
 */
public class ArcMissed extends Turtle {

	public static void main(String[] args) {
		Turtle.startTurtle(new ArcMissed());
	}

	// 円弧を書く
	public void start() {
		int angle = 120;
		drawArc(int angle);
		// 円弧を描く
		public void drawArc(int angle) {
			for (int i = 0; i < angle; i++) {
				fd(1);
				rt(1);
			}
		}
	}

}
