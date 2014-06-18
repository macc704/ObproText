import java.util.ArrayList;
import java.util.List;

import obpro.cui.Input;

/*
 * SakubunApplication.java
 * Copyright(c) 2005 CreW Project. All rights reserved.
 */

/**
 * �앶����A�v���P�[�V����
 * 
 * @author macchan
 * @date 2005/07/7 �I�u�v����12��
 * @version 1.0
 */
public class SakubunApplication extends AbstractCUIApplication {

	private List<String> nouns = new ArrayList<String>();
	private List<String> verbs = new ArrayList<String>();

	// �A�v���P�[�V�����̊J�n��m�点��
	public void showTitle() {
		System.out.println("�앶����J�n");
	}

	// �A�v���P�[�V�����̏I����m�点��
	public void showEndTitle() {
		System.out.println("�앶����I��");
	}

	// �R�}���h���j���[��\������
	public void showCommandMenu() {
		System.out.println("���j���[(1.�����ǉ� 2.�����ǉ� 3.�앶 q.�I��)");
	}

	// �R�}���h�����s����
	public void executeCommand(String command) {
		if (command.equals("1")) {
			addNoun();
		} else if (command.equals("2")) {
			addVerb();
		} else if (command.equals("3")) {
			makeSentence();
		} else {
			System.out.println("�����ȃR�}���h�ł�");
		}
	}

	// ������ǉ�����
	private void addNoun() {
		System.out.println("��������͂��Ă�������");
		String noun = Input.getString();
		nouns.add(noun);
		System.out.println("����" + noun + "��ǉ����܂���");
	}

	// ������ǉ�����
	private void addVerb() {
		System.out.println("��������͂��Ă�������");
		String verb = Input.getString();
		verbs.add(verb);
		System.out.println("����" + verb + "��ǉ����܂���");
	}

	// �앶����
	private void makeSentence() {
		// ����I��
		String noun = (String) nouns.get((int) (Math.random() * nouns.size()));
		String verb = (String) verbs.get((int) (Math.random() * verbs.size()));

		// ���ʂ�\������
		System.out.println(noun + "��" + verb);
	}

}