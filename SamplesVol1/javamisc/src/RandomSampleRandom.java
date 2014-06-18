import java.util.Random;

/*
 * プログラム名： Javaライブラリを使ったRandomSample
 * @author Yoshiaki Matsuzawa 
 * @date 2010/04/09
 */
public class RandomSampleRandom {

	public static void main(String[] args) {
		RandomSampleRandom randomSampleJava = new RandomSampleRandom();
		randomSampleJava.main();
	}

	private void main() {
		// 0～9までのランダムな数字を100回生成する
		for (int i = 0; i < 100; i++) {
			Random random = new Random();
			int randomIntNumber = random.nextInt(10);
			System.out.println(randomIntNumber);
		}
	}

}