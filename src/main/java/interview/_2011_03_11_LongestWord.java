package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/*
 * 주어진 string 의 array에서
 * string 2개를 concat 하여 만들수 있고 string array에 속한 string 중
 * 가장 길이가 긴 것을 구한다.
 * empty string은 array에 존재하지 않는다고 가정한다.
 * ex) input : {test, tester, testertest, testing, testingtester }
 *     output : testingtester
 */
public class _2011_03_11_LongestWord {
	public static String longestWord(String[] word) {
		return longestWord3(word);
	}
	
	public static String longestWord1(String[] arr) {	
		int n = arr.length;
		
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < n; ++i)
			hs.add(arr[i]);
			
		String result = "";		
		for (int i = 0; i < n; ++i) {			
			for (int j = i; j < n; ++j) {
				String candidate1 = arr[i] + arr[j];
				String candidate2 = arr[j] + arr[i];
				
				if (candidate1.length() > result.length() && hs.contains(candidate1))
					result = candidate1;
				if (candidate2.length() > result.length() && hs.contains(candidate2))
					result = candidate2;
			}
		}
		return result;	
	}	
	
	////////////////////////////////////////////////////////
	public static String longestWord2(String[] arr) {
		int n = arr.length;
		String result = "";
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < n; ++i)
			hs.add(arr[i]);
		
		for (int i = 0; i < n; ++i) {
			int k = arr[i].length();
			if (k == 1)
				continue;
			
			for (int j = 1; j < k; ++j) {
				String sub1 = arr[i].substring(0,j);
				String sub2 = arr[i].substring(j);
				
				if(hs.contains(sub1) && hs.contains(sub2) && k > result.length()) {
					result = arr[i];
					break;
				}
			}
		}
		
		return result;
	}
	
	///////////////////////////////////////////////////////////////	
	public static String longestWord3(String[] word) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < word.length; ++i)
			list.add(word[i]);
		Collections.sort(list,new StrLenComparator());		
		
		HashSet<String> hs = new HashSet<String>();
		for (String s : list) {
			hs.add(s);
		}
		
		for (String w : list) {
			if(w.length() == 1)
				continue;
			
			for (int i = 1; i < w.length(); ++i) {
				String s1 = w.substring(0,i);
				String s2 = w.substring(i);
				
				if (hs.contains(s1) && hs.contains(s2))
					return w;
			}
		}
		return "";
	}
}

class StrLenComparator implements Comparator<String> {
	public int compare(String o1, String o2) {
		if(o1.length()==o2.length())
			return 0;
		if(o1.length()>o2.length())
			return -1;		
		return 1;
	}	
}

/*
 * 1.O(n^2 logn) solution
 * 2개를 concat 하는 것이므로 모든 경우를 다 해본다.
 * 경우의 수는 O(n^2)이고 한 경우가 array에 있는지 찾아보는 데에는 array를 sorting 했을 경우 logn이 걸린다.
 * 따라서 전체 시간은 O(n^2 logn) 이 된다.
 * 물론 search를 위해서 hash table을 쓰면 공간이 O(n) 필요하고 시간복잡도는 O(n^2)이 된다.
 * 
 * 2.O(dnlogn) solution ( d는 word의 평균 길이 )
 * 두개를 합쳐서 하나를 만들지 말고 하나를 쪼개서 생각해본다.
 * 각 word를 가능한 모든 pair의 조합으로 나누고
 * 예) : abcd 는 (a,bc),(ab,cd),(abc,d)
 * 각 조합의 구성 word가 모두 array 에 있는지 검사하여 가장 긴 것을 취한다.
 * 한 word의 평균 길이를 d라고 할때 search 해야 되는 경우의 수는 O(dn)이 되고
 * binary search를 할 경우 search에는 O(logn)이 소요되므로
 * 전체 성능은 O(dnlogn) 이 된다.
 * 이 경우에도 search를 위해 hash table을 쓰면 공간이 O(n) 필요하고 시간복잡도는 O(dn)이 된다.
 * 
 * 3.O(nlogn + dn) solution
 * 2번과 비슷하나 모든 경우를 살펴보지 않기 위해 array를 길이로 내림차순 정렬하고 시작한다.
 * 
 * **주의
 * word를 쪼갤 때 substring 말고 stringbuffer를 쓰는게 더 좋을 것 같다.
 * 그런데 stringbuffer의 removeAt()의 성능이 중요할 것 같은데..
 */
