import obpro.turtle.Turtle;

/*
 * �v���O������:�R�b�z�Ȑ���`���v���O����
 * 
 * author ����TA
 * version $Id: Koch.java,v 1.3 2007/05/10 13:43:55 camei Exp $
 */
public class Koch extends Turtle {

	public static void main(String args[]) {
		Turtle.startTurtle(new Koch());
	}

	// �R�b�z�Ȑ���`��
	public void start() {
		// �O����
		window.size(500, 200);// �E�C���h�E�T�C�Y��ݒ�
		window.setKameSpeed("very fast");// �T�̑��x��ݒ�

		// �R�b�z�Ȑ���`��
		rt(90);// �����`��ʒu�Ɉړ�
		drawKoch(3, 200);
	}

	// �i�ċA�I�Ɂj�R�b�z�Ȑ���`��
	private void drawKoch(int level, int length) {
		// �ċA�̏I���
		if (level == 0) {
			fd(length);
			return;
		}

		// �ċA�I�ɃR�b�z�Ȑ���`��
		drawKoch(level - 1, length / 3);
		lt(60);
		drawKoch(level - 1, length / 3);
		rt(120);
		drawKoch(level - 1, length / 3);
		lt(60);
		drawKoch(level - 1, length / 3);
	}
}
