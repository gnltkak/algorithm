package interview;

import java.util.ArrayList;

import util.Util;

/*
 * input : 2개의 sorting 된 integer array (편의상 숫자는 모두 0 이상의 수라고 가정하였다)
 * 두 array의 교집합(multiset)을 찾는 문제이다.
 * 중복된 원소는 여러번 출력해도 된다. 예를들어 {1,1,2} 와 {1} 의 교집합은 {1} 이라고 해도 되고 {1,1} 이라고 해도 된다.
 * 그러나 테스트의 편의성을 위해 다음과 같이 하도록 한다.
 * 예를들어 small array 가 {1,1,2} 이고 large array가 {1,2, ....... } 라면
 * 답으로 {1,2} 를 출력하는 것이 아니라 {1,1,2}를 출력해야 한다.
 * 두개의 array중 어느 한쪽이 매우 크다고 가정한다.
 * 큰 array에 대해서는 전처리가 가능하며 전처리 시간은 고려하지 않는다.
 * 또한, 그 큰 array를 메모리에 모두 올리면 메모리를 90% 정도 사용하기 때문에 메모리는 10%만 더 사용할 수 있다. 
 * 
 * solution은 파일 맨 하단에 주석으로 첨부한다. 
 */
public class _2011_01_17_Intersection {
	public static ArrayList<Integer> intersection(int[] small,int[] large) {
		//return getIntersectionNPlusM(small,large);
		return getIntersection(small,large);
	}
	
	//O(n+m) 구현
	public static ArrayList<Integer> getIntersectionNPlusM(int[] small,int[] large) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int s=0,l=0; //small,large array 용 finger
		
		while(s<small.length && l<large.length)
		{
			if(small[s]<large[l])
				s++;
			else if(large[l]<small[s])
				l++;
			else
			{
				result.add(new Integer(small[s]));
				s++;				
			}
		}		
		
		return result;
	}	
	
	//precondition : large is sorted
	public static ArrayList<Integer> getIntersection(int[] small, int[] large) {
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		
		int[] hashTable = new int[large.length / 10 + 1];
		preProcess(large,hashTable);		
		for(int i=0;i<small.length;i++)
		{
			if(isInLarge(large,small[i],hashTable))
				result.add(small[i]);						
		}
		return result;
	}

	//num이 large array에 존재하는지 검사한다. 
	private static boolean isInLarge(int[] large,int num, int[] hashTable) {		
	    int max = large[large.length-1];
        
        if(num>max) return false;
        
        int divider = max/hashTable.length + 1;
        //int divider = (int)Math.ceil((float)max/(float)hashTable.length); 이러면 안됨
                        
        int startIndex = hashTable[num/divider];
        if (startIndex == -1) return false;
        int endIndex = large.length - 1;
        int i = num/divider+1;
        while (i < hashTable.length && hashTable[i] == -1) ++i;
        if (i != hashTable.length) endIndex = hashTable[i] - 1;
        
        return (Util.binarySearch(large,num,startIndex,endIndex)!=-1);
	}

	//hash table을 만든다.
	private static void preProcess(int[] large, int[] hashTable) {		
		for(int i=0;i<hashTable.length;i++)
			hashTable[i] = -1;
		
		int max = large[large.length-1];
		int divider = max/hashTable.length + 1;
		//int divider = (int)Math.ceil((float)max/(float)hashTable.length); //이러면 안됨.
		for (int i = 0; i < large.length; ++i) {
			int tableIndex = large[i] / divider;
			if (hashTable[tableIndex] != -1)
				continue;
			hashTable[tableIndex] = i;
		}		
	}
}

/*
 * n,m은 두 array의 size(m이 큰 array)
 * solution 1 : O(nlogm)
 * small array를 한번씩 훑으면서 large array 에 있는지 찾아본다.
 * 
 * solution 2 : O(n+m)
 * 두 array가 모두 sorting 되어 있다는 성질을 이용하여 merge sort 와 비슷하게 진행한다.
 * 
 * solution 3 : O(m) (전처리) , O(n) (lookup?)
 * m이 매우 크다는 가정이므로 전처리는 large array에 대해서 해야 한다.
 * lookup을 빠르게 하려면 hash table을 쓸수밖에 없는데 
 * 메모리를 10%만 더 사용해야 하므로 large의 전체원소를 hash table에 넣을 수는 없다.
 * 그렇다면 large array가 sorting 되어 있다는 특성을 이용하자.
 * sorting 된 array에 대해서는 binary search가 가능하므로 hash table과 binary search를 섞어보자.
 * 
 * hash table을 large array에 특정 숫자가 있는지 없는지 lookup하는 용도로 쓰지 말고
 * 특정 숫자가 large array에 있는지 없는지를 알아보기 위해 어느 범위를 찾아봐야 하는지를 저장하도록 한다.
 * 다시 말해, 1번 솔루션이 매번 large array 전체를 binary search 했다면
 * 여기서는 search의 범위를 줄여주자는 것이다. (범위를 거의 상수로 만드는 게 목표)
 * 
 * hash table에 모든 원소를 저장하는 것이 아니라 large array의 index를 저장하도록 한다.
 * 0~99 범위의 숫자 중 가장 작은 숫자의 index 는 0번 slot에,
 * 100~199 범위의 숫자 중 가장 작은 숫자의 index는 1번 slot에 넣는 식이다.
 * 메모리를 10%정도만 더 사용할 수 있으므로 
 * hash table의 size는 large array의 size의 10분의1 로 해야한다.
 * 
 * 예를 들어 원소의 개수가 127개면 hash table의 size는 12(또는 13)가 되어야 한다.(여기서는 12 사용)
 * hash table size가 12라면 모든 원소를 이 12개의 범위로 묶을 수 있어야 한다는 뜻이 된다.
 * 여기서 잠깐 hash table의 key가 무엇이고 value가 무엇인지를 생각해보면
 * value는 large array의 index이고
 * key는 lookup을 원하는 숫자이다.
 * 즉, hash function은 key를 주면 이 key가 hash table의 몇번 entry를 봐야되는지 계산해줘야 한다.
 * 여기에서 적합한 hash function은 key를 뭔가로 나눈 몫을 취하는 것이다.
 * (그래야 hash table을 만들 수 있음)
 * 그럼 divider가 무엇이 되어야 할 것인가?
 * 여기서 고려해야 할 숫자는 large array의 maximum element이다(즉, 마지막 원소)
 * large array의 maximum element가 hash table의 마지막(혹은 그 이하) entry에 들어가야 한다.
 * hash table size가 12이고 large array의 maximum element가 139 라고 해보자
 * 139를 k로 나눈 몫이 11 이하가 되는 k를 찾으면 된다.
 * 139 = 11*q + R (R < 11)
 *     < 11*(q+1)
 * 로부터 139를 11로 나눈 몫에 +1을 한 수로 139를 나누면 몫이 10이하가 된다는 사실을 알 수 있다.
 * 즉, divider는 large_array_max / (table_size - 1) + 1 이 된다.
 * 사실 large_array_max / table_size + 1 로 해도 된다.
 * (이러면 max는 hash table의 마지막 entry가 커버하게 된다)
 * 
 * 일반화시켜 말하자면
 * a = bq + r ( r < q)
 * (b+1)q > a 가 성립한다는 것이다.
 *  
 * 1) 이 아이디어는 large array의 숫자들이 어느정도 uniform 하게 분포해야 동작한다
 * 2) 구현상 주의할 점 중 한가지는 주어진 숫자로 hash값을 계산했을 때
 *    이것이 hash table size를 넘어가는지 여부를 검사하는 것이다.
 * 3) 원소가 음수인 경우도 허용하게 되면 구현이 좀 더 복잡해진다.
 *   
 * 성능분석
 * hash table을 만드는 것은 O(m) 이다. 한번씩 쭉 훑으면 되니까.
 * lookup은 O(n) 이다. hash table의 slot 수가 m/10 이므로
 * large array의 숫자 분포가 고르다면 각 slot에는 10개정도의 숫자가 포함된다.
 * 10개의 숫자에서 binary search를 하는 시간은 상수시간이므로 lookup은 O(n)이 된다.
 * 
 * *사실 이 자료구조는 엄밀히 말해 hash table 이 아니다. hash table의 idea에서 출발했을 뿐.
 * *알고리즘을 생각할 때는 생각못한 boundary case 가 있었다. 
 * small array에 있는 값이 large array의 max값 보다 큰 경우이다.
 * 이 경우 hash table에서 찾으려고 하면 array out of bound 가 된다.
 * * hash table의 맨 마지막 slot 의 경우에도 boundary case 처리를 유의해야한다. 
 * (binary search의 범위를 결정할때)
 * 
 * 주의:중간중간 hash table의 entry가 빈 경우도 고려해야 한다!
 */
