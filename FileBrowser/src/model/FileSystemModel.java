package model;

public class FileSystemModel implements Model {
	private final FileRoot root = new FileRoot();

	public Node getRoot() {
		return root;
	}
}
