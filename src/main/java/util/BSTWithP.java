package util;

public class BSTWithP {
	public BSTNodeWithP root;
	
	public BSTNodeWithP search(int value) {
		return doSearch(root,value);
	}

	private BSTNodeWithP doSearch(BSTNodeWithP root, int value) {
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
		doAdd(root,value);
	}

	private void doAdd(BSTNodeWithP root, int value) {
		if(this.root==null)
		{
			this.root = new BSTNodeWithP(value);
			return;
		}
		if(root.value == value)
			throw new RuntimeException("tree에 이미 값이 존재합니다.");
		if(value<root.value)
		{
			if(root.left==null)
			{
				BSTNodeWithP newNode = new BSTNodeWithP(value);
				newNode.parent = root;
				root.left = newNode;
			}
			else
				doAdd(root.left,value);
		}
		else
		{
			if(root.right==null)
			{
				BSTNodeWithP newNode = new BSTNodeWithP(value);
				newNode.parent = root;
				root.right = newNode;
			}
			else
				doAdd(root.right,value);
		}	
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		doToString(sb,root);
		return sb.toString();
	}

	private void doToString(StringBuffer sb, BSTNodeWithP root) {
		if(root==null)
			return;
		
		sb.append(root.toString()+"\n");
		doToString(sb,root.left);
		doToString(sb,root.right);
	}
}
