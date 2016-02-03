package util;

public class BSTNode {
	public int value;
	public BSTNode left = null;
	public BSTNode right = null;
	
	public BSTNode(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(address());
		sb.append(" [v="+value);
		sb.append(",l=");
		if(left==null)
			sb.append("null");
		else
			sb.append(left.address());
		
		sb.append(",r=");
		if(right==null)
			sb.append("null");
		else
			sb.append(right.address());
		sb.append("]");
		
		return sb.toString();
	}

	private String address() {
		return super.toString().split("@")[1];
	}
}
