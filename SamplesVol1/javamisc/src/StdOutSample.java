/*
 * �v���O������: Java�ɂ��W�����o��
 * @author Yoshiaki Matsuzawa 
 * @date 2010/04/09
 */
public class StdOutSample {

    public static void main(String[] args) {
        StdOutSample stdOutSample = new StdOutSample();
        stdOutSample.main();
    }

    void main() {
        // �o��
        System.out.println("Hello, world!");// ���s�t�o�́i�I�[�g�t���b�V���j
        System.out.print("Hello, world!");// ���s�����o�́i�t���b�V�����Ȃ��d�l�����Cwin�̂u�l�ł̓t���b�V�������j
        System.out.flush();

        // �ϐ����Ȃ��ďo��
        int i1 = 3;
        String s1 = "�ڂ�";
        System.out.println("i1�̒l��" + i1 + "�ł��D");// �������Ȃ��ďo��
        System.out.println("s1�̒l��" + s1 + "�ł��D");// ��������Ȃ��ďo��

        // C���ꕗ�̏o��
        System.out.printf("Hello, world!\n");
        System.out.printf("i1�̒l��%d�ł��D\n", i1);// �������Ȃ��ďo��
        System.out.printf("s1�̒l��%s�ł��D\n", s1);// ��������Ȃ��ďo��
    }

}