/*
 * �v���O�������F Java���C�u�������g����RandomSample
 * @author Yoshiaki Matsuzawa 
 * @date 2010/04/09
 */
public class RandomSampleMath {

    public static void main(String[] args) {
        RandomSampleMath randomSampleMath = new RandomSampleMath();
        randomSampleMath.main();
    }

    private void main() {
        // 0�`9�܂ł̃����_���Ȑ�����100�񐶐�����
        for (int i = 0; i < 100; i++) {
            double randomDoubleNumber = Math.random(); // ��:Math�N���X��random()���\�b�h��0.0�ȏ�ŁA1.0��菬�������̕����̕t����double�l��Ԃ��܂��B
            int randomIntNumber = (int) (randomDoubleNumber * 10);// 10���|���ď�����؂�̂Ă�
            System.out.println(randomIntNumber);
        }
    }

}