package model;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import util.Collections2;

public class FileRoot implements Node {
	public String getTitle() {
		return "This PC";
	}

	@Override
	public boolean isRoot() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public Optional<Node> getParent() {
		return Optional.empty();
	}

	@Override
	public List<Node> getChildren() {
		File[] roots = File.listRoots();
		List<File> rootList = Arrays.asList(roots);
		return Collections2.map(rootList, r -> new FileNode(r, this));
	}
}
