import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/*
 * AbstractGUIAnimationApplication.java
 * Copyright(c) 2005 CreW Project. All rights reserved.
 */

/**
 * GUI�Q�[���@�t���[�����[�N 
 * ���ۃA�v���P�[�V�����N���X�i�X�[�p�[�N���X�j
 * 
 * @author macchan
 * @version 1.0
 */
public class AbstractGUIAnimationApplication {

	private GUIAnimationApplicationEngine engine;

	/**
	 * �A�v���P�[�V�������쓮����G���W�����擾����(final:�I�[�o�[���C�h�֎~)
	 */
	public final GUIAnimationApplicationEngine getEngine() {
		return this.engine;
	}

	/**
	 * �A�v���P�[�V�������쓮����G���W����ݒ肷��(final:�I�[�o�[���C�h�֎~)
	 */
	public final void setEngine(GUIAnimationApplicationEngine engine) {
		this.engine = engine;
	}

	/**
	 * �E�C���h�E�̏�����������
	 */
	public void initializeWindow(BWindow window) {
		window.setLocation(100, 100);
		window.setSize(640, 480);
	}

	/**
	 * �A�j���[�V�����J�n�̏���������
	 */
	public void prepareAnimationStart() {
	}

	/**
	 * 1�X�e�b�v�̏���������
	 */
	public void processOneStepForApplication(BCanvas canvas) {
	}

	/**
	 * �`�悷��
	 */
	public void drawForApplication(BCanvas canvas) {
	}

}