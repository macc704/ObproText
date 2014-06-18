import java.util.LinkedList;

import obpro.gui.BCanvas;

/**
 * �I�v�V������\������N���X
 */
public class Option extends Component {

	// �萔
	private final int HISTORY_INTERVAL = 15;
	private final int SCALE_UP = 1;
	private final int SCALE_DOWN = 2;

	// �A�j���[�V�������
	private int animationState = SCALE_UP;
	private int animationCount = 0;

	// �v���C���[�̓����̗���
	private LinkedList<MoveData> playerMoveHistories = new LinkedList<MoveData>();

	/**
	 * �R���X�g���N�^
	 */
	public Option(int x, int y, int width, int height, int index) {
		super(x, y, width, height);
		initializeHistories(index);
	}

	/**
	 * ����������������
	 */
	private void initializeHistories(int index) {
		for (int i = 0; i < HISTORY_INTERVAL * index; i++) {
			playerMoveHistories.add(new MoveData());
		}
	}

	/**
	 * ���� �iplayerMoveHistories�𗚗��L���[�Ƃ��Ďg���Ă��܂��j
	 */
	public void move(int moveX, int moveY) {
		// �����̍Ō�̃f�[�^���擾���C����
		MoveData moveData = (MoveData) playerMoveHistories.removeFirst();
		super.move(moveData.dx, moveData.dy);

		// ����̓����𗚗��ɉ�����
		moveData.dx = moveX;
		moveData.dy = moveY;
		playerMoveHistories.addLast(moveData);
	}

	/**
	 * 1�X�e�b�v�̏������s�Ȃ�
	 */
	public void processOneStep(BCanvas canvas) {
		// �A�j���[�V�����J�E���^�[�𑝂₷
		if (animationState == SCALE_UP) {
			animationCount++;
		} else if (animationState == SCALE_DOWN) {
			animationCount--;
		}

		// ��ԑJ�ڂ�����
		if (animationState == SCALE_UP && animationCount >= 10) {
			animationState = SCALE_DOWN;
		} else if (animationState == SCALE_DOWN && animationCount <= 0) {
			animationState = SCALE_UP;
		}
	}

	/**
	 * �`�揈�����s�Ȃ�
	 */
	public void draw(BCanvas canvas) {
		int w = getWidth() / 3 + animationCount;
		int h = getHeight() / 3 + animationCount;
		int x = getX() + (getWidth() - w) / 2;
		int y = getY() + (getHeight() - h) / 2;
		canvas.drawImage("img/option.png", x, y, w, h);
	}

	/**
	 * �ړ���\����������N���X ���̃N���X���ł̂ݎg���̂ŁC�����Œ�`���Ă���
	 */
	class MoveData {
		int dx = 0;
		int dy = 0;
	}
}