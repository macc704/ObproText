/*
 * プログラム名: Javaによる標準入出力
 * @author Yoshiaki Matsuzawa 
 * @date 2010/04/09
 */
public class StdOutSample {

    public static void main(String[] args) {
        StdOutSample stdOutSample = new StdOutSample();
        stdOutSample.main();
    }

    void main() {
        // 出力
        System.out.println("Hello, world!");// 改行付出力（オートフラッシュ）
        System.out.print("Hello, world!");// 改行無し出力（フラッシュしない仕様だが，winのＶＭではフラッシュされる）
        System.out.flush();

        // 変数をつなげて出力
        int i1 = 3;
        String s1 = "ぼけ";
        System.out.println("i1の値は" + i1 + "です．");// 整数をつなげて出力
        System.out.println("s1の値は" + s1 + "です．");// 文字列をつなげて出力

        // C言語風の出力
        System.out.printf("Hello, world!\n");
        System.out.printf("i1の値は%dです．\n", i1);// 整数をつなげて出力
        System.out.printf("s1の値は%sです．\n", s1);// 文字列をつなげて出力
    }

}