package interview;

/*
 * input : decimal string - 예 : "2.345"
 * find : input을 binary representation으로 나타내기
 *        단, 소수부가 32자리가 넘어가면 ERROR 로 처리 (무한소수로 취급하는듯) 
 */
public class _2011_02_02_DecimalToBinary {
	public static String decimalToBinary(String decimal) {
		String[] token = new String[2];
		token[0] = decimal.substring(0,decimal.indexOf("."));
		token[1] = decimal.substring(decimal.indexOf(".")+1);
		int intPart = Integer.parseInt(token[0]);
		double floatPart = Double.parseDouble("0."+token[1]);
		
		StringBuffer sb = new StringBuffer();
		while(intPart>0)
		{
			sb.append(intPart%2);
			intPart /= 2;
		}
		sb.reverse();
		sb.append('.');
		
		int floatCnt = 0;
		while(true)
		{
			floatPart *= 2;				
			if(floatPart>=1)
			{
				sb.append('1');
				floatPart -= 1;
				if(floatPart==0)
					break;
			}
			else
				sb.append('0');
			floatCnt++;	
			if(floatCnt>32)
				return "ERROR!";
		}
		
		return sb.toString();
	}
}

/*
 * 음 그냥 수학시간에 배운것을 열심히 구현하면 된다.
 * 그런데 floating point 연산이 잘 동작하네... 오차가 좀 있을텐데.
 */
