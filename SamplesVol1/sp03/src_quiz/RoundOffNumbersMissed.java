/**
 * ���P�|C�F
 * �l�̌ܓ����郁�\�b�h�����C�e�X�g��������D
 * �o�͈͂ȉ��̂悤�ɂȂ�͂����������C�����Ȃ�Ȃ��D�i���s���Ă݂�j
 * �Ȃ����l�@���āC�v���O�������C������
 * �i�q���g�F2�̖�肪�������Ă��܂��D�j
 * 
 ������0�ʂ܂Ŏl�̌ܓ��������ʁF6.0
 ������1�ʂ܂Ŏl�̌ܓ��������ʁF5.8
 ������2�ʂ܂Ŏl�̌ܓ��������ʁF5.78
 ������3�ʂ܂Ŏl�̌ܓ��������ʁF5.785
 ������4�ʂ܂Ŏl�̌ܓ��������ʁF5.7846
 ������5�ʂ܂Ŏl�̌ܓ��������ʁF5.78463
 ������6�ʂ܂Ŏl�̌ܓ��������ʁF5.784626
 ������7�ʂ܂Ŏl�̌ܓ��������ʁF5.7846261
 ������8�ʂ܂Ŏl�̌ܓ��������ʁF5.78462611
 ������9�ʂ܂Ŏl�̌ܓ��������ʁF5.784626109
 ������10�ʂ܂Ŏl�̌ܓ��������ʁF5.7846261093
 ������11�ʂ܂Ŏl�̌ܓ��������ʁF5.78462610928
 ������12�ʂ܂Ŏl�̌ܓ��������ʁF5.784626109284
 ������13�ʂ܂Ŏl�̌ܓ��������ʁF5.7846261092837
 ������14�ʂ܂Ŏl�̌ܓ��������ʁF5.78462610928375
 */
public class RoundOffNumbersMissed {

	public static void main(String[] args) {
		RoundOffNumbersMissed roundOffNumbersMissed = new RoundOffNumbersMissed();
		roundOffNumbersMissed.main();
	}

	//�l�̌ܓ�����֐��̃e�X�g�v���O����
	void main() {
		double number = 5.784626109283749;//�K���Ȓl

		//������n�ʂ܂Ŏl�̌ܓ������l��15�ʂ܂ŕ\������
		for (int i = 0; i < 15; i++) {
			System.out.println("������" + i + "�ʂ܂Ŏl�̌ܓ��������ʁF" + round(number, i));
		}
	}

	//������n+1�ʂ��l�̌ܓ����C������n�ʂ܂ł̒l�����߂�
	double round(double value, int n) {
		int multiplier = (int) Math.pow(10, n); //���N�G�X�g���ꂽ���ɉ����āC�P�O�̏搔�����߂�
		double multiplied = value * multiplier; //�搔��������
		int rounded = (int) (multiplied + 0.5); //������P�ʂŎl�̌ܓ�����
		double newValue = (double) (rounded / multiplier);//�搔�Ŋ����Đ���߂�
		return newValue;
	}
}
