/*
 * プログラム名： Javaライブラリを使ったRandomSample
 * @author Yoshiaki Matsuzawa 
 * @date 2010/04/09
 */
public class RandomSampleMath {

    public static void main(String[] args) {
        RandomSampleMath randomSampleMath = new RandomSampleMath();
        randomSampleMath.main();
    }

    private void main() {
        // 0～9までのランダムな数字を100回生成する
        for (int i = 0; i < 100; i++) {
            double randomDoubleNumber = Math.random(); // 注:Mathクラスのrandom()メソッドは0.0以上で、1.0より小さい正の符号の付いたdouble値を返します。
            int randomIntNumber = (int) (randomDoubleNumber * 10);// 10を掛けて小数を切り捨てる
            System.out.println(randomIntNumber);
        }
    }

}