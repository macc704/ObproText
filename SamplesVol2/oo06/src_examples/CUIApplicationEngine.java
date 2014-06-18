import obpro.cui.Input;

/*
 * CUIApplicationEngine.java
 * Copyright(c) 2005 CreW Project. All rights reserved.
 */

/**
 * CUI�A�v���P�[�V�����@�t���[�����[�N 
 * ���s�G���W��
 * 
 * @author macchan
 * @version 1.0
 */
public class CUIApplicationEngine {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("�N���ɂ͈������K�v�ł�");
			return;
		}

		//�A�v���P�[�V�����𐶐����C�G���W�����N������
		AbstractCUIApplication application = (AbstractCUIApplication) BReflection
				.createInstanceByName(args[0]);
		CUIApplicationEngine engine = new CUIApplicationEngine(application);
		engine.run();
	}

	//���s����A�v���P�[�V����
	private AbstractCUIApplication application;

	/**
	 * �R���X�g���N�^
	 */
	private CUIApplicationEngine(AbstractCUIApplication application) {
		this.application = application;
	}

	//�A�v���P�[�V���������s����
	private void run() {
		//�A�v���P�[�V�����̊J�n��m�点��
		application.showTitle();

		//�A�v���P�[�V���������s����
		application.initializeData();
		executeProcessLoop();

		//�A�v���P�[�V�����̏I����m�点��
		application.showEndTitle();
	}

	//�A�v���P�[�V���������s����
	private void executeProcessLoop() {
		//�A�v���P�[�V���������s����
		while (true) {
			//�R�}���h�̓��͂��󂯎��
			String command = getCommand();

			//�R�}���h�����s����
			if (command.equals(application.getQuitCommand())) {
				break;
			} else {
				application.executeCommand(command);
			}
		}
	}

	//�R�}���h���͂��󂯎��
	private String getCommand() {
		//���j���[���o�͂���
		application.showCommandMenu();

		//�R�}���h�̓��͂��󂯎��
		String command = Input.getString();
		return command;
	}

}