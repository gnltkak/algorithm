package util;

public class Bitmap {
	private int[] bitmap; //int는 32-bit 라고 가정
	private int mask = 0x1f; //맨 뒤 5bit를 취할때 사용
	private int size;
	
	public Bitmap(int size) {
		if(size<=0)
			throw new RuntimeException("size는 0보다 커야 합니다.");
		
		bitmap = new int[size/32 + 1]; //자동으로 0으로 초기화된다.
		this.size = size;
	}
	
	//1로 셋팅
	public void set(int i) { 
		if(i>=size)
			throw new RuntimeException("i는 size 보다 작아야 합니다.");
		bitmap[i>>>5] |= 1<<(i&mask);		
	}
	
	//0으로 셋팅
	public void reset(int i) { 
		if(i>=size)
			throw new RuntimeException("i는 size 보다 작아야 합니다.");
		bitmap[i>>>5] &= ~(1<<(i&mask));
	}	
	
	//1로 셋팅 되어있는지 여부를 리턴
	public boolean isSet(int i) {
		if(i>=size)
			throw new RuntimeException("i는 size 보다 작아야 합니다.");
		return ((bitmap[i>>>5]&(1<<(i&mask)))!=0);
	}
	
	//모든 bit를 0으로 set
	public void clear() {
		for(int i=0;i<bitmap.length;i++)
			bitmap[i] = 0;
	}
	
	public int size() {
		return size;
	}	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<size;i++)
		{	
			if(i%10==0)
			{
				if(i>0)
					sb.append('\n');
				sb.append("["+i+"~] ");				
			}			
			
			try {
				if(isSet(i))
					sb.append('1');
				else
					sb.append('0');	
			}
			
			catch(Exception e) {
				System.out.println(e.toString());
			}					
		}
		
		return sb.toString();
	}
}
