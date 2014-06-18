import obpro.turtle.Turtle;

/*
 * House01.java ‘‹•t‚«‚Ì‰Æ‚ğ•`‚­ƒvƒƒOƒ‰ƒ€(1)
 * 
 * @author r–Øi¼àVC³j
 * @version 2007/04/26 13:17:08
 */
public class House01 extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new House01());
	}

	// ‰Æ‚ğ•`‚­
	public void start() {
		drawRoof(); // ‰®ª‚ğ•`‚­
		drawWall(); // •Ç‚ğ•`‚­
		drawWindow(); // ‘‹‚ğ•`‚­
	}

	// ‰®ª‚ğ•`‚­
	void drawRoof() {
		drawTriangle(); // OŠpŒ`‚ğ•`‚­
	}

	// •Ç‚ğ•`‚­
	void drawWall() {
		rt(90); // Œü‚«‚ğ’²ß‚·‚é
		drawRectangle();// lŠpŒ`‚ğ•`‚­
		lt(90);// Œü‚«‚ğãŒü‚«‚É–ß‚·
	}

	// ‘‹‚ğ•`‚­
	void drawWindow() {
		// ‘‹‚ğ•`‚­ˆÊ’u‚Ü‚ÅˆÚ“®‚·‚é
		moveToWindowLocation();

		// ‘‹‚ğ•`‚­
		rt(90);
		for (int i = 0; i < 4; i++) {
			drawSmallRectangle();
			fd(16 * 2 + 4);
			rt(90);
		}
		lt(90);
	}

	// OŠpŒ`‚ğ•`‚­
	void drawTriangle() {
		// Œü‚«‚ğ’²ß‚·‚é
		rt(30);

		// OŠpŒ`‚ğ•`‚­
		for (int i = 0; i < 3; i++) {
			fd(80);
			rt(120);
		}

		// Œü‚«‚ğãŒü‚«‚É–ß‚·
		lt(30);
	}

	// lŠpŒ`‚ğ•`‚­
	void drawRectangle() {
		for (int i = 0; i < 4; i++) {
			fd(80);
			rt(90);
		}
	}

	// ¬‚³‚¢lŠpŒ`‚ğ•`‚­
	void drawSmallRectangle() {
		for (int i = 0; i < 4; i++) {
			fd(16);
			rt(90);
		}
	}

	// ‘‹‚ğ•`‚­ˆÊ’u‚Ü‚ÅˆÚ“®‚·‚é
	void moveToWindowLocation() {
		// ‘Oˆ—
		up();

		// ‰E‚Ö22
		rt(90);
		fd(22);

		// ‰º‚Ö22
		rt(90);
		fd(22);

		// Œãˆ—
		rt(180);
		down();
	}

}
