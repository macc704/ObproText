import obpro.turtle.Turtle;

/*
 * House02.java ‘‹•t‚«‚Ì‰Æ‚ğ•`‚­ƒvƒƒOƒ‰ƒ€i2j (ˆø”‚Â‚«j
 * 
 * @author r–Øi¼àVC³j
 * @version 2007/04/26 13:17:08
 */
public class House02 extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new House02());
	}

	// ‰Æ‚ğ•`‚­
	public void start() {
		drawRoof(); // ‰®ª‚ğ•`‚­
		drawWall(); // •Ç‚ğ•`‚­
		drawWindow(); // ‘‹‚ğ•`‚­
	}

	// ‰®ª‚ğ•`‚­
	void drawRoof() {
		drawTriangle(80); // OŠpŒ`‚ğ•`‚­
	}

	// •Ç‚ğ•`‚­
	void drawWall() {
		rt(90); // Œü‚«‚ğ’²ß‚·‚é
		drawRectangle(80);// lŠpŒ`‚ğ•`‚­
		lt(90);// Œü‚«‚ğãŒü‚«‚É–ß‚·
	}

	// ‘‹‚ğ•`‚­
	void drawWindow() {
		// ‘‹‚ğ•`‚­ˆÊ’u‚Ü‚ÅˆÚ“®‚·‚é
		moveToWindowLocation(22);

		// ‘‹‚ğ•`‚­
		rt(90);
		for (int i = 0; i < 4; i++) {
			drawRectangle(16);
			fd(16 * 2 + 4);
			rt(90);
		}
		lt(90);
	}

	// OŠpŒ`‚ğ•`‚­
	void drawTriangle(int size) {
		// Œü‚«‚ğ’²ß‚·‚é
		rt(30);

		// OŠpŒ`‚ğ•`‚­
		for (int i = 0; i < 3; i++) {
			fd(size);
			rt(120);
		}

		// Œü‚«‚ğãŒü‚«‚É–ß‚·
		lt(30);
	}

	// lŠpŒ`‚ğ•`‚­
	void drawRectangle(int size) {
		for (int i = 0; i < 4; i++) {
			fd(size);
			rt(90);
		}
	}

	// ‘‹‚ğ•`‚­ˆÊ’u‚Ü‚ÅˆÚ“®‚·‚é
	void moveToWindowLocation(int length) {
		// ‘Oˆ—
		up();

		// ‰E‚Ö
		rt(90);
		fd(length);

		// ‰º‚Ö
		rt(90);
		fd(length);

		// Œãˆ—
		rt(180);
		down();
	}

}
