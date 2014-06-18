import java.util.ArrayList;
import java.util.List;

import obpro.gui.BCanvas;

/*
 * Container.java
 * Created on 2011/07/28
 * Copyright(c) 2011 Yoshiaki Matsuzawa, Shizuoka University. All rights reserved.
 */

/**
 * @author macchan
 */
public class Container extends Component {

	private List<Component> children = new ArrayList<Component>();

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Container(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void addChild(Component child) {
		child.setContainer(this);
		children.add(child);
	}

	public void removeChild(Component child) {
		child.setContainer(null);
		children.remove(child);
	}

	public void clear() {
		for (Component child : children) {
			child.setContainer(null);
		}
		children.clear();
	}

	public void processOneStep(BCanvas canvas) {
		for (Component child : new ArrayList<Component>(children)) {
			child.processOneStep(canvas);
		}
	}

	public void draw(BCanvas canvas) {
		for (Component child : new ArrayList<Component>(children)) {
			child.draw(canvas);
		}
	}
}
