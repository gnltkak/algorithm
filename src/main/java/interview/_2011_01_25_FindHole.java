package interview;

import java.util.ArrayList;

import util.Bitmap;
import util.Util;

/*
 * input : integer array(size: 40억)-file에 기록되어 있음 , 모든 원소는 0 이상의 수
 * find : 32 bit integer가 표현할 수 있는 0이상의 수의 범위는 0~2^31-1 이다.
 * 이 범위에 있는 정수의 개수가 40억개가 넘으므로
 * 0~2^31-1 중 array에 존재하지 않는 값이 적어도 한개는 있다.
 * 이 값을 찾아야 한다. ( 아무거나 한개 찾으면 된다 )
 * constraint : 사용할 수 있는 메모리는 오직 10MB 뿐이다.
 * 
 */
public class _2011_01_25_FindHole {
	private static int checkBit = 8; //체크해야할 수의 범위가 2^checkBit 개수가 되면 체크한다. 
	private static int checkMask = 0xff; //2^checkBit - 1 로 해줘야 함.
	
	//precondition : array의 모든 원소는 0 이상의 수
	public static int findHole4n(int[] array) {
		//return doFindHole4n(array,0);
		return findHole2n_another(array);
	}

	private static int doFindHole4n(int[] array, int k) {		
		if(array.length==0)
			return 1<<(30-k);
		
		if(k==(31-checkBit))
		{			
			Bitmap bm = new Bitmap(1<<checkBit);
			for(int i=0;i<array.length;i++)
				bm.set(array[i]&checkMask);
			for(int i=0;i<array.length;i++)
			{
				if(!bm.isSet(array[i]&checkMask))
					return array[i];
			}
			return -1; //should never reach here
		}		
		
		ArrayList<Integer> zero = new ArrayList<Integer>(); //0으로 시작하는 것들
		ArrayList<Integer> one = new ArrayList<Integer>(); //1로 시작하는 것들

		//2개의 group으로 나눈다.
		int mask=1<<(30-k);
		for(int i=0;i<array.length;i++)
		{			
			if((array[i]&mask)==0)
				zero.add(new Integer(array[i]));
			else
				one.add(new Integer(array[i]));
		}
		
		if(zero.size()<one.size())
			return doFindHole4n(Util.integerArrListToIntArr(zero),k+1);
		else
			return doFindHole4n(Util.integerArrListToIntArr(one),k+1);		
	}
	
	public static int findHole2n(int[] array) {
		return findHole2n_another(array);
		/*
		int[] count = new int[Integer.MAX_VALUE/1000 + 1];
		for(int i=0;i<array.length;i++)
			count[array[i]/1000]++;
		
		int start = -1;
		for(int i=0;i<count.length;i++)
		{
			if(count[i]<1000)		
			{
				start = i*1000;
				break;
			}
		}
		
		int end = start + 999;
		if(end<0) //overflow 발생시
			end = Integer.MAX_VALUE;
		
		Bitmap bm = new Bitmap(end-start+1);
		for(int i=0;i<array.length;i++)
		{
			if(array[i]>=start && array[i]<=end)
				bm.set(array[i]-start);
		}
		
		for(int i=0;i<bm.size();i++)
		{
			if(!bm.isSet(i))
				return i+start;
		}
		
		return -1; //should never reach here!	
		*/	
	}
	
	/////////////////////////////////////////////////
	public static int findHole2n_another(int[] arr) {
		int mask = ((1<<17)-1)<<16;
		int[] cnt = new int[1<<16];
		for (int i = 0; i < arr.length; ++i)
			cnt[(arr[i]&mask)>>16]++;
		int k;
		for (k = 0; k < cnt.length; ++k)
			if (cnt[k] < (1<<16)) break;
		
		int[] cnt2 = new int[1<<16];
		for (int i = 0; i < arr.length; ++i) {
			if ((arr[i]&mask)>>16 == k)
				cnt2[arr[i]&(~mask)]++;
		}		
		for (int i = 0; i < cnt2.length; ++i) {
			if (cnt2[i] == 0)
				return (k<<16) + i;
		}
		
		return -1; // must not reach here!
	}
}

/*
 * 40억개의 정수가 적힌 파일을 만들기 귀찮았으므로 작은 size의 input으로 대체하여 풀었다[...]
 * 
 * 1.O(n) solution
 * 위에서 구현한 방법이다.
 * divide & conquer 로 푼다.
 * 우선 큰 인풋에 대해 생각하기 전에 작은 것부터 생각해보자.
 * counting을 우선 한번 한 뒤 최대 0~2^31-1 범위에서 루프를 돌면서 카운팅 값이 0 인 지점을 찾으면 된다.
 * 메모리를 보다 절약하기 위해 카운팅을 하지 않고 비트맵을 사용할 수 있다.
 * 그럴경우 bitmap에만 2GB(=2^31)/8 = 256MB의 메모리가 필요하게 된다.
 * (으아니 작은 인풋에 대해서도 제약조건을 만족시킬 수 없단 말인가!) 
 * 
 * 자 그렇다면 이것을 어떻게 감소시킬 수 있을 것인가.
 * 포인트는 0~2^31-1 의 범위를 보다 축소하는 것이다.
 * 이제 divide & conquer 를 해보자.
 * 파일로부터 정수를 하나씩 읽어들이면서 MSB에서 두번째 bit ( MSB는 부호를 나타내는데에 쓰이므로 ) 를 보고
 * 이것이 0인것과 1인 것으로 나누어 두 그룹을 만든다. 
 * 만약 해당 그룹에 hole이 없다면 그룹의 원소의 수가 2^29 이어야 한다.
 * 하지만 이 개수를 체크할 필요가 사실상 없고 두 그룹중 원소의 개수가 더 작은 것을 택하면 된다.
 * 그 그룹에 반드시 hole 이 있는 것이다.
 * 이런식으로 recursive 하게 범위를 계속 좁혀 나가다보면
 * bitmap의 공간소모와 좁혀진 array의 공간소모를 10MB가 감당할 수 있는 시점이 온다. 
 * 이 시점까지 임시 파일을 사용하여 두개의 그룹을 기록해나가면 된다.
 * 
 * 한가지 주의할 경계조건은
 * 모든 정수가 두 그룹중 하나로 모두 들어가는 경우이다.
 * 이렇게 되면 둘중 작은 그룹을 택했을 때, 
 * recursive call을 몇번을 반복해도 그룹의 크기가 0 이 되므로
 * counting을 아무것도 하지 않게 되어 에러값인 -1이 리턴된다.
 * 따라서 이 경우만 예외로 처리해주면 된다.
 * 
 * 이 솔루션의 경우 디스크 접근 횟수를 생각해보자. (최악의 경우를 가정)
 * 처음에 읽기를 n번, 두 그룹으로 나누면서 쓰기를 n번 한다. ( 2n )
 * 그 다음엔 읽기 n/2 , 쓰기 n/2 ( n )
 * ...
 * =2n ( 1 + 1/2 + 1/4 + 1/8 + ... 1/n )
 * 복잡한 수식을 생각할 필요없이 괄호 안을 무한등비급수라고 생각하고 upper bound 시키자. 
 * (사실 정확하게 등비급수의 합을 구해도 결과는 비슷하다 )
 * 그러면 디스크 접근 횟수는 약 4n 회가 된다.
 * 
 * 
 * 2.O(n) solution
 * 또다른 O(n) solution이다.
 * 그러나 디스크 접근을 2n 회만 한다.
 * 전체를 부분으로 쪼개서 접근하고, 카운팅 기법에 기반한 방법이다.
 * 순진하게 카운팅 하면 2^31 * 4 = 8GB 의 메모리가 필요하므로
 * 카운팅을 띄엄띄엄 해서 메모리 사용을 줄인다. ( 여기서는 1000분의 1로 줄여서 소모되는 메모리를 8MB로 줄여보자 )
 * 다시말해, 전체 int의 범위를 block 으로 나누고, 각 block에 몇개의 수가 속하는지 카운팅한다.
 * 즉, 0이 몇개, 1이 몇개, ... 2^31-1 이 몇개.. 이런식으로 카운팅하는 것이 아니라
 * 0~999 범위에 있는 수가 몇개
 * 1000~1999 범위에 있는 수가 몇개
 * 이런 식으로 1000개마다 카운팅을 띄엄띄엄 해서 * 
 * 엔트리 수를 1000분의 1로 줄이면 메모리 사용량은 8MB가 된다.
 * 
 * 이제 이렇게 띄엄띄엄 샜다면 카운팅 값을 살펴본다.
 * 카운팅 값이 1000보다 작다면 거기에 hole이 있는 것이다.
 * 어느 범위에 hole이 있는지 찾았다면 
 * 다시한번 파일을 쭉 훑으면서
 * hole이 있는 범위에 대해서 숫자 하나하나마다 존재유무를 기록한다. (bitmap 이용)
 * 이제 다시 이 bitmap을 훑어서 빈 곳이 있으면 그것이 답이된다.
 * 
 * 첫번째 솔루션과는 달리 이 솔루션으로는 hole중 가장 작은 값을 찾을 수 있다는 장점이 있다.
 * (k번째 작은 값도 손쉽게 찾을 수 있을 것이다)
 * (2012-03-17) 이건 아닌것 같다. 원소가 distinct 하다는 조건이 없기 때문이다.
 * 예를 들어 1만 1000개 있고 0~999 범위의 다른 수는 하나도 없다고 하면
 * 이 알고리즘이 0을 찾아주지는 못한다.
 */
