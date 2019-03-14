package model;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import util.Collections2;

public class FileNode implements Node{
	private File file;
	private Node parent;
	
	public FileNode(File file, Node parent) {
		this.file = file;
		this.parent = parent;
	}

	public String getTitle() {
		return file.getName();
	}

	@Override
	public boolean isRoot() {
		return false;
	}

	@Override
	public boolean isLeaf() {
		return file.isFile();
	}

	@Override
	public Optional<Node> getParent() {
		return Optional.of(parent);
	}

	@Override
	public List<Node> getChildren() {
		List<File> fileList = Arrays.asList(file.listFiles());
		return Collections2.map(fileList, f -> new FileNode(f, this));
	}
}
