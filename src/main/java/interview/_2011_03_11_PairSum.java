package interview;

/*
 * input : integer array, integer s
 * find : 합이 s가 되는 array상의 모든 원소의 pair 구하기
 */
public class _2011_03_11_PairSum {

}

/*
 * 1.O(nlogn)
 * array를 sort 한다.
 * array를 훑으며 s-array[i] 가 있는지 binary search로 체크한다.
 * 하나의 pair가 무조건 2번씩 출력되는 문제가 있다.
 * 또한 input이 {5}인 경우 (5,5)가 출력되는 문제가 있다. 
 * 
 * 2.O(nlogn)
 * array를 sort한다.
 * array의 양쪽 끝에서 시작하는 finger를 둔다.( i,j )
 * i<j 인 동안 루프를 돈다.
 * arr[i]+arr[j]=s 이면 i++,j-- 시킨다.
 * j보다 작은 곳에는 더이상 arr[i] 의 짝이 없고 ( 있다고 해도 중복이다 )
 * i보다 큰 곳에는 더이상 arr[j]의 짝이 없기 때문이다.
 * 
 * arr[i]+arr[j]<s 이면 i++시키고
 * arr[i]+arr[j]>s  이면 j-- 시킨다.
 * solution 1 에서의 문제가 전혀 없다.
 */
