import java.util.Random;

/*
 * �v���O�������F Java���C�u�������g����RandomSample
 * @author Yoshiaki Matsuzawa 
 * @date 2010/04/09
 */
public class RandomSampleRandom {

	public static void main(String[] args) {
		RandomSampleRandom randomSampleJava = new RandomSampleRandom();
		randomSampleJava.main();
	}

	private void main() {
		// 0�`9�܂ł̃����_���Ȑ�����100�񐶐�����
		for (int i = 0; i < 100; i++) {
			Random random = new Random();
			int randomIntNumber = random.nextInt(10);
			System.out.println(randomIntNumber);
		}
	}

}