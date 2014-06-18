import obpro.turtle.Turtle;

/*
 * House03.java ‘‹•t‚«‚Ì‰Æ‚ğ•`‚­ƒvƒƒOƒ‰ƒ€i‚Rj
 * 
 * @author r–Øi¼àVC³j
 * @version 2007/04/26 13:17:08
 */
public class House03 extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new House03());
	}

	// ‰Æ‚ğ•`‚­
	public void start() {
		drawRoof(); // ‰®ª‚ğ•`‚­
		drawWall(); // •Ç‚ğ•`‚­
		drawWindow(); // ‘‹‚ğ•`‚­
	}

	// ‰®ª‚ğ•`‚­
	void drawRoof() {
		drawRegularPolygon(3, 80); // OŠpŒ`‚ğ•`‚­
	}

	// •Ç‚ğ•`‚­
	void drawWall() {
		rt(90); // Œü‚«‚ğ’²ß‚·‚é
		drawRegularPolygon(4, 80);// lŠpŒ`‚ğ•`‚­
		lt(90);// Œü‚«‚ğãŒü‚«‚É–ß‚·
	}

	// ‘‹‚ğ•`‚­
	void drawWindow() {
		// ‘‹‚ğ•`‚­ˆÊ’u‚Ü‚ÅˆÚ“®‚·‚é
		moveToWindowLocation(22);

		// ‘‹‚ğ•`‚­
		rt(90);
		for (int i = 0; i < 4; i++) {
			drawRegularPolygon(4, 16);
			fd(16 * 2 + 4);
			rt(90);
		}
		lt(90);
	}

	// w’è‚³‚ê‚½Šp”‚Ì³‘½ŠpŒ`‚ğ•`‚­
	void drawRegularPolygon(int n, int size) {
		// Œü‚«‚ğ’²ß‚·‚é
		double angle = 360d / (double) n;
		rt(angle - 90);

		// ‘½ŠpŒ`‚ğ•`‚­
		for (int i = 0; i < n; i++) {
			fd(size);
			rt(angle);
		}

		// Œü‚«‚ğãŒü‚«‚É–ß‚·
		lt(angle - 90);
	}

	// ‘‹‚ğ•`‚­ˆÊ’u‚Ü‚ÅˆÚ“®‚·‚é
	void moveToWindowLocation(int length) {
		moveTurtle(90, 22);// ‰E‚Ö
		moveTurtle(180, 22);// ‰º‚Ö
	}

	// w’è‚³‚ê‚½•ûŒü‚Éiƒyƒ“‚ğã‚°‚ÄjˆÚ“®‚·‚é
	void moveTurtle(double direction, int distance) {
		up();
		rt(direction);
		fd(distance);
		lt(direction);
		down();
	}

}
