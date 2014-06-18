package trace_quiz.sp02;

import obpro.turtle.Turtle;

/**
 * @ƒvƒƒOƒ‰ƒ€–¼F ŠLŠk‚ğ•`‚­ƒvƒƒOƒ‰ƒ€
 * @ì¬F ‚±‚¤‚Ì‚É‚È (2008/5/22)
 * @C³F ¼àV–Fº(macchan)(2008/5/23)
 */
public class TraceQuizMethodTurtle01Answer extends Turtle {

	// ‹N“®ˆ—
	public static void main(String[] args) {
		Turtle.startTurtle(new TraceQuizMethodTurtle01Answer());
	}

	// ŠLŠk‚ğ•`‚­
	public void start() {
		// ‰ºŒü‚«‚ÌŠLŠk‚É‚·‚é
		rt(90);

		// ŠLŠk‚ğ•`‚­
		for (int i = 3; i < 6; i++) {
			methodA(i, 200 / i);
		}
	}

	// ³‘½ŠpŒ`‚ğ•`‚­
	void methodA(int param1, int param2) {
		// ‰ºŒü‚«‚É‚È‚é‚æ‚¤‚ÉŠp“x‚ğ’²ß‚·‚é
		rt(180 / param1);

		// ³‘½ŠpŒ`‚ğ•`‚­
		for (int i = 0; i < param1; i++) {
			fd(param2);
			rt(360 / param1);
		}

		// Šp“x‚ğ–ß‚·
		lt(180 / param1);
	}
}
