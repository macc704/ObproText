import java.io.*;

/**
 * �R���\�[������̓��̓��\�b�h��񋟂���N���X
 * 
 * @author Manabu Sugiura
 * @version $Id: Input.java,v 1.1 2007/06/20 10:13:02 macchan Exp $
 */
public class Input {

	private static BufferedReader br;

	/**
	 * �R���\�[�����當����ǂݍ���
	 * @return String
	 */
	public static String getString() {
		String returnString = null;
		try {
			if (br == null) {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
			returnString = br.readLine();
			return returnString;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * �R���\�[�����琔����ǂݍ���
	 * @return int
	 */
	public static int getInt() {
		int returnInt = 0;
		returnInt = Integer.parseInt(getString());
		return returnInt;

	}

	/**
	 * �R���\�[������double�^�̐�����ǂݍ���
	 * @return double
	 */
	public static double getDouble() {
		double returnDouble = 0.0;
		returnDouble = Double.parseDouble(getString());
		return returnDouble;

	}

	/**
	 * ���͂��ꂽ������int�^�ɕϊ��ł��邩�ǂ����𒲂ׂ�
	 * @return int
	 */
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	/**
	 * ���͂��ꂽ������int�^�ɕϊ��ł��邩�ǂ����𒲂ׂ�
	 * @return int
	 */
	public static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}
