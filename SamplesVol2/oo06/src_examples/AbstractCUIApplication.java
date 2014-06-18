/*
 * AbstractCUIApplication.java
 * Copyright(c) 2005 CreW Project. All rights reserved.
 */

/**
 * CUI�A�v���P�[�V�����@�t���[�����[�N 
 * ���ۃA�v���P�[�V�����N���X�i�X�[�p�[�N���X�j
 * 
 * @author macchan
 * @version 1.0
 */
public class AbstractCUIApplication {

	/**
	 * �A�v���P�[�V�����̊J�n��m�点��
	 */
	public void showTitle() {
	}

	/**
	 * �A�v���P�[�V�����̏I����m�点��
	 */
	public void showEndTitle() {
	}

	/**
	 * �f�[�^������������
	 */
	public void initializeData() {
	}

	/**
	 * �R�}���h���j���[��\������
	 */
	public void showCommandMenu() {
	}

	/**
	 * �I���R�}���h���擾����
	 */
	public String getQuitCommand() {
		return "q";
	}

	/**
	 * �R�}���h�����s����
	 */
	public void executeCommand(String command) {
	}

}