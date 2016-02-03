package util;

public class BST {
	public BSTNode root;
	
	public BSTNode search(int value) {
		return doSearch(root,value);
	}

	private BSTNode doSearch(BSTNode root, int value) {
		if(root==null)
			return null;
		
		if(value == root.value)
			return root;
		
		if(value<root.value)
			return doSearch(root.left,value);
		else
			return doSearch(root.right,value);
	}
	
	public void add(int value) {
		root = doAdd(root,value);
	}

	private BSTNode doAdd(BSTNode root, int value) {
		if(root==null)
			return new BSTNode(value);
		if(root.value == value)
			throw new RuntimeException("tree에 이미 값이 존재합니다.");
		if(value<root.value)
			root.left = doAdd(root.left,value);
		else
			root.right = doAdd(root.right,value);
		
		return root;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		doToString(sb,root);
		return sb.toString();
	}

	private void doToString(StringBuffer sb, BSTNode root) {
		if(root==null)
			return;
		
		sb.append(root.toString()+"\n");
		doToString(sb,root.left);
		doToString(sb,root.right);
	}
}
