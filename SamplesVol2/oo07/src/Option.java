import java.util.LinkedList;

import obpro.gui.BCanvas;

/**
 * オプションを表現するクラス
 */
public class Option extends Component {

	// 定数
	private final int HISTORY_INTERVAL = 15;
	private final int SCALE_UP = 1;
	private final int SCALE_DOWN = 2;

	// アニメーション状態
	private int animationState = SCALE_UP;
	private int animationCount = 0;

	// プレイヤーの動きの履歴
	private LinkedList<MoveData> playerMoveHistories = new LinkedList<MoveData>();

	/**
	 * コンストラクタ
	 */
	public Option(int x, int y, int width, int height, int index) {
		super(x, y, width, height);
		initializeHistories(index);
	}

	/**
	 * 履歴を初期化する
	 */
	private void initializeHistories(int index) {
		for (int i = 0; i < HISTORY_INTERVAL * index; i++) {
			playerMoveHistories.add(new MoveData());
		}
	}

	/**
	 * 動く （playerMoveHistoriesを履歴キューとして使っています）
	 */
	public void move(int moveX, int moveY) {
		// 履歴の最後のデータを取得し，動く
		MoveData moveData = (MoveData) playerMoveHistories.removeFirst();
		super.move(moveData.dx, moveData.dy);

		// 今回の動きを履歴に加える
		moveData.dx = moveX;
		moveData.dy = moveY;
		playerMoveHistories.addLast(moveData);
	}

	/**
	 * 1ステップの処理を行なう
	 */
	public void processOneStep(BCanvas canvas) {
		// アニメーションカウンターを増やす
		if (animationState == SCALE_UP) {
			animationCount++;
		} else if (animationState == SCALE_DOWN) {
			animationCount--;
		}

		// 状態遷移をする
		if (animationState == SCALE_UP && animationCount >= 10) {
			animationState = SCALE_DOWN;
		} else if (animationState == SCALE_DOWN && animationCount <= 0) {
			animationState = SCALE_UP;
		}
	}

	/**
	 * 描画処理を行なう
	 */
	public void draw(BCanvas canvas) {
		int w = getWidth() / 3 + animationCount;
		int h = getHeight() / 3 + animationCount;
		int x = getX() + (getWidth() - w) / 2;
		int y = getY() + (getHeight() - h) / 2;
		canvas.drawImage("img/option.png", x, y, w, h);
	}

	/**
	 * 移動を表現する内部クラス このクラス内でのみ使うので，ここで定義している
	 */
	class MoveData {
		int dx = 0;
		int dy = 0;
	}
}