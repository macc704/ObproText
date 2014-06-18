import java.util.ArrayList;
import java.util.List;

import obpro.gui.BCanvas;
import obpro.gui.BWindow;

/*
 * GUIAnimationApplicationEngine.java
 * Copyright(c) 2005 CreW Project. All rights reserved.
 */

/**
 * GUI�Q�[���@�t���[�����[�N ���s�G���W��
 * 
 * @author macchan
 * @version 1.0
 */
public class GUIAnimationApplicationEngine {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("�N���ɂ͈������K�v�ł�");
			return;
		}

		// �A�v���P�[�V�����𐶐����C�G���W�����N������
		AbstractGUIAnimationApplication application = (AbstractGUIAnimationApplication) BReflection
				.createInstanceByName(args[0]);
		GUIAnimationApplicationEngine engine = new GUIAnimationApplicationEngine(
				application);
		engine.run();
	}

	// ���s����A�v���P�[�V����
	private AbstractGUIAnimationApplication application;

	// �E�C���h�E
	private BWindow window;

	// �A�j���[�V�����I�u�W�F�N�g�̏W��
	private List<AnimationElement> elements = new ArrayList<AnimationElement>();

	// 1�R�}�̕b��
	private double stepInterval = 0.03d;

	/**
	 * �R���X�g���N�^
	 */
	public GUIAnimationApplicationEngine(
			AbstractGUIAnimationApplication application) {
		this.application = application;
		application.setEngine(this);
	}

	// �A�v���P�[�V���������s����
	public void run() {
		openWindow();
		application.prepareAnimationStart();// �A�j���[�V�����̊J�n����������(�I�u�W�F�N�g�Ȃǂ�����������)
		doAnimation();
	}

	// �E�C���h�E���J��
	private void openWindow() {
		window = new BWindow();
		application.initializeWindow(window);
		window.show();
	}

	// �A�j���[�V��������
	private void doAnimation() {
		// �L�����o�X���擾����
		BCanvas canvas = window.getCanvas();

		// �A�j���[�V��������
		while (true) {
			{// �P�R�}�̏������s��
				// �Q�[���S�̂Ƃ��Ă�1�R�}�̏������s��
				application.processOneStepForApplication(canvas);

				// �e�I�u�W�F�N�g��1�R�}�̏������s��
				for (int i = 0; i < elements.size(); i++) {
					AnimationElement element = (AnimationElement) elements
							.get(i);
					element.processOneStep(canvas);
				}
			}

			// �}�`��`��
			canvas.clear();
			application.drawForApplication(canvas);
			for (int i = 0; i < elements.size(); i++) {
				AnimationElement element = (AnimationElement) elements.get(i);
				element.draw(canvas);
			}
			canvas.update();

			// ����
			canvas.sleep(stepInterval);
		}
	}

	/**
	 * �P�X�e�b�v�̎��Ԃ�ݒ肷��
	 */
	public void setStepInterval(double stepInterval) {
		this.stepInterval = stepInterval;
	}

	/**
	 * �L�����N�^�[��ǉ�����
	 */
	public void addElement(AnimationElement element) {
		elements.add(element);
	}

	/**
	 * �L�����N�^�[���폜����
	 */
	public void removeElement(AnimationElement element) {
		elements.remove(element);
	}

}