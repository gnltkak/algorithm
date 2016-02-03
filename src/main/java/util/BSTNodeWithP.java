package util;

public class BSTNodeWithP {
	public int value;
	public BSTNodeWithP parent = null;
	public BSTNodeWithP left = null;
	public BSTNodeWithP right = null;
	
	public BSTNodeWithP(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(address());
		sb.append(" [v="+value);
		sb.append(",p=");
		if(parent==null)
			sb.append("null");
		else
			sb.append(parent.address());
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
