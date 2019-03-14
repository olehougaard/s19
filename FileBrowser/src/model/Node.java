package model;

import java.util.List;
import java.util.Optional;

public interface Node {

	String getTitle();

	boolean isRoot();

	boolean isLeaf();

	Optional<Node> getParent();

	List<Node> getChildren();

}