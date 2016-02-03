package interview;

/*
 * input : 각 단어가 공백으로 구분된 string. (char array) 
 *         공백은 각 단어 사이에 정확히 1개이며 heading, trailing white space는 없다.
 * find : 단어들을 뒤집을 것
 *        ex) "abc def 123." 이 input이면
 *            "123. def abc" 가 output 이어야 함
 * constraint : in-place로 할 것
 */
public class _2011_05_14_ReverseWord {
	public static void reverseWord(char[] arr) {
		reverseWord2(arr);
	}
	
	public static void reverseWord1(char[] arr) {
		int n = arr.length;
		reverse(arr,0,n-1);
		
		int i=0,j=0;
		while(i<n && j<n)
		{
			while(arr[j]!=' ')
			{
				j++;
				if(j==n)
					break;
			}			
			reverse(arr,i,j-1);
			
			j++;
			i=j;
		}
	}
	
	public static void reverseWord2(char[] str) {
		int n = str.length;
		reverse(str, 0 , n - 1);
		
		int s = 0, e = s;
		while (s < n) {
			while (e < n && str[e] != ' ')
				++e;
			reverse(str, s, e - 1);
			++e;
			s = e;
		}
	}
	
	private static void reverse(char[] arr,int l,int r) {
		for(int i=l;i<=(l+r)/2;i++)
		{
			char temp = arr[i];
			arr[i] = arr[l+r-i];
			arr[l+r-i] = temp;
		}
	}
}

/*
 * in-place 로 O(n)에 가능하다.
 * reverse 를 구현할때 조심하도록 하자.
 */
