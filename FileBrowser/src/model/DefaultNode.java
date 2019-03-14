package model;

import java.util.ArrayList;
import java.util.Optional;

public class DefaultNode implements Node {
	private String title;
	private Optional<DefaultNode> parent;
	private ArrayList<DefaultNode> children;
	
	public DefaultNode(String title, ArrayList<DefaultNode> children) {
		this(title, null, children);
	}
	
	public DefaultNode(String title, DefaultNode parent, ArrayList<DefaultNode> children) {
		this.title = title;
		this.parent = Optional.ofNullable(parent);
		this.children = new ArrayList<>(children);
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public boolean isRoot() {
		return !parent.isPresent();
	}
	
	@Override
	public boolean isLeaf() {
		return children.isEmpty();
	}
	
	@Override
	public Optional<Node> getParent() {
		return parent.map((Node n) -> n);
	}
	
	@Override
	public ArrayList<Node> getChildren() {
		return new ArrayList<>(children);
	}
}
